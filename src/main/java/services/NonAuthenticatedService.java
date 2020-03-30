package services;

import exceptions.HttpRequestException;
import helpers.ResponseHelper;

import java.util.Map;

public abstract class NonAuthenticatedService extends ConfigurableService {

    public NonAuthenticatedService(final Class<?> clazz) {
        super(clazz);
    }


    public ResponseHelper get(String method, String message, String baseUri, String path, Map<String, String> pathParams, Map<String, String> queryParams, Map<String, String> headers)
            throws HttpRequestException {
        return httpClient.get(baseUri, path, null, pathParams, queryParams, headers);
    }
}
