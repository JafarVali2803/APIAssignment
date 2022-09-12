package Users.Create.Response;

import Users.Create.CreateUserRequestBody;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class CreateUserResponse {

    @Setter
    private int statusCode;

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String registerDate;
    private String updatedDate;

    public void assertUser(CreateUserRequestBody createUserRequestBody) {
        assertEquals(this.getStatusCode(),200);
        assertNotNull(this.getId());
        assertEquals(this.getEmail(),createUserRequestBody.getEmail());
        assertEquals(this.getFirstName(),createUserRequestBody.getFirstName());
        assertEquals(this.getLastName(),createUserRequestBody.getLastName());
    }
}
