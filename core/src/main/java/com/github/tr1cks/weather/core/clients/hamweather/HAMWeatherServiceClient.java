package com.github.tr1cks.weather.core.clients.hamweather;

import com.github.tr1cks.weather.core.clients.WeatherServiceClient;
import com.github.tr1cks.weather.core.clients.hamweather.dto.CurrentWeather;
import com.github.tr1cks.weather.core.clients.hamweather.dto.Ob;
import com.github.tr1cks.weather.core.dao.WeatherServiceDAO;
import com.github.tr1cks.weather.core.domain.City;
import com.github.tr1cks.weather.core.clients.AbstractWeatherServiceClient;
import com.github.tr1cks.weather.core.domain.Observation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Date;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.singletonList;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class HAMWeatherServiceClient extends AbstractWeatherServiceClient implements WeatherServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(HAMWeatherServiceClient.class);

    public static final String SERVICE_NAME = "HAMWeatherService";
    public static final Long DEFAULT_DELAY_IN_MILLISECONDS = 30 * 1000L;

    //TODO: move to configs
    private static final String CLIENT_ID = "8nTvHGDF9FtFJGRvD68AY";
    private static final String CLIENT_SECRET = "2ubiwiPtMyn5Qw7jmIlRJPCdtFrSbbAZsaprHRH1";

    @Autowired public HAMWeatherServiceClient(WeatherServiceDAO weatherServiceDAO) {
        super(SERVICE_NAME, DEFAULT_DELAY_IN_MILLISECONDS, weatherServiceDAO, false);
    }

    //TODO: add validation by schema
    @Override protected Observation fetchCurrentWeather(City city) {
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        URI uri = UriComponentsBuilder.fromUriString("http://api.aerisapi.com/observations/{city}")
                                      .queryParam("client_id", CLIENT_ID)
                                      .queryParam("client_secret", CLIENT_SECRET)
                                      .buildAndExpand(city.getName() + ',' + city.getCountry().getAcronym())
                                      .encode()
                                      .toUri();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(APPLICATION_JSON);
        requestHeaders.setAccept(singletonList(APPLICATION_JSON));
        requestHeaders.setAcceptCharset(singletonList(UTF_8));

        ResponseEntity<CurrentWeather> responseEntity = template.exchange(uri, GET, new HttpEntity(requestHeaders),
                                                                          CurrentWeather.class);
        Observation observation = mapToObservation(responseEntity.getBody(), city);
        logger.debug("Obtained observation {}", observation);

        return observation;
    }

    private Observation mapToObservation(CurrentWeather currentWeather, City city) {
        Ob observationDTO = currentWeather.getResponse().getOb();

        Observation observation = new Observation();

        observation.setWeatherService(getWeatherService());
        observation.setCity(city);
        observation.setDateTime(new Date(observationDTO.getTimestamp() * 1000L));

        observation.setTemperature(observationDTO.getTempC());
        observation.setHumidity(observationDTO.getHumidity().byteValue());
        observation.setPressure(observationDTO.getPressureMB());

        observation.setWindSpeed(observationDTO.getWindKPH());
        observation.setWindDirection(observationDTO.getWindDir());
        observation.setWindDirectionInDegrees(observationDTO.getWindDirDEG());

        observation.setSunrise(new Date(observationDTO.getSunrise() * 1000L));
        observation.setSunset(new Date(observationDTO.getSunset() * 1000L));

        return observation;
    }
}