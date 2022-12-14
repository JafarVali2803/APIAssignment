package IntegrationTests;

import Users.Create.CreatePostRequestBody;
import Users.GetPost.GetPostByUserIdResponse;
import Users.UsersClient;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PostTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreatePostAndGetPost() {

        CreatePostRequestBody createPostRequestBody =
                CreatePostRequestBody.builder().text("testing").image("https://devops.com/software-testing-the-comeback-kid-of-the-2020s")
                        .likes(10).tags("test").owner("631592864779a10fec06c398").build();

      String userId = usersClient.createPost(createPostRequestBody).getCreatePostResponseOwner().getId();

        GetPostByUserIdResponse getPostByUserIdResponse = UsersClient.getPost();

        //Need to pass user id implicity from get post response in the assert
        Assert.assertEquals(userId,"631592864779a10fec06c398");
    }
}
