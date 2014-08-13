package com.github.trickster88.services;

import com.github.trickster88.clients.WeatherServiceClient;
import com.github.trickster88.dao.WeatherServiceDAO;
import com.github.trickster88.domain.WeatherService;
import com.github.trickster88.jobs.WeatherServicePollingJob;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.inject.Provider;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.github.trickster88.util.QuartzUtil.*;
import static com.github.trickster88.util.QuartzUtil.resumeJob;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Maps.uniqueIndex;

@Service
public class WeatherClientsService implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(WeatherClientsService.class);

    private static final String WEATHER_SERVICE_CLIENT_JOB_GROUP = "weatherServiceClientJobGroup";
    private static final String WEATHER_SERVICE_CLIENT_TRIGGER_GROUP = "weatherServiceClientTriggerGroup";

    private static final String SYNC_SERVICE_SETTINGS = "SyncServiceSettings";
    private static final long SYNC_SETTINGS_JOB_DELAY = 5 * 1000L;

    private final WeatherServiceDAO weatherServiceDAO;
    private final Scheduler scheduler;
    private final Provider<WeatherServicePollingJob> pollingJobProvider;
    private final Map<String, WeatherServiceClient> weatherServiceClientIdx;

    private boolean isInitialized;
    private Map<String, WeatherService> currentJobsSettings;

    @Autowired
    public WeatherClientsService(Scheduler scheduler, List<WeatherServiceClient> serviceClients,
                                 Provider<WeatherServicePollingJob> pollingJobProvider,
                                 WeatherServiceDAO weatherServiceDAO)
    {
        this.scheduler = scheduler;
        this.pollingJobProvider = pollingJobProvider;
        this.weatherServiceDAO = weatherServiceDAO;
        this.weatherServiceClientIdx = uniqueIndex(serviceClients, new Function<WeatherServiceClient, String>() {
            @Override public String apply(WeatherServiceClient weatherServiceClient) {
                return weatherServiceClient.getServiceName();
            }
        });
    }

    @Transactional
    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        //TODO: hack to prevent double initialization from dispatcher-servlet context
        if(isInitialized) return;

        registerNewServiceClients();
        initServiceClientsJobs();
        createSyncSettingsJob(SYNC_SETTINGS_JOB_DELAY);

        isInitialized = true;
    }

    private void registerNewServiceClients() {
        Set<String> registeredServicesNames = createSettingsIdx(weatherServiceDAO.getAll()).keySet();
        Iterable<WeatherServiceClient> newServiceClients = filter(weatherServiceClientIdx.values(),
                                                                  isNotRegisteredServiceClient(registeredServicesNames));

        for(WeatherServiceClient newServiceClient : newServiceClients) {
            WeatherService serviceSettings = new WeatherService(newServiceClient.getServiceName(),
                                                                newServiceClient.getDefaultDelayInMilliseconds(),
                                                                newServiceClient.isActiveByDefault());
            weatherServiceDAO.add(serviceSettings);

            logger.info("Added settings for auto discovered new client: {}", serviceSettings);
        }
    }

    private Predicate<WeatherServiceClient> isNotRegisteredServiceClient(final Set<String> registeredServicesNames) {
        return new Predicate<WeatherServiceClient>() {
            @Override public boolean apply(WeatherServiceClient serviceClient) {
                return !registeredServicesNames.contains(serviceClient.getServiceName());
            }
        };
    }

    private void initServiceClientsJobs() {
        List<WeatherService> weatherServices = weatherServiceDAO.getAll();
        // For currently inactive clients we create jobs too
        pauseJobGroup(scheduler, WEATHER_SERVICE_CLIENT_JOB_GROUP);

        for(WeatherService serviceSettings : weatherServices) {
            // Check that client of this settings exist
            @Nullable WeatherServiceClient serviceClient = weatherServiceClientIdx.get(serviceSettings.getName());
            if(serviceClient == null) {
                throw new IllegalStateException("Client for service " + serviceSettings.getName() + "not found");
            }

            //TODO: think about how to make constructor assist injection in Spring without JavaConfig
            WeatherServicePollingJob serviceClientJob = pollingJobProvider.get();
            serviceClientJob.setServiceClient(serviceClient);

            String jobName = getJobName(serviceSettings);
            JobDetail serviceClientJobDetail = createJobDetail(serviceClientJob, "run", jobName,
                                                               WEATHER_SERVICE_CLIENT_JOB_GROUP);
            Trigger serviceClientTrigger = createSimpleTrigger(serviceSettings.getDelayInMilliseconds(),
                                                               getTriggerName(serviceSettings),
                                                               WEATHER_SERVICE_CLIENT_TRIGGER_GROUP);
            scheduleJob(scheduler, serviceClientJobDetail, serviceClientTrigger);
            if(serviceSettings.getActive()) {
                resumeJob(scheduler, jobName, WEATHER_SERVICE_CLIENT_JOB_GROUP);
            }
        }

        currentJobsSettings = createSettingsIdx(weatherServices);
    }

    private void createSyncSettingsJob(long delayInMilliseconds) {
        JobDetail serviceSettingsJob = createJobDetail(this, "syncServiceSettings", SYNC_SERVICE_SETTINGS + "Job");
        Trigger serviceSettingsTrigger = createSimpleTrigger(delayInMilliseconds, SYNC_SERVICE_SETTINGS + "Trigger");

        scheduleJob(scheduler, serviceSettingsJob, serviceSettingsTrigger);
    }

    /**
     * Use cases, when settings was added or deleted currently not supported. Only updates handled correctly.
     */
    @Transactional
    public void syncServiceSettings() {
        List<WeatherService> foundServicesSettings = weatherServiceDAO.getAll();
        for(WeatherService foundServiceSettings : foundServicesSettings) {
            @Nullable WeatherService currentJobSettings = currentJobsSettings.get(foundServiceSettings.getName());
            // Settings was added after app start
            if(currentJobSettings == null) continue;

            if(!foundServiceSettings.getDelayInMilliseconds().equals(currentJobSettings.getDelayInMilliseconds())) {
                String triggerName = getTriggerName(foundServiceSettings);
                Long newDelayInMs = foundServiceSettings.getDelayInMilliseconds();

                rescheduleJob(scheduler, triggerName, WEATHER_SERVICE_CLIENT_TRIGGER_GROUP, newDelayInMs);

                changeJobActiveState(foundServiceSettings, getJobName(currentJobSettings));
            } else if(!foundServiceSettings.getActive().equals(currentJobSettings.getActive())) {
                changeJobActiveState(foundServiceSettings, getJobName(currentJobSettings));
            }
        }

        currentJobsSettings = createSettingsIdx(foundServicesSettings);
    }

    private void changeJobActiveState(WeatherService foundServiceSettings, String jobName) {
        if(!foundServiceSettings.getActive()) {
            pauseJob(scheduler, jobName, WEATHER_SERVICE_CLIENT_JOB_GROUP);
        } else {
            resumeJob(scheduler, jobName, WEATHER_SERVICE_CLIENT_JOB_GROUP);
        }
    }

    private Map<String, WeatherService> createSettingsIdx(List<WeatherService> weatherServices) {
        return uniqueIndex(weatherServices, new Function<WeatherService, String>() {
            @Override public String apply(WeatherService weatherService) { return weatherService.getName(); }
        });
    }

    private String getJobName(WeatherService weatherService) { return weatherService.getName() + "Job"; }

    private String getTriggerName(WeatherService weatherService) { return weatherService.getName() + "Trigger"; }
}