package services;

import clients.HttpClient;
import clients.SimpleHttpClient;

public abstract class ConfigurableService {

    HttpClient httpClient;
    private Class<?> clazz;


    public ConfigurableService(final Class<?> clazz) {
        if (clazz == null) {
            this.clazz = getClass();
        } else {
            this.clazz = clazz;
        }
        httpClient = new SimpleHttpClient();
    }
}
