package dev.eduzsantillan.movies.movie;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String imdbId) {
        return movieRepository.findByImdbId(imdbId).orElse(null);
    }

}
