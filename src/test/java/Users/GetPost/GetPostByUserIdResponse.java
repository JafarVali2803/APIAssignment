package Users.GetPost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
public class GetPostByUserIdResponse {

    @Setter
    private int statusCode;

    @JsonProperty("Data")
    private List<Data> dataList;
    private int total;
    private int page;
    private int limit;

    private Owner owner;
}

