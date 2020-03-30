package clients;

import exceptions.HttpRequestException;
import helpers.ResponseHelper;

import java.util.Map;

/**
 * Interface implemented by classes that call RestAPI endpoints.
 */
public interface HttpClient {
    /**
     * HTTP GET requests.
     *
     * @param baseUri     base uri of the service.
     * @param path        feature path.
     * @param token       authentication token, if exist. Otherwise Null.
     * @param pathParams  Parameters of the path, if exist. Otherwise Null or empty Map.
     * @param queryParams Parameters of the query, if exist. Otherwise Null or empty Map.
     * @param headers     Headers of the request, if exist. Otherwise Null or Empty Map.
     * @return ResponseHelper instance.
     */
    ResponseHelper get(final String baseUri,
                       final String path,
                       final String token,
                       final Map<String, String> pathParams,
                       final Map<String, String> queryParams,
                       final Map<String, String> headers)
            throws HttpRequestException;
}
