import in.co.gorest.api.ApiClient;
import in.co.gorest.controllers.UsersController;
import in.co.gorest.model.domain.User;
import in.co.gorest.model.domain.UsersManager;
import in.co.gorest.model.dto.PostUsersRequestDto;
import in.co.gorest.services.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

// 1. Extract all requests code to controllers
// 2. Introduce DTOs
// 3. Domain models
// 4. Builder
// 5. Manager addon
// 6. Mapper
// 7. Request objects
// 8. API Client
public class BasicTest2 {
    private ApiClient api;
    private User consumer;

    @BeforeEach
    public void setup() {
        consumer = UsersManager.getConsumer();
        api = new ApiClient(consumer);
    }

    @Test
    public void getUsersList() {
        api.users.getList()
                .statusCode(200)
                .body("size()", is(10));
    }

    @Test
    public void createUser() {
        User user = UsersManager.getMale();

        api.users.create(user)
                .statusCode(201)
                .body("id", notNullValue());
    }
}
