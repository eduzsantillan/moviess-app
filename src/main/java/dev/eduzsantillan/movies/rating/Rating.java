package dev.eduzsantillan.movies.rating;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rating")
public class Rating {

    @Id
    private ObjectId id;

    private int rating;

    private String user;

    Rating withRatingAndUser(int rating,String user){
        this.rating= rating;
        this.user= user;
        return this;
    }
}
