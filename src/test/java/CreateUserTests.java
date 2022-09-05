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
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldCreateUser() {
        //  throws JsonProcessingException {
//  CreateUserRequest createUserRequest = new CreateUserRequest();
//  createUserRequest.setEmail("jafar343@gmail.com");
//  createUserRequest.setFirstName("Jafar");
//  createUserRequest.setLastName("juturu");
//
// ObjectMapper mapper = new ObjectMapper();
// //Converting the Object to JSONString
// String jsonString = mapper.writeValueAsString(createUserRequest);
// System.out.println(jsonString);

       String email = String.format("@gmail.com", UUID.randomUUID());
        String createUserReqBody = String.format("{\n" +
                "    \"firstName\": \"jafar\",\n" +
                "    \"lastName\": \"juturu\",\n" +
                "    \"email\": \"%s\"\n" +
                "}",email);
       usersClient
               .createUser(createUserReqBody)
                .then()
                .log().body()
                .statusCode(200)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo(email));
    }
}
