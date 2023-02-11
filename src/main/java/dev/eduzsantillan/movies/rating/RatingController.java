package dev.eduzsantillan.movies.rating;

import dev.eduzsantillan.movies.shared.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    @PostMapping("/")
    public ResponseEntity<BasicResponse> createReview(@RequestBody HashMap<String,String> payload) {

        try{
            ratingService.createRating(payload.get("imdbId"),
                    Integer.parseInt(payload.get("rating")),
                    payload.get("user"));
            return ResponseEntity.status(201).body(new BasicResponse("Rating created", "201"));
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(new BasicResponse(e.getMessage(), "500"));
        }

    }
}
