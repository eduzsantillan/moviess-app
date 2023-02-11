    package dev.eduzsantillan.movies.review;

    import dev.eduzsantillan.movies.shared.BasicResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.HashMap;

    @RestController
    @RequestMapping("/api/reviews")
    public class ReviewController {

        @Autowired
        private ReviewService reviewService;


        @PostMapping("/")
        public ResponseEntity<BasicResponse> createReview(@RequestBody HashMap<String,String> payload) {

            try{
                reviewService.createReview(payload.get("imdbId"), payload.get("body"));
                return ResponseEntity.status(201).body(new BasicResponse("Review created", "201"));
            }catch (Exception e) {
                return ResponseEntity.internalServerError().body(new BasicResponse(e.getMessage(), "500"));
            }

        }
    }
