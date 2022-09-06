import Users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePostByPostId {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }
    @Test
    public void shouldDeleteThePostByPostId() {
        usersClient
                .deletePostByPostId()
                .then()
                .statusCode(200)
                .log().body()
                .body("id", Matchers.equalTo("60d21bf867d0d8992e610e98"));
    }


}
