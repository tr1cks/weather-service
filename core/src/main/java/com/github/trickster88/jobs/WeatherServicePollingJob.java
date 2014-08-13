package com.github.trickster88.jobs;

import com.github.trickster88.clients.WeatherServiceClient;

/**
 * Needed for dynamic proxy to support Provider<>.
 */
public interface WeatherServicePollingJob extends Runnable {
    @Override void run();

    void setServiceClient(WeatherServiceClient serviceClient);
}
