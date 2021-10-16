package moviebuddy.domain;

import moviebuddy.MovieBuddyFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeTest {

    @Test
    void equals_MovieFinderBean(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieBuddyFactory.class);
        MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);
        // 별도로 설정하지 않으면 디폴트로 빈은 싱글톤스코프로 생성되기 때문에 테스트는 통과한다.
        Assertions.assertEquals(movieFinder, applicationContext.getBean(MovieFinder.class));
    }
}
