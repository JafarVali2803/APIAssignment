import Users.Create.CreateUserRequestBody;
import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserNegativeTests {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowToCreateUserWithExistingUser() {

        String firstName = "jafar1";
        String lastName = "juturu1";
        String email = "jafar7@gmail.com";

        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody(firstName,lastName,email);
        usersClient
                .createUser(createUserRequestBody)
                .then()
                .log().body()
                .statusCode(400)
                .body("data.email",Matchers.equalTo("Email already used"));
    }
    @Test
    public void shouldNotAllowToCreateUserWithInvalidUser() {

        String firstName = "jafar1";
        String lastName = "juturu1";
        String email = "jafar7gmail.com";

        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody(firstName,lastName,email);
        usersClient
                .createUser(createUserRequestBody)
                .then()
                .log().body()
                .statusCode(400)
                .body("data.email", Matchers.equalTo("Path `email` is invalid (jafar7gmail.com)."));
    }
}
