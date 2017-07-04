package com.github.tr1cks.weather.core.dao;

import com.github.tr1cks.weather.core.domain.Country;

import javax.annotation.Nullable;

public interface CountryDAO extends DAO<Integer, Country> {
    void add(Country country);

    @Nullable Country findByName(String countryName);

    @Nullable Country findByAcronym(String countryAcronym);
}
