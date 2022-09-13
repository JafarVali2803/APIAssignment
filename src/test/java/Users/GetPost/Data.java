package Users.GetPost;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;

@Getter
public class Data {
    private String id;
    private String image;
    private int likes;
    private ArrayList<String> tags;
    private String text;
    private Date publishDate;
    private Date updatedDate;
    private Owner owner;
}
