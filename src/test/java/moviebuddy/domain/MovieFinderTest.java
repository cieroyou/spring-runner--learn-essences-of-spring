package moviebuddy.domain;

import moviebuddy.MovieBuddyApplication;
import moviebuddy.MovieBuddyFactory;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieFinder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieFinderTest {
    // 테스트 대상을 함수에서 외부로 이동
    MovieBuddyApplication application = new MovieBuddyApplication();
    MovieFinder movieFinder = new MovieBuddyFactory().movieFinder();

    @Test
    void NotEmpty_directedBy() {
        List<Movie> result = movieFinder.directedBy("Michael Bay");
        assertEquals(3, result.size());
    }

    @Test
    void NotEmpty_ReleasedYearBy() {
        List<Movie> result = movieFinder.releasedYearBy(2015);
        assertEquals(225, result.size());
    }


}