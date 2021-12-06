package moviebuddy;

import moviebuddy.data.AbstractFileSystemMovieReader;
import moviebuddy.data.CsvMovieReader;
import moviebuddy.data.XmlMovieReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 객체를 생성하고 관리하는 역할
 */
@Configuration
@PropertySource("/application.properties")
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

//        @Profile(MovieBuddyProfile.CSV_MODE)
//        @Bean
//        public AbstractFileSystemMovieReader csvMovieReader() {
//            AbstractFileSystemMovieReader movieReader = new CsvMovieReader();
////            movieReader.setMetadata(environment.getProperty("movie.metadata"));
//            return movieReader;
//        }
//
//        @Profile(MovieBuddyProfile.XML_MODE)
//        @Bean
//        public AbstractFileSystemMovieReader xmlMovieReader(Unmarshaller unmarshaller) {
//            AbstractFileSystemMovieReader movieReader = new XmlMovieReader(unmarshaller);
////            movieReader.setMetadata(environment.getProperty("movie.metadata"));
//            return movieReader;
//        }
    }
}
