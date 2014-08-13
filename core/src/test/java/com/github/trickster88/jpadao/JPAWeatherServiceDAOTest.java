package com.github.trickster88.jpadao;

import com.github.trickster88.clients.hamweather.HAMWeatherServiceClient;
import com.github.trickster88.clients.openweathermap.OpenWeatherMapServiceClient;
import com.github.trickster88.domain.WeatherService;
import org.junit.Test;

import javax.annotation.Nullable;

import java.util.List;

import static org.junit.Assert.*;

public class JPAWeatherServiceDAOTest extends AbstractJPADAOTest {

    @Test public void addAndRetrieve() throws Exception {
        WeatherService openWeatherService = addOpenWeatherService(true);
        flushAndClearUnitOfWork();

        assertWeatherServiceEqual(openWeatherService, weatherServiceDAO.get(openWeatherService.getId()));
        flushAndClearUnitOfWork();

        WeatherService hamWeatherService = addHAMWeatherService(false);
        flushAndClearUnitOfWork();

        assertWeatherServiceEqual(hamWeatherService, weatherServiceDAO.get(hamWeatherService.getId()));
        flushAndClearUnitOfWork();
    }

    @Test public void findActive() throws Exception {
        WeatherService openWeatherService = addOpenWeatherService(true);
        addHAMWeatherService(false);
        flushAndClearUnitOfWork();

        List<WeatherService> activeWeatherServices = weatherServiceDAO.findActive();
        assertEquals(1, activeWeatherServices.size());
        assertEquals(openWeatherService, activeWeatherServices.get(0));
    }

    @Test public void findByName() throws Exception {
        WeatherService openWeatherService = addOpenWeatherService(true);
        WeatherService hamWeatherService = addHAMWeatherService(false);
        flushAndClearUnitOfWork();

        assertEquals(openWeatherService, weatherServiceDAO.findByName(OpenWeatherMapServiceClient.SERVICE_NAME));
        assertEquals(hamWeatherService, weatherServiceDAO.findByName(HAMWeatherServiceClient.SERVICE_NAME));
    }

    private void assertWeatherServiceEqual(WeatherService weatherService, @Nullable WeatherService foundWeatherService) {
        assertNotNull(foundWeatherService);

        assertEquals(weatherService.getId(), foundWeatherService.getId());
        assertEquals(weatherService.getName(), foundWeatherService.getName());
        assertEquals(weatherService.getActive(), foundWeatherService.getActive());
        assertEquals(weatherService.getDelayInMilliseconds(), foundWeatherService.getDelayInMilliseconds());
    }
}