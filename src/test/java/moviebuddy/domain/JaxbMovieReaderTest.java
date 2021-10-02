package moviebuddy.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JaxbMovieReaderTest {
    @Test
    void NotEmpty_LoadMovies() {
        JaxbMovieReader movieReader = new JaxbMovieReader();
        List<Movie> movies = movieReader.loadMovies();
        // xml문서의 목록 개수와 같은지 확인
        Assertions.assertEquals(1375, movies.size());
    }

}
