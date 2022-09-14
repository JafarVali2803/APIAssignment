package Users.GetPost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class GetPostByUserIdResponse {

    @Setter
    private int statusCode;

    @JsonProperty("data")
    private Data[] data;
    private int total;
    private int page;
    private int limit;

    @Getter
    public static class Data {
        private String id;
        private String image;
        private int likes;
        private String[] tags;
        private String text;
        private Date publishDate;
        private Date updatedDate;
        private Owner owner;
    }

    @Getter
    public static class Owner {
        private String id;
        private String firstName;
        private String lastName;
    }

}

