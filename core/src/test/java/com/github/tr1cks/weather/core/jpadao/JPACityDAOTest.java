package com.github.tr1cks.weather.core.jpadao;

import com.github.tr1cks.weather.core.domain.City;
import com.google.common.collect.Sets;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.*;

public class JPACityDAOTest extends AbstractJPADAOTest {

    @Test public void addAndRetrieve() throws Exception {
        addRussia();
        addGreatBritain();

        City london = addLondon(true);
        City yekaterinburg = addYekaterinburg(true);
        City moscow = addMoscow(false);
        flushAndClearUnitOfWork();

        assertCityEquals(london, cityDAO.get(london.getId()));
        assertCityEquals(moscow, cityDAO.get(moscow.getId()));
        assertCityEquals(yekaterinburg, cityDAO.get(yekaterinburg.getId()));
    }

    @Test public void findByName() throws Exception {
        addRussia();
        addGreatBritain();

        City london = addLondon(true);
        City yekaterinburg = addYekaterinburg(true);
        flushAndClearUnitOfWork();

        assertCityEquals(london, cityDAO.findByName(london.getName(), "Great Britain"));
        assertCityEquals(yekaterinburg, cityDAO.findByName(yekaterinburg.getName(), "Russia"));
    }

    @Test public void findActive() throws Exception {
        addRussia();
        addGreatBritain();

        City london = addLondon(true);
        City yekaterinburg = addYekaterinburg(true);
        addMoscow(false);
        flushAndClearUnitOfWork();

        Set<City> foundActiveCities = Sets.newHashSet(cityDAO.findActive());

        assertEquals(newHashSet(london, yekaterinburg), foundActiveCities);
    }

    private void assertCityEquals(City expected, @Nullable City actual) {
        assertNotNull(actual);

        assertEquals(expected.getId(), actual.getId());

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getCountry().getId(), actual.getCountry().getId());
        assertEquals(expected.getActive(), actual.getActive());
    }
}