package com.github.trickster88.dao;

import com.github.trickster88.domain.WeatherService;

import javax.annotation.Nullable;
import java.util.List;

public interface WeatherServiceDAO extends DAO<Integer, WeatherService> {
    void add(WeatherService weatherService);

    List<WeatherService> findActive();

    @Nullable WeatherService findByName(String weatherServiceName);

    List<WeatherService> getAll();
}
