package com.github.tr1cks.weather.core.dao;

import com.github.tr1cks.weather.core.domain.WeatherService;

import javax.annotation.Nullable;
import java.util.List;

public interface WeatherServiceDAO extends DAO<Integer, WeatherService> {
    void add(WeatherService weatherService);

    List<WeatherService> findActive();

    @Nullable WeatherService findByName(String weatherServiceName);

    List<WeatherService> getAll();
}
