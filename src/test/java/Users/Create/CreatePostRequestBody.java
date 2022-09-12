package Users.Create;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Builder
public class CreatePostRequestBody {

    private String text;
    private String image;
    private int likes;
    private ArrayList<String> tags;
    private String owner;
}
