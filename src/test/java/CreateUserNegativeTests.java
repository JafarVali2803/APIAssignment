import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreateUserErrorResponse;
import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserNegativeTests {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithExistingUser() {

        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().email("jafar7@gmail.com").build();

        //Act
        CreateUserErrorResponse userExpectError = usersClient
                .createUserExpectError(createUserRequestBody);

        //Assert
        Assert.assertEquals(userExpectError.getStatusCode(), 400);
        Assert.assertEquals(userExpectError.getData().getEmail(), "Email already used");
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidUser() {

        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().email("jafar7gmail.com").build();

        CreateUserErrorResponse userExpectError = usersClient
                .createUserExpectError(createUserRequestBody);

        Assert.assertEquals(userExpectError.getStatusCode(), 400);
        Assert.assertEquals(userExpectError.getData().getEmail(), "Path `email` is invalid (jafar7gmail.com).");

    }
}

