package moviebuddy.domain;

import moviebuddy.MovieBuddyApplication;
import moviebuddy.MovieBuddyFactory;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieFinder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieFinderTest {
    public static void main(String[] args) {
        MovieBuddyApplication application = new MovieBuddyApplication();
        MovieFinder movieFinder = new MovieBuddyFactory().movieFinder();
        List<Movie> result = movieFinder.directedBy("Michael Bay");
        assertEquals(3, result.size());

        result = movieFinder.releasedYearBy(2015);
        assertEquals(225, result.size());
    }

    static void assertEquals(long expected, long actual) {
        if (expected != actual) {
            throw new RuntimeException(String.format("actual(%d) is different from the expected(%d)", actual, expected));
        }
    }

}