package moviebuddy;

import moviebuddy.domain.CsvMovieReader;
import moviebuddy.domain.MovieFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 객체를 생성하고 관리하는 역할
 */
@Configuration
public class MovieBuddyFactory {

    @Bean
    public MovieFinder movieFinder() {
        return new MovieFinder(new CsvMovieReader());
    }
}
