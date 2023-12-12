package in.co.gorest.controllers;

import in.co.gorest.api.ApiClient;
import in.co.gorest.api.requests.users.GetListRequest;
import in.co.gorest.api.requests.users.GetOneRequest;
import in.co.gorest.api.requests.users.PostRequest;
import in.co.gorest.model.domain.User;
import in.co.gorest.model.dto.PostUsersRequestDto;
import in.co.gorest.model.mappers.UsersMapper;
import io.restassured.response.ValidatableResponse;

// Save this version for reference
public class UsersController {
    private ApiClient apiClient;

    public UsersController(ApiClient client) {
        apiClient = client;
    }

    public ValidatableResponse getList() {
        GetListRequest request = new GetListRequest();
        return apiClient.execute(request);
    }

    public ValidatableResponse getOne(int id) {
        GetOneRequest request = new GetOneRequest(id);
        return apiClient.execute(request);
    }

    public ValidatableResponse create(User user) {
        PostUsersRequestDto dto = UsersMapper.map(user, PostUsersRequestDto.class);
        PostRequest request = new PostRequest(dto);
        return apiClient.execute(request);
    }
}