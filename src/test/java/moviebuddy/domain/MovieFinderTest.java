package moviebuddy.domain;

import moviebuddy.MovieBuddyApplication;
import moviebuddy.MovieBuddyFactory;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieFinder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(MovieBuddyFactory.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = MovieBuddyFactory.class)
class MovieFinderTest {

    // 3) 필드 주입방식
    @Autowired
    MovieFinder movieFinder;

    // 1) 생성자 주입 방식, movieFinder 멤버변수는 final 을 가지도록 한다.
//    @Autowired
//    MovieFinderTest(MovieFinder movieFinder){
//        this.movieFinder = movieFinder;
//    }

    // 2) setter 주입방식
//    @Autowired
//    void setMovieFinder(MovieFinder movieFinder){
//        this.movieFinder = movieFinder;
//    }
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