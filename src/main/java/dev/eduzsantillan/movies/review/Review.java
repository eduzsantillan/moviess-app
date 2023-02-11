package dev.eduzsantillan.movies.review;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@Document(collection = "review")
public class Review {

    @Id
    private ObjectId id;

    private String body;

    Review withBody(String body) {
        this.body = body;
        return this;
    }
}
