package moviebuddy.domain;

import moviebuddy.MovieBuddyApplication;
import moviebuddy.MovieBuddyFactory;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieFinder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieFinderTest {

    final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieBuddyFactory.class);
    // 테스트 대상을 함수에서 외부로 이동
    MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);

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