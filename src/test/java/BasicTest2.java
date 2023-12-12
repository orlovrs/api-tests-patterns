import in.co.gorest.config.Config;
import in.co.gorest.services.RandomGenerator;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class BasicTest2 {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = Config.BASE_URL;
    }

    @Test
    public void getUsersList() {
        given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", Config.TOKEN))
                .when().get("/users")
                .then().log().all()
                .statusCode(200)
                .body("size()", is(10));
    }

    @Test
    public void createUser() {
        String json = "{" +
                "\"name\": \"Fr. Deeptiman Malik\"," +
                String.format("\"email\": \"test_%s@example.test\",", RandomGenerator.getAlphaNumeric()) +
                "\"gender\": \"female\"," +
                "\"status\": \"active\"" +
                "}";

        given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", Config.TOKEN))
                .body(json)
                .when().post("/users")
                .then().log().all()
                .statusCode(201)
                .body("id", notNullValue());
    }
}
