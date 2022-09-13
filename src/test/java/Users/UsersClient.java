package Users;

import Users.Create.CreatePostRequestBody;
import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreatePostResponse;
import Users.Create.Response.CreateUserErrorResponse;
import Users.Create.Response.CreateUserResponse;
import Users.GetPost.GetPostByUserIdResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public static CreateUserResponse createUser(CreateUserRequestBody createUserReqBody) {
        Response response = create(createUserReqBody);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectError(CreateUserRequestBody createUserRequestBody){
        Response response = create(createUserRequestBody);
        CreateUserErrorResponse createUserErrorResponse = response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.getStatusCode());
        return createUserErrorResponse;
    }

    public static Response create(CreateUserRequestBody createUserReqBody) {
        Response response =
                given()
                    .header("app-id", "631039b2b2ee91048226aa57")
                    .contentType("application/json")
                    .body(createUserReqBody)
                .when()
                    .post("https://dummyapi.io/data/v1/user/create");

        response
                .then()
                    .log().body();
        return response;
    }

    public static Response getAllUsers() {
        return
                given()
                    .header("app-id", "631039b2b2ee91048226aa57")
                .when()
                    .get("https://dummyapi.io/data/v1/user?limit=10");
    }
    public static Response getUsersUnderAccount() {
        return
                given()
                    .header("app-id", "631039b2b2ee91048226aa57")
                .when()
                    .get("https://dummyapi.io/data/v1/user?created=1");
    }

    public static CreatePostResponse createPost(CreatePostRequestBody createPostRequestBody) {
        Response response = createPostObject(createPostRequestBody);
        CreatePostResponse createPostResponse = response.as(CreatePostResponse.class);
        createPostResponse.setStatusCode(response.getStatusCode());
        return createPostResponse;
    }

    private static Response createPostObject(CreatePostRequestBody createPostRequestBody) {
        Response response =
                given()
                   .header("app-id", "631039b2b2ee91048226aa57")
                   .contentType("application/json")
                   .body(createPostRequestBody)
                .when()
                   .post("https://dummyapi.io/data/v1/post/create");
        response
                .then()
                   .log().body();

        return response;

    }

    public static Response getPostByUserId() {
        return given()
                .header("app-id", "631039b2b2ee91048226aa57")
                .param("limit", "10")
                .when()
                .get("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109ca/post?limit=10");
    }
    public static Response deletePostByPostId() {
        return given()
                .header("app-id", "631039b2b2ee91048226aa57")
                .when()
                .delete("https://dummyapi.io/data/v1/post/60d21bf867d0d8992e610e98");
    }

    public static GetPostByUserIdResponse getPost(String userId) {
        Response response =
          given()
                .param("limit", 10)
                .header("app-id", "631039b2b2ee91048226aa57")
          .when()
                .get("https://dummyapi.io/data/v1/user/{userId}/post?limit=10");
        response
          .then()
                .log().body();

              int statusCode =  response.statusCode();

        GetPostByUserIdResponse getPostByUserIdResponse = response.as(GetPostByUserIdResponse.class);
        getPostByUserIdResponse.setStatusCode(statusCode);

        return getPostByUserIdResponse;
    }
}

