package Users.Create.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserErrorResponse {

    @Setter
    private int statusCode;

    private String error;
    private Data data;

    @Getter
    public class Data{
        public String email;
    }
}
