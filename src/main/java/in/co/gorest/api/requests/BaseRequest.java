package in.co.gorest.api.requests;

import in.co.gorest.config.Config;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseRequest {
    protected String method;
    protected String url;

    public Map<String, String> headers = new HashMap<>();
    protected Map<String, String> pathParams = new HashMap<>();
    protected Map<String, String> queryParams = new HashMap<>();

    protected Object body;

    public ValidatableResponse execute() {
        RequestSpecification request = given().log().all()
                .baseUri(Config.BASE_URL)
                .headers(headers)
                .pathParams(pathParams)
                .queryParams(queryParams);

        if (body != null) {
            request.body(body);
        }

        return request.when()
                .request(method, url)
                .then().log().all();
    }
}
