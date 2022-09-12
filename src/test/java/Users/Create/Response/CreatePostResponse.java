package Users.Create.Response;

import Users.Create.CreatePostRequestBody;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Date;

@Getter
public class CreatePostResponse {

    @Setter
    private int statusCode;

    private String id;
    private String image;
    private String likes;
    private String link;
    private ArrayList<String> tags;
    private String text;
    private Date publishDate;
    private Date updatedDate;

    @JsonProperty("owner")
    private CreatePostResponseOwner createPostResponseOwner;
}

