package com.github.tr1cks.weather.core.jobs;


import com.github.tr1cks.weather.core.clients.WeatherServiceClient;
import com.github.tr1cks.weather.core.dao.CityDAO;
import com.github.tr1cks.weather.core.dao.ObservationDAO;
import com.github.tr1cks.weather.core.domain.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class WeatherServicePollingJobImpl implements WeatherServicePollingJob {
    private final CityDAO cityDAO;
    private final ObservationDAO observationDAO;

    private WeatherServiceClient serviceClient;

    @Autowired public WeatherServicePollingJobImpl(CityDAO cityDAO, ObservationDAO observationDAO) {
        this.cityDAO = cityDAO;
        this.observationDAO = observationDAO;
    }

    @Transactional
    @Override public void run() {
        //TODO: add short-lived cache on CityDAO
        for(Observation observation : serviceClient.fetchCurrentWeather(cityDAO.findActive())) {
            // Observation may be already known
            if(observationDAO.findByObservation(observation) == null) {
                // We store old observations as historical data
                observationDAO.add(observation);
            }
        }
    }

    @Override public void setServiceClient(WeatherServiceClient serviceClient) { this.serviceClient = serviceClient; }
}