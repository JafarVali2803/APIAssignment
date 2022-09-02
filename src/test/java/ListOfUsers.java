import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.fasterxml.jackson.annotation.JsonProperty;
import static io.restassured.RestAssured.given;
public class ListOfUsers {
 @Test
 public void shouldGetAllUsers() {

   given()
          .header("app-id","631039b2b2ee91048226aa57")
   .when()
           .get("https://dummyapi.io/data/v1/user?limit=10")
   .then()
           .statusCode(200)
           .log().body();
}

@Test
 public void shouldCreateUser() throws JsonProcessingException {
  CreateUserRequest createUserRequest = new CreateUserRequest();
  createUserRequest.setEmail("jafar343@gmail.com");
  createUserRequest.setFirstName("Jafar");
  createUserRequest.setLastName("juturu");

 ObjectMapper mapper = new ObjectMapper();
 //Converting the Object to JSONString
 String jsonString = mapper.writeValueAsString(createUserRequest);
 System.out.println(jsonString);
  given()
          .header("app-id","631039b2b2ee91048226aa57")
          .body(jsonString)
  .when()
          .post("https://dummyapi.io/data/v1/user/create")
  .then()
          .log().body()
          .statusCode(200);
}

@Test
 public void shouldGetUsersCreatedUnderAccount() {
  given()
          .header("app-id","631039b2b2ee91048226aa57")
  .when()
          .get("https://dummyapi.io/data/v1/user?created=1")
  .then()
          .statusCode(200)
          .log().body();
}

@Test
 public void shouldCreatePost() {
  given()
          .header("app-id","631039b2b2ee91048226aa57")
          .body("{\n" +
                  "\"text\": \"Testing\",\n" +
                  "\"image\": \"https://devops.com/software-testing-the-comeback-kid-of-the-2020s/\",\n" +
                  "\"likes\": 10,\n" +
                  "\"tags\": [\"test\",\"testing\"],\n" +
                  "\"owner\": \"63103c91c6272b736b08f095\"\n" +
                  "}")
  .when()
          .post("https://dummyapi.io/data/v1/post/create")
  .then()
          .log().body()
          .statusCode(200);
}
}
