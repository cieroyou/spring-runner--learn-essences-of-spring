package moviebuddy.domain;

import java.util.List;

public class JaxbMovieReaderTest {
    public static void main(String[] args){
        JaxbMovieReader movieReader = new JaxbMovieReader();
        List<Movie> movies = movieReader.loadMovies();
        // xml문서의 목록 개수와 같은지 확인
        MovieFinderTest.assertEquals(1375, movies.size());
    }

}
