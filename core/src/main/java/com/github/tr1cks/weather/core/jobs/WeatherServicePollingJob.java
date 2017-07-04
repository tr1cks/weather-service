package com.github.tr1cks.weather.core.jobs;

import com.github.tr1cks.weather.core.clients.WeatherServiceClient;

/**
 * Needed for dynamic proxy to support Provider<>.
 */
public interface WeatherServicePollingJob extends Runnable {
    @Override void run();

    void setServiceClient(WeatherServiceClient serviceClient);
}
