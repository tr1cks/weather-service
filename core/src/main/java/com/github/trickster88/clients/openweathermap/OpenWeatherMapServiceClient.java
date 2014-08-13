package com.github.trickster88.clients.openweathermap;

import com.github.trickster88.clients.AbstractWeatherServiceClient;
import com.github.trickster88.clients.WeatherServiceClient;
import com.github.trickster88.clients.openweathermap.dto.CurrentWeather;
import com.github.trickster88.clients.openweathermap.dto.Sun;
import com.github.trickster88.clients.openweathermap.dto.Wind;
import com.github.trickster88.dao.WeatherServiceDAO;
import com.github.trickster88.domain.City;
import com.github.trickster88.domain.Observation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.collect.Lists.newLinkedList;
import static java.lang.String.format;
import static java.util.Collections.singletonList;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_XML;

@Component
public class OpenWeatherMapServiceClient extends AbstractWeatherServiceClient implements WeatherServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(OpenWeatherMapServiceClient.class);

    public static final String SERVICE_NAME = "OpenWeatherMapService";
    public static final Long DEFAULT_DELAY_IN_MILLISECONDS = 30 * 1000L;

    //TODO: move to configs
    private static final String API_KEY = "f193df776fd8bdb81b989e6dd422767b";

    @Autowired public OpenWeatherMapServiceClient(WeatherServiceDAO weatherServiceDAO) {
        super(SERVICE_NAME, DEFAULT_DELAY_IN_MILLISECONDS, weatherServiceDAO, true);
    }

    //TODO: add validation by schema
    @Override protected Observation fetchCurrentWeather(City city) {
        RestTemplate template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        URI uri = UriComponentsBuilder.fromUriString("http://api.openweathermap.org/data/2.5/weather")
                                      .queryParam("q", city.getName() + ',' + city.getCountry().getAcronym())
                                      .queryParam("mode", "xml")
                                      .queryParam("lang", "ru")
                                      .queryParam("units", "metric")
                                      .queryParam("type", "accurate")
                                      .build(true).toUri();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(APPLICATION_XML);
        requestHeaders.setAccept(singletonList(APPLICATION_XML));
        requestHeaders.setAcceptCharset(singletonList(UTF_8));
        requestHeaders.set("x-api-key", API_KEY);

        ResponseEntity<CurrentWeather> responseEntity = template.exchange(uri, GET, new HttpEntity(requestHeaders),
                                                                          CurrentWeather.class);
        Observation observation = mapToObservation(responseEntity.getBody(), city);
        logger.debug("Obtained observation {}", observation);

        return observation;
    }

    private Observation mapToObservation(CurrentWeather currentWeather, City city) {
        Observation observation = new Observation();

        observation.setWeatherService(getWeatherService());
        observation.setCity(city);
        observation.setDateTime(currentWeather.getLastupdate().getValue());

        observation.setTemperature(currentWeather.getTemperature().getValue());
        observation.setHumidity(currentWeather.getHumidity().getValue());
        observation.setPressure(currentWeather.getPressure().getValue());

        Wind windDTO = currentWeather.getWind();
        observation.setWindSpeed(windDTO.getSpeed().getValue());
        observation.setWindDirection(windDTO.getDirection().getCode());
        observation.setWindDirectionInDegrees(windDTO.getDirection().getValue());

        Sun sunDTO = currentWeather.getCity().getSun();
        observation.setSunrise(sunDTO.getRise());
        observation.setSunset(sunDTO.getSet());

        return observation;
    }
}