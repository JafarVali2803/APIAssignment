import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllUsers {

    //Arrange
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){

        usersClient = new UsersClient();
    }
    @Test
    public void shouldGetAllUsers() {
    //Act
       usersClient
               .getAllUsers()
                .then()

    //Assert
                .statusCode(200)
                .body("data", Matchers.hasSize(10))
                .body("data",Matchers.hasItem(Matchers.hasEntry("firstName","Friedrich-Karl")))
                .log().body();
    }

}
