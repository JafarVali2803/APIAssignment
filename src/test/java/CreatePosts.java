import Users.Create.CreatePostRequestBody;
import Users.Create.Response.CreatePostResponse;
import Users.UsersClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

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

        CreatePostResponse createPostResponse = usersClient.createPost(createPostRequestBody);

        assertEquals(createPostResponse.getStatusCode(),200);
        Assert.assertNotNull(createPostResponse.getId());
        assertEquals(createPostResponse.getCreatePostResponseOwner().getId(),createPostRequestBody.getOwner());
        System.out.println("Test");
    }
}
