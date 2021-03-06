package com.github.tr1cks.weather.core.jpadao;

import com.github.tr1cks.weather.core.dao.CityDAO;
import com.github.tr1cks.weather.core.domain.City;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JPACityDAO extends AbstractJPADAO<Integer, City> implements CityDAO {

    public JPACityDAO() { super(City.class); }

    public JPACityDAO(EntityManager entityManager) { super(City.class, entityManager); }

    @Override public List<City> findActive() {
        return entityManager.createQuery("from " +
                                                "City as c " +
                                         "where " +
                                                "c.active = true",
                                         City.class)
                            .getResultList();
    }

    @Override public @Nullable City findByName(String cityName, String countryName) {
        return toSingleResult(entityManager.createQuery("from " +
                                                              "City as c " +
                                                        "where " +
                                                               "c.name = :name",
                                                        City.class)
                                           .setParameter("name", cityName)
                                           .getResultList());
    }
}