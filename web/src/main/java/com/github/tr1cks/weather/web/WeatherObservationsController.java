package com.github.tr1cks.weather.web;


import com.github.tr1cks.weather.core.services.WeatherObservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class WeatherObservationsController {
    private final WeatherObservationsService weatherObservationsService;

    @Autowired public WeatherObservationsController(WeatherObservationsService weatherObservationsService) {
        this.weatherObservationsService = weatherObservationsService;
    }

    @RequestMapping(method = GET)
	public String showLatestWeatherObservations(ModelMap model) {
		model.addAttribute("observations", weatherObservationsService.getLatestObservationsForActiveCitiesAndServices());

        return "weatherObservations";
	}
}