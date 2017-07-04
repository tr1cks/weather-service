package com.github.tr1cks.weather.core.jpadao;

import com.github.tr1cks.weather.core.domain.Country;
import org.junit.Test;

import javax.annotation.Nullable;

import static org.junit.Assert.*;

public class JPACountryDAOTest extends AbstractJPADAOTest {

    @Test public void addAndRetrieve() throws Exception {
        Country russia = addRussia();
        Country greatBritain = addGreatBritain();
        flushAndClearUnitOfWork();

        assertCountryEquals(russia, countryDAO.get(russia.getId()));
        assertCountryEquals(greatBritain, countryDAO.get(greatBritain.getId()));
    }

    @Test public void findByName() throws Exception {
        Country greatBritan = addGreatBritain();
        flushAndClearUnitOfWork();

        assertCountryEquals(greatBritan, countryDAO.findByName("Great Britain"));
    }

    @Test public void findByAcronym() throws Exception {
        Country russia = addRussia();
        flushAndClearUnitOfWork();

        assertCountryEquals(russia, countryDAO.findByAcronym("ru"));
    }

    private void assertCountryEquals(Country expected, @Nullable Country actual) {
        assertNotNull(actual);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAcronym(), actual.getAcronym());
    }
}