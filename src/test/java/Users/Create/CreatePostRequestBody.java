package Users.Create;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
@Builder
public class CreatePostRequestBody {

    private String text;
    private String image;
    private int likes;
    private String tags;
    private String owner;
}
