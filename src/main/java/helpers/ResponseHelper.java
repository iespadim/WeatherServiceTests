package helpers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

@Getter
@Builder(toBuilder = true)
public class ResponseHelper {

    private Response response;

    public String path(final String path) {
        return response.path(path).toString();
    }

    public <T> T get(final Class<T> classOfT) {
        if (classOfT == null) return null;
        return new Gson().fromJson(response.getBody().prettyPrint(), classOfT);
    }

    public ResponseHelper validateHttpStatusCode(final int expectedHttpStatusCode) {
        Assertions.assertNotNull(response, "Invalid response: [expected:not null, returned:null]");
        assertEquals(expectedHttpStatusCode, response.getStatusCode(),
                String.format("Invalid HTTP Status Code: [expected:%s, returned:%s]", expectedHttpStatusCode, response.getStatusCode()));
        return this;
    }

    public ResponseHelper validateResponseFieldValues(final Map<String, String> expectedFieldValues) {
        Assertions.assertNotNull(response, "Invalid response: [expected:not null, returned:null]");
        if (expectedFieldValues != null) {
            for (Map.Entry<String, String> entry : expectedFieldValues.entrySet()) {
                final String fieldName = entry.getKey();
                final String expected = entry.getValue();
                final String returned = response.path(entry.getKey()).toString();
                assertEquals(expected, returned,
                        String.format("Invalid field value: [field:%s, expected:%s, returned:%s]", fieldName, expected, returned));
            }
        }
        return this;
    }


    public ResponseHelper(Response response){
        this.response = response;
    }
}
