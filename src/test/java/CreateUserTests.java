import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreateUserResponse;
import Users.UsersClient;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Spliterator;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class CreateUserTests {
   //Arrange
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldCreateUser() {

        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();
        //Act
        CreateUserResponse createUserResponse = usersClient.createUser(createUserRequestBody);

       //Assert
        createUserResponse.assertUser(createUserRequestBody);

    }
}
