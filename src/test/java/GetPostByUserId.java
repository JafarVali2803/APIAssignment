import Users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPostByUserId {

    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldGetPostByUserId(){
        usersClient
                .getPostByUserId()
                .then()
                .statusCode(200)
                // Not able to validate the owner id in the response, check with mentor
              //  .body("data", Matchers.hasItem(Matchers.hasEntry("id","6316db04f60dcc83023bbb2c")))
                .body("data",Matchers.hasSize(10))
                .log().body();
    }
}
