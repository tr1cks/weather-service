package com.github.tr1cks.weather.core.jpadao;

import com.github.tr1cks.weather.core.dao.ObservationDAO;
import com.github.tr1cks.weather.core.domain.Observation;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JPAObservationDAO extends AbstractJPADAO<Integer, Observation> implements ObservationDAO {

    public JPAObservationDAO() { super(Observation.class); }

    public JPAObservationDAO(EntityManager entityManager) { super(Observation.class, entityManager); }

    @Override public @Nullable Observation findByObservation(Observation observation) {
        return toSingleResult(entityManager.createQuery("from " +
                                                               "Observation as ob " +
                                                        "where " +
                                                               "ob.dateTime = :dateTime and " +
                                                               "ob.city = :city and " +
                                                               "ob.weatherService = :weatherService",
                                                        Observation.class)
                                           .setParameter("weatherService", observation.getWeatherService())
                                           .setParameter("city", observation.getCity())
                                           .setParameter("dateTime", observation.getDateTime())
                                           .getResultList());
    }

    @Override public List<Observation> getLatestObservationsForActiveCitiesAndServices() {
        return entityManager.createQuery("select " +
                                                "ob " +
                                         "from " +
                                               "Observation as ob " +
                                         "where " +
                                               "not exists (select " +
                                                                   "sub " +
                                                           "from " +
                                                                  "Observation sub " +
                                                           "where " +
                                                                  "sub.dateTime > ob.dateTime and " +
                                                                  "sub.city = ob.city and " +
                                                                  "sub.weatherService = ob.weatherService) and " +
                                               "ob.city.active = true and " +
                                               "ob.weatherService.active = true " +
                                         "order by ob.city.name, ob.weatherService.name",
                                         Observation.class)
                            .getResultList();
    }
}