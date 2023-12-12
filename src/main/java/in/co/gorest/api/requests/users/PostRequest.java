package in.co.gorest.api.requests.users;

import in.co.gorest.api.requests.BaseRequest;
import in.co.gorest.model.dto.PostUsersRequestDto;

public class PostRequest extends BaseRequest {
    public PostRequest(PostUsersRequestDto dto) {
        method = "POST";
        url = "/users";
        body = dto;
    }
}