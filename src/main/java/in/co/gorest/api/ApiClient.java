package in.co.gorest.api;

import in.co.gorest.api.requests.BaseRequest;
import in.co.gorest.config.Config;
import in.co.gorest.controllers.UsersController;
import in.co.gorest.model.domain.User;
import io.restassured.response.ValidatableResponse;

public class ApiClient {
    private String baseUrl = Config.BASE_URL;
    private User consumer;

    public UsersController users;

    public ApiClient(User consumer) {
        this.consumer = consumer;
        users = new UsersController(this);
    }

    private void authorize(BaseRequest request) {
        request.headers.put("Authorization", "Bearer " + this.consumer.getToken());
    }

    private void setDefaultHeaders(BaseRequest request) {
        request.headers.put("Content-Type", "application/json");
    }

    public ValidatableResponse execute(BaseRequest request) {
        setDefaultHeaders(request);
        authorize(request);
        return request.execute();
    }
}
