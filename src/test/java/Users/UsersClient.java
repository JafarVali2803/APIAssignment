package Users;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public static Response createUser(String createUserReqBody) {
        return
                given()
                    .header("app-id", "631039b2b2ee91048226aa57")
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
}

