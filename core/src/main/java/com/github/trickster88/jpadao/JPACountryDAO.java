package com.github.trickster88.jpadao;

import com.github.trickster88.dao.CountryDAO;
import com.github.trickster88.domain.Country;

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