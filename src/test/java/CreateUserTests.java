import Users.Create.CreateUserRequestBody;
import Users.UsersClient;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Spliterator;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
   //Arrange
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldCreateUser() {
       String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder()
                .firstName("jafar1").lastName("juturu1").email(email).build();
        //Act
       usersClient
               .createUser(createUserRequestBody)
                .then()
                .log().body()
       //Assert
                .statusCode(200)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo(email));
    }
}
