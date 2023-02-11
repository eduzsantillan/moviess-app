package dev.eduzsantillan.movies.movie;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping ("/")
    public List<Movie> getAllMovies() {
        return movieService.allMovies();
    }

    @GetMapping ("/{imdbId}")
    public Movie getSingleMovie(@PathVariable String imdbId) {
        return movieService.getMovieById(imdbId);
    }

}
