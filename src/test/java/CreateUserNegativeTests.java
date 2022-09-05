import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserNegativeTests {
    @Test
    public void shouldNotAllowToCreateUserWithExistingUser() {
        String CreateUserReqBody = "{\n" +
                "    \"firstName\": \"jafar\",\n" +
                "    \"lastName\": \"juturu\",\n" +
                "    \"email\": \"jafar7@gmail.com\"\n" +
                "}";
        new UsersClient().createUser(CreateUserReqBody)
                .then()
                .log().body()
                .statusCode(200);
    }
    @Test
    public void shouldNotAllowToCreateUserWithInvalidUser() {
        String CreateUserReqBody = "{\n" +
                "    \"firstName\": \"jafar\",\n" +
                "    \"lastName\": \"juturu\",\n" +
                "    \"email\": \"jafar7gmail.com\"\n" +
                "}";
        new UsersClient().createUser(CreateUserReqBody)
                .then()
                .log().body()
                .statusCode(400)
                .body("data.email", Matchers.equalTo("Path `email` is invalid (jafar7gmail.com)."));
    }
}
