package com.github.tr1cks.weather.core.clients;

import com.github.tr1cks.weather.core.domain.City;
import com.github.tr1cks.weather.core.domain.Observation;

import java.util.List;

public interface WeatherServiceClient {

    List<Observation> fetchCurrentWeather(List<City> city);

    String getServiceName();

    Long getDefaultDelayInMilliseconds();

    boolean isActiveByDefault();
}
