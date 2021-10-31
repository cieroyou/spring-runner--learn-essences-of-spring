package moviebuddy;

import moviebuddy.data.AbstractFileSystemMovieReader;
import moviebuddy.data.CsvMovieReader;
import moviebuddy.data.XmlMovieReader;
import org.springframework.context.annotation.*;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * 객체를 생성하고 관리하는 역할
 */
@Configuration
@ComponentScan
public class MovieBuddyFactory {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("moviebuddy");
        return marshaller;
    }

    @Configuration
    static class DataSourceModuleConfig {
        @Profile(MovieBuddyProfile.CSV_MODE)
        @Bean
        public AbstractFileSystemMovieReader csvMovieReader() {
            AbstractFileSystemMovieReader movieReader = new CsvMovieReader();
            movieReader.setMetadata("movie_metadata.csv");
            return movieReader;
        }

        @Profile(MovieBuddyProfile.XML_MODE)
        @Bean
        public AbstractFileSystemMovieReader xmlMovieReader(Unmarshaller unmarshaller) {
            AbstractFileSystemMovieReader movieReader = new XmlMovieReader(unmarshaller);
            movieReader.setMetadata("movie_metadata.xml");
            return movieReader;
        }
    }
}
