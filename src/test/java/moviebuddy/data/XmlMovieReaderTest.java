package moviebuddy.data;

import moviebuddy.MovieBuddyFactory;
import moviebuddy.MovieBuddyProfile;
import moviebuddy.domain.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@ActiveProfiles(MovieBuddyProfile.XML_MODE)
@SpringJUnitConfig(MovieBuddyFactory.class)
public class XmlMovieReaderTest {

    final XmlMovieReader movieReader;

    @Autowired
    public XmlMovieReaderTest(XmlMovieReader movieReader){
        this.movieReader = movieReader;
    }
    @Test
    void NotEmpty_LoadMovies() {
        List<Movie> movies = movieReader.loadMovies();
        // xml문서의 목록 개수와 같은지 확인
        Assertions.assertEquals(1375, movies.size());
    }

}
