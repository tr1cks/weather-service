package com.github.tr1cks.weather.core.dao;

import com.github.tr1cks.weather.core.domain.Observation;

import javax.annotation.Nullable;
import java.util.List;

public interface ObservationDAO extends DAO<Integer, Observation> {
    void add(Observation observation);

    @Nullable Observation findByObservation(Observation observation);

    List<Observation> getLatestObservationsForActiveCitiesAndServices();
}
