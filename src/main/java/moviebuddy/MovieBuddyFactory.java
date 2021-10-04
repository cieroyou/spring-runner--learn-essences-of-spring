package moviebuddy;

import moviebuddy.domain.CsvMovieReader;
import moviebuddy.domain.MovieFinder;

/**
 * 객체를 생성하고 관리하는 역할
 */
public class MovieBuddyFactory {
    public MovieFinder movieFinder() {
        return new MovieFinder(new CsvMovieReader());
    }
}
