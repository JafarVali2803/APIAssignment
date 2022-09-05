import Users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
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
        String createUserReqBody = "{\\n\" +\n" +
                "                        \"    \\\"firstName\\\": \\\"jafar\\\",\\n\" +\n" +
                "                        \"    \\\"lastName\\\": \\\"juturu\\\",\\n\" +\n" +
                "                        \"    \\\"email\\\": \\\"jafar7@gmail.com\\\"\\n\" +\n" +
                "                        \"}";
       new UsersClient().createUser(createUserReqBody)
                .then()
                .log().body()
                .statusCode(200)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalTo("jafar7@gmail.com"));
    }
}
