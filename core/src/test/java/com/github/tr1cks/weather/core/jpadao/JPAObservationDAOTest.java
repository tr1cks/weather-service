package com.github.tr1cks.weather.core.jpadao;

import com.github.tr1cks.weather.core.clients.openweathermap.OpenWeatherMapServiceClient;
import com.github.tr1cks.weather.core.util.Asserts;
import com.github.tr1cks.weather.core.domain.Observation;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

import javax.annotation.Nullable;

import java.util.Date;
import java.util.List;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.*;

public class JPAObservationDAOTest extends AbstractJPADAOTest {
    private static DateTimeFormatter fmt = ISODateTimeFormat.dateHourMinuteSecond().withZoneUTC();

    @Test public void addAndRetrieveObservation() throws Exception {
        addRussia();
        addGreatBritain();

        addLondon(true);
        addMoscow(true);

        addOpenWeatherService(true);

        Observation londonObservation = addOpenWeatherServiceLondonObservation();
        Observation moscowObservation = addOpenWeatherServiceMoscowObservation();
        flushAndClearUnitOfWork();

        assertObservationEquals(londonObservation, observationDAO.get(londonObservation.getId()));
        assertObservationEquals(moscowObservation, observationDAO.get(moscowObservation.getId()));
    }

    @Test public void findByNewObservation() throws Exception {
        addGreatBritain();
        addRussia();

        addLondon(true);
        addMoscow(true);

        addOpenWeatherService(true);

        addOpenWeatherServiceMoscowObservation();
        flushAndClearUnitOfWork();

        assertNull(observationDAO.findByObservation(createLondonObservation()));
    }

    @Test public void findByExistingObservation() throws Exception {
        addGreatBritain();
        addLondon(true);
        addOpenWeatherService(true);

        Observation londonObservation = addOpenWeatherServiceLondonObservation();
        flushAndClearUnitOfWork();

        assertObservationEquals(londonObservation, observationDAO.findByObservation(createLondonObservation()));
    }

    //TODO: add more complicated tests for other use cases
    @Test public void getLatestObservationsForActiveCitiesAndServices() throws Exception {
        addGreatBritain();
        addRussia();

        addMoscow(true);
        addLondon(true);

        addOpenWeatherService(true);

        addOpenWeatherServiceLondonObservation();
        addOpenWeatherServiceMoscowObservation();

        Observation londonNewObservation = createLondonObservation(new Date());
        Observation moscowNewObservation = createMoscowObservation(new Date());
        observationDAO.add(londonNewObservation);
        observationDAO.add(moscowNewObservation);
        flushAndClearUnitOfWork();

        List<Observation> latestObservations = observationDAO.getLatestObservationsForActiveCitiesAndServices();
        assertEquals(2, latestObservations.size());

        assertEquals(newHashSet(latestObservations), newHashSet(londonNewObservation, moscowNewObservation));
    }


    //TODO: refactor me

    private Observation addOpenWeatherServiceLondonObservation() {
        Observation observation = createLondonObservation();

        observationDAO.add(observation);

        return observation;
    }

    private Observation createLondonObservation() {
        return createLondonObservation(fmt.parseDateTime("2014-08-10T12:09:17").toDate());
    }

    private Observation createLondonObservation(Date dateTime) {
        Observation observation = new Observation();

        observation.setDateTime(dateTime);
        observation.setCity(Asserts.notNull(cityDAO.findByName("London", "Great Britain")));
        observation.setWeatherService(Asserts.notNull(weatherServiceDAO.findByName(OpenWeatherMapServiceClient.SERVICE_NAME)));

        observation.setTemperature(20.21);
        observation.setHumidity((byte) 83);
        observation.setPressure(992.0);

        observation.setWindSpeed(7.7);
        observation.setWindDirection("SSW");
        observation.setWindDirectionInDegrees(200.0);

        observation.setSunrise(fmt.parseDateTime("2014-08-10T04:38:59").toDate());
        observation.setSunset(fmt.parseDateTime("2014-08-10T19:32:38").toDate());

        return observation;
    }

    private Observation addOpenWeatherServiceMoscowObservation() {
        Observation observation = createMoscowObservation();
        observationDAO.add(observation);

        return observation;
    }

    private Observation createMoscowObservation() {
        return createMoscowObservation(fmt.parseDateTime("2014-08-10T11:53:39").toDate());
    }

    private Observation createMoscowObservation(Date dateTime) {
        Observation observation = new Observation();

        observation.setDateTime(dateTime);
        observation.setCity(Asserts.notNull(cityDAO.findByName("Moscow", "Russia")));
        observation.setWeatherService(Asserts.notNull(weatherServiceDAO.findByName(OpenWeatherMapServiceClient.SERVICE_NAME)));

        observation.setTemperature(28.33);
        observation.setHumidity((byte) 47);
        observation.setPressure(1011.0);

        observation.setWindSpeed(4.0);
        observation.setWindDirection("NW");
        observation.setWindDirectionInDegrees(310.0);

        observation.setSunrise(fmt.parseDateTime("2014-08-10T01:52:38").toDate());
        observation.setSunset(fmt.parseDateTime("2014-08-10T17:17:01").toDate());


        return observation;
    }

    private void assertObservationEquals(Observation expected, @Nullable Observation actual) {
        assertNotNull(actual);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getDateTime(), actual.getDateTime());
        assertEquals(expected.getCity().getId(), actual.getCity().getId());
        assertEquals(expected.getWeatherService().getId(), actual.getWeatherService().getId());

        assertEquals(expected.getTemperature(), actual.getTemperature());
        assertEquals(expected.getHumidity(), actual.getHumidity());
        assertEquals(expected.getPressure(), actual.getPressure());

        assertEquals(expected.getWindSpeed(), actual.getWindSpeed());
        assertEquals(expected.getWindDirection(), actual.getWindDirection());
        assertEquals(expected.getWindDirectionInDegrees(), actual.getWindDirectionInDegrees());

        assertEquals(expected.getSunrise(), actual.getSunrise());
        assertEquals(expected.getSunset(), actual.getSunset());
    }
}