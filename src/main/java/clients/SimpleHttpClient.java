package clients;

import exceptions.HttpRequestException;
import helpers.ResponseHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SimpleHttpClient implements HttpClient {


    public ResponseHelper get(String baseUri, String path, String token, Map<String, String> pathParams, Map<String, String> queryParams, Map<String, String> headers)
            throws HttpRequestException {
        final RequestSpecification requestSpecification =
                buildRequestSpecification(baseUri, token, null, pathParams, queryParams, null, headers);
        try {
            final Response response = requestSpecification.get(path).then().log().all().extract().response();
            return new ResponseHelper(response);
        } catch (final Exception ex) {
            throw new HttpRequestException("Invalid GET Request", ex);
        }
    }


    private RequestSpecification buildRequestSpecification(String baseUri, String authToken, String messageBody, Map<String, String> pathParameters, Map<String, String> queryParameters, Map<String, String> formParameters, Map<String, String> headers) {
        RequestSpecification requestSpecification = given().baseUri(baseUri);

        if (formParameters != null && !formParameters.isEmpty())
            requestSpecification = requestSpecification.formParams(formParameters);

        if (pathParameters != null && !pathParameters.isEmpty())
            requestSpecification = requestSpecification.pathParams(pathParameters);

        if (queryParameters != null && !queryParameters.isEmpty())
            requestSpecification = requestSpecification.queryParams(queryParameters);

        if (authToken != null && !authToken.isEmpty())
            requestSpecification = requestSpecification.auth().preemptive().oauth2(authToken);

        if (headers != null && !headers.isEmpty())
            requestSpecification = requestSpecification.headers(headers);

        if (messageBody != null && !messageBody.isEmpty())
            requestSpecification = requestSpecification.body(messageBody);

        return requestSpecification.when().log().all();
    }
}
