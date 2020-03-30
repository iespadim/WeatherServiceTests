package clients;

import exceptions.HttpRequestException;
import helpers.ResponseHelper;

import java.util.Map;
import java.util.Optional;

public class AwaitableHttpClient implements HttpClient {

    private HttpClient httpClient = new SimpleHttpClient();

    @Override
    public ResponseHelper get(final String baseUri,
                              final String path,
                              final String token,
                              final Map<String, String> pathParams,
                              final Map<String, String> queryParams,
                              final Map<String, String> headers)
            throws HttpRequestException {
        return await(
                httpClient.get(baseUri, path, token, pathParams, queryParams, headers),500);
    }

    private ResponseHelper await(final ResponseHelper optional, final int time)
            throws HttpRequestException {
        if (optional != null)
            try {
                Thread.sleep(time);
            } catch (final InterruptedException ex) {
                throw new HttpRequestException(String.format("Request sleep for %dms failed", time), ex);
            }
        return optional;
    }
}
