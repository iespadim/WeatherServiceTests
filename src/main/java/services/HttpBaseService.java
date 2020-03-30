package services;

import exceptions.HttpRequestException;
import helpers.ResponseHelper;

import java.util.Map;

interface HttpBaseService {
    default ResponseHelper get(final String method,
                               final String message,
                               final String baseUri,
                               final String path,
                               final Map<String, String> headers)
            throws HttpRequestException {
        return get(method, message, baseUri, path, headers);
    }

    ResponseHelper get(final String method,
                       final String message,
                       final String baseUri,
                       final String path,
                       final Map<String, String> pathParams,
                       final Map<String, String> queryParams,
                       final Map<String, String> headers)
            throws HttpRequestException;
}
