package com.github.tr1cks.weather.core.services;

import com.github.tr1cks.weather.core.dao.ObservationDAO;
import com.github.tr1cks.weather.core.domain.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WeatherObservationsService {
    @Autowired private ObservationDAO observationDAO;

    @Transactional
    public List<Observation> getLatestObservationsForActiveCitiesAndServices() {
        return observationDAO.getLatestObservationsForActiveCitiesAndServices();
    }
}