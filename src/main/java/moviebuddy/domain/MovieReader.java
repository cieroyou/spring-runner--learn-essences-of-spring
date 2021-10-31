package moviebuddy.domain;

import moviebuddy.domain.Movie;

import java.util.List;

public interface MovieReader {
    String metadata = null;
    
    
    List<Movie> loadMovies();
}
