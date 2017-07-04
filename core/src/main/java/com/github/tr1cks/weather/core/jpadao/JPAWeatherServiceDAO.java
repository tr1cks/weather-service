package com.github.tr1cks.weather.core.jpadao;

import com.github.tr1cks.weather.core.dao.WeatherServiceDAO;
import com.github.tr1cks.weather.core.domain.WeatherService;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JPAWeatherServiceDAO extends AbstractJPADAO<Integer, WeatherService> implements WeatherServiceDAO {

    public JPAWeatherServiceDAO() { super(WeatherService.class); }

    public JPAWeatherServiceDAO(EntityManager entityManager) { super(WeatherService.class, entityManager); }

    @Override public List<WeatherService> findActive() {
        return entityManager.createQuery("from " +
                                                "WeatherService as ws " +
                                         "where " +
                                                "ws.active = true",
                                         WeatherService.class)
                            .getResultList();
    }

    @Override public @Nullable WeatherService findByName(String serviceName) {
        return toSingleResult(entityManager.createQuery("from " +
                                                               "WeatherService as ws " +
                                                        "where " +
                                                               "ws.name = :serviceName",
                                                        WeatherService.class)
                                           .setParameter("serviceName", serviceName)
                                           .getResultList());
    }
}