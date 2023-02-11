package dev.eduzsantillan.movies.rating;

import dev.eduzsantillan.movies.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public void createRating(String imdbId, int rating, String user) {

        Rating ratingToSave = ratingRepository.insert(new Rating().withRatingAndUser(rating, user));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("ratingIds", ratingToSave.getId()))
                .first();
    }

}
