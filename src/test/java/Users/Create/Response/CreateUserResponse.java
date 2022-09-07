package Users.Create.Response;

import lombok.Getter;
import lombok.Setter;

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
}
