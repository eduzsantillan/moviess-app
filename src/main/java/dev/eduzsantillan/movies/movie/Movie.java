package dev.eduzsantillan.movies.movie;

import dev.eduzsantillan.movies.rating.Rating;
import dev.eduzsantillan.movies.review.Review;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document(collection = "movie")
public class Movie {

    @Id
    private ObjectId id;

    private String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds;

    @DocumentReference
    private List<Rating> ratingIds;

}
