package com.github.trickster88.dao;

import com.github.trickster88.domain.Observation;

import javax.annotation.Nullable;
import java.util.List;

public interface ObservationDAO extends DAO<Integer, Observation> {
    void add(Observation observation);

    @Nullable Observation findByObservation(Observation observation);

    List<Observation> getLatestObservationsForActiveCitiesAndServices();
}
