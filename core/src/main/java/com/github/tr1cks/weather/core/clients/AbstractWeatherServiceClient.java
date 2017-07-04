package com.github.tr1cks.weather.core.clients;

import com.github.tr1cks.weather.core.dao.WeatherServiceDAO;
import com.github.tr1cks.weather.core.domain.City;
import com.github.tr1cks.weather.core.domain.Observation;
import com.github.tr1cks.weather.core.domain.WeatherService;
import com.github.tr1cks.weather.core.util.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.google.common.collect.Lists.newLinkedList;
import static java.lang.String.format;

public abstract class AbstractWeatherServiceClient implements WeatherServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(AbstractWeatherServiceClient.class);

    protected final String serviceName;
    protected final Long defaultDelayInMilliseconds;
    protected final boolean activeByDefault;

    private final WeatherServiceDAO weatherServiceDAO;

    protected AbstractWeatherServiceClient(String serviceName, Long defaultDelayInMilliseconds,
                                           WeatherServiceDAO weatherServiceDAO, boolean activeByDefault)
    {
        this.serviceName = serviceName;
        this.defaultDelayInMilliseconds = defaultDelayInMilliseconds;
        this.activeByDefault = activeByDefault;

        this.weatherServiceDAO = weatherServiceDAO;
    }

    public WeatherService getWeatherService() {
        return Asserts.notNull(weatherServiceDAO.findByName(getServiceName()));
    }

    @Override public String getServiceName() { return serviceName; }

    @Override public Long getDefaultDelayInMilliseconds() { return defaultDelayInMilliseconds; }

    @Override public boolean isActiveByDefault() { return activeByDefault; }

    //TODO: add batching in clients implementations
    @Override public List<Observation> fetchCurrentWeather(List<City> cities) {
        List<Observation> observations = newLinkedList();
        for(City city : cities) {
            try {
                observations.add(fetchCurrentWeather(city));
            } catch(Exception exc) {
                logger.error(format("Error during access to %s for %s weather observation", getServiceName(),
                                                                                            city.getName()), exc);
            }
        }

        return observations;
    }

    protected abstract Observation fetchCurrentWeather(City city);
}
