import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePosts {
    @Test
    public void shouldCreatePost() {
        given()
                .header("app-id", "631039b2b2ee91048226aa57")
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
