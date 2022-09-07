package Users.Create.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreatePostResponse {

    @Setter
    private int statusCode;

    private String id;
    private String image;
    private String likes;
    private String link;
    private String text;
    private String publishDate;
    private String updatedDate;

    private CreatePostResponseOwner createPostResponseOwner;
}

