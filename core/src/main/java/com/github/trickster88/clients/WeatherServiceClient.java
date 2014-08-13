package com.github.trickster88.clients;

import com.github.trickster88.domain.City;
import com.github.trickster88.domain.Observation;

import java.util.List;

public interface WeatherServiceClient {

    List<Observation> fetchCurrentWeather(List<City> city);

    String getServiceName();

    Long getDefaultDelayInMilliseconds();

    boolean isActiveByDefault();
}
