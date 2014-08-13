package com.github.trickster88.dao;

import com.github.trickster88.domain.Country;

import javax.annotation.Nullable;

public interface CountryDAO extends DAO<Integer, Country> {
    void add(Country country);

    @Nullable Country findByName(String countryName);

    @Nullable Country findByAcronym(String countryAcronym);
}
