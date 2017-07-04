package com.github.tr1cks.weather.core.jpadao;

import com.github.tr1cks.weather.core.clients.hamweather.HAMWeatherServiceClient;
import com.github.tr1cks.weather.core.clients.openweathermap.OpenWeatherMapServiceClient;
import com.github.tr1cks.weather.core.dao.CityDAO;
import com.github.tr1cks.weather.core.dao.CountryDAO;
import com.github.tr1cks.weather.core.dao.ObservationDAO;
import com.github.tr1cks.weather.core.dao.WeatherServiceDAO;
import com.github.tr1cks.weather.core.domain.City;
import com.github.tr1cks.weather.core.domain.Country;
import com.github.tr1cks.weather.core.domain.WeatherService;
import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;

import static com.github.tr1cks.weather.core.util.Asserts.notNull;
import static com.github.tr1cks.weather.core.util.EntityManagerFactoryHolder.getEntityManagerFactory;

public class AbstractJPADAOTest {
    protected EntityManager entityManager;

    //TODO: need something like mixins
    protected CountryDAO countryDAO;
    protected CityDAO cityDAO;
    protected WeatherServiceDAO weatherServiceDAO;
    protected ObservationDAO observationDAO;

    @Before public void setUp() throws Exception {
        entityManager = getEntityManagerFactory().createEntityManager();

        //TODO: need something like mixins
        cityDAO = new JPACityDAO(entityManager);
        weatherServiceDAO = new JPAWeatherServiceDAO(entityManager);
        observationDAO = new JPAObservationDAO(entityManager);
        countryDAO = new JPACountryDAO(entityManager);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().setRollbackOnly();
    }

    @After public void tearDown() throws Exception {
        flushAndClearUnitOfWork();

        if(entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }

        entityManager.clear();
        entityManager.close();
    }

    protected void flushAndClearUnitOfWork() {
        entityManager.flush();
        entityManager.clear();
    }

    //TODO: need something like mixins

    protected WeatherService addOpenWeatherService(boolean active) {
        return addWeatherService(OpenWeatherMapServiceClient.SERVICE_NAME,
                                 OpenWeatherMapServiceClient.DEFAULT_DELAY_IN_MILLISECONDS, active);
    }

    protected WeatherService addHAMWeatherService(boolean active) {
        return addWeatherService(HAMWeatherServiceClient.SERVICE_NAME,
                                 HAMWeatherServiceClient.DEFAULT_DELAY_IN_MILLISECONDS, active);
    }

    protected WeatherService addWeatherService(String serviceName, long delayInMilliseconds, boolean active) {
        WeatherService weatherService = new WeatherService(serviceName, delayInMilliseconds, active);
        weatherServiceDAO.add(weatherService);

        return weatherService;
    }

    protected Country addRussia() { return addCountry("Russia", "ru"); }

    protected Country addGreatBritain() { return addCountry("Great Britain", "gb"); }

    protected Country addCountry(String countryName, String countryAcronym) {
        Country greatBritain = new Country(countryName, countryAcronym);
        countryDAO.add(greatBritain);

        return greatBritain;
    }

    protected City addLondon(boolean active) {
        return addCity("London", notNull(countryDAO.findByName("Great Britain")), active);
    }

    protected City addMoscow(boolean active) {
        return addCity("Moscow", notNull(countryDAO.findByName("Russia")), active);
    }

    protected City addYekaterinburg(boolean active) {
        return addCity("Yekaterinburg", notNull(countryDAO.findByName("Russia")), active);
    }

    private City addCity(String cityName, Country country, Boolean active) {
        City city = new City(cityName, country, active);
        cityDAO.add(city);

        return city;
    }
}
