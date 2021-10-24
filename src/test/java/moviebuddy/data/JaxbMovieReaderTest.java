package moviebuddy.data;

import moviebuddy.MovieBuddyFactory;
import moviebuddy.data.JaxbMovieReader;
import moviebuddy.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(MovieBuddyFactory.class)
public class JaxbMovieReaderTest {

    final JaxbMovieReader jaxbMovieReader;

    @Autowired
    public JaxbMovieReaderTest(JaxbMovieReader movieReader){
        this.jaxbMovieReader = movieReader;
    }
    @Test
    void NotEmpty_LoadMovies() {
        JaxbMovieReader movieReader = new JaxbMovieReader();
        List<Movie> movies = movieReader.loadMovies();
        // xml문서의 목록 개수와 같은지 확인
        Assertions.assertEquals(1375, movies.size());
    }

}
