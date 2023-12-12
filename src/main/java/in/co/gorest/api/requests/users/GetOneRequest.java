package in.co.gorest.api.requests.users;

import in.co.gorest.api.requests.BaseRequest;

public class GetOneRequest extends BaseRequest {
    public GetOneRequest(int id) {
        super();
        method = "GET";
        url = "/users/{id}";
        pathParams.put("id", String.valueOf(id));
    }
}
