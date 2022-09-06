import Users.UsersClient;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePosts {

    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldCreatePost() {
        String createPostReqBody = "{\n" +
                "\"text\": \"Testing\",\n" +
                "\"image\": \"https://devops.com/software-testing-the-comeback-kid-of-the-2020s/\",\n" +
                "\"likes\": 10,\n" +
                "\"tags\": [\"test\",\"testing\"],\n" +
                "\"owner\": \"631592864779a10fec06c398\"\n" +
                "}";
      usersClient.createPost(createPostReqBody)
                .then()
                .log().body()
                .statusCode(200);
    }
}
