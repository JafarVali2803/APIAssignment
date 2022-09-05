import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.fasterxml.jackson.annotation.JsonProperty;
import static io.restassured.RestAssured.given;
public class GetAllUsers {
    @Test
    public void shouldGetAllUsers() {

        given()
                .header("app-id", "631039b2b2ee91048226aa57")
                .when()
                .get("https://dummyapi.io/data/v1/user?limit=10")
                .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(10))
                .body("data",Matchers.hasItem(Matchers.hasEntry("firstName","Friedrich-Karl")))
                .log().body();
    }

    @Test
    public void shouldGetUsersCreatedUnderAccount() {
        given()
                .header("app-id", "631039b2b2ee91048226aa57")
                .when()
                .get("https://dummyapi.io/data/v1/user?created=1")
                .then()
                .statusCode(200)
                .log().body();
    }
}
