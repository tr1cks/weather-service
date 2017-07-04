package com.github.tr1cks.weather.core.jpadao;

import com.github.tr1cks.weather.core.domain.Country;
import com.github.tr1cks.weather.core.dao.CountryDAO;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;

public class JPACountryDAO extends AbstractJPADAO<Integer, Country> implements CountryDAO {

    public JPACountryDAO() { super(Country.class); }

    public JPACountryDAO(EntityManager entityManager) { super(Country.class, entityManager); }

    @Override public @Nullable Country findByName(String countryName) {
        return toSingleResult(entityManager.createQuery("from " +
                                                              "Country as c " +
                                                        "where " +
                                                              "c.name = :name",
                                                        Country.class)
                                           .setParameter("name", countryName)
                                           .getResultList());
    }

    @Override public @Nullable Country findByAcronym(String countryAcronym) {
        return toSingleResult(entityManager.createQuery("from " +
                                                              "Country as c " +
                                                        "where " +
                                                              "c.acronym = :acronym",
                                                        Country.class)
                                           .setParameter("acronym", countryAcronym)
                                           .getResultList());
    }
}