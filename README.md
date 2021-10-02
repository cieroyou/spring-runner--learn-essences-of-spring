# Learn Essence of Spring

Learn Essence of Spring 워크숍(강좌) 로 공부하는 프로젝트
오류가 있을 때 예외객체로 잡아서 외부로 전파하기 위해 사용됨

Movie : 생성자는 `private` 임 -> 외부에서 Movie 객체를 생성할 수 있도록 스태틱메서드(of) 를 제공함

run 메서드를 호출함

commandActions : 명령어별로 실행할 메서드를 정의함

세개의 명령어가 정의됨 :
- quit
- directedBy, 
- releasedYearB

ex) console 에 `directedBy Michael Bay` 를 입력하면 첫번재 인자를 명령어로 실행한다.

### Section 03 : JaxB를 이용한 xml파일 읽어오
`org.glassfish.jaxb:jaxb-runtime` 의존성 버전에 주의한다. 강의대로 `3.0.2` 를 사용하면 다음과 같은 `javax.xml.bind.JAXBException: Implementation of JAXB-API has not been found on module path or classpath. - with linked exception: [java.lang.ClassNotFoundException` 다음 에러가 발생하는데, `jakarta.xml.bind:jakarta.xml.bind-api'` 의존성이 없어서 발생하는 것이므로, 버전을 제거하던가 `2.3.4` 버전을 사용하도록 한다.



---
워크숍(강좌)에 대한 자세한 소개는 [여기](https://springrunner.dev/training/learn-essence-of-spring-workshop/) 에서 볼 수 있다.