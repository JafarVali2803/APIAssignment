import Users.Create.CreatePostRequestBody;
import Users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
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

        CreatePostRequestBody createPostRequestBody =
                CreatePostRequestBody.builder().text("testing").image("https://devops.com/software-testing-the-comeback-kid-of-the-2020s")
                        .likes(10).tags("test").owner("631592864779a10fec06c398").build();

        usersClient.createPost(createPostRequestBody)
                .then()
                .statusCode(200)
                .body("id", Matchers.notNullValue())
                .body("owner.id",Matchers.equalTo("631592864779a10fec06c398"));
    }
}
