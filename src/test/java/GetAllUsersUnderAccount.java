import Users.UsersClient;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersUnderAccount {

    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldGetUsersCreatedUnderAccount() {
     usersClient.getUsersUnderAccount()
                .then()
                .statusCode(200)
                .log().body();
    }
}
