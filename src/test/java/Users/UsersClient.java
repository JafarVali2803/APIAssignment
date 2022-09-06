package Users;

import Users.Create.CreateUserRequestBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public static Response createUser(CreateUserRequestBody createUserReqBody) {
        return
                given()
                    .header("app-id", "631039b2b2ee91048226aa57")
                    .contentType("application/json")
                    .body(createUserReqBody)
                .when()
                    .post("https://dummyapi.io/data/v1/user/create");
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

    public static Response createPost(String createPostReqBody) {
        return given()
                .header("app-id", "631039b2b2ee91048226aa57")
                .contentType("application/json")
                .body(createPostReqBody)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");
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
}

