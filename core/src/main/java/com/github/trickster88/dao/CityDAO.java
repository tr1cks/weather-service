package com.github.trickster88.dao;

import com.github.trickster88.domain.City;

import javax.annotation.Nullable;
import java.util.List;

public interface CityDAO extends DAO<Integer, City> {
    void add(City city);

    List<City> findActive();

    @Nullable City findByName(String cityName, String countryName);
}