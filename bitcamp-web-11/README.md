# web-11 : Spring + Mybatis 연동하기
- 기존에 직접 만든 SqlSessionFactoryBean 대신에 Mybatis가 제공하는 SqlSessionFactoryBean을 사용한다. 
- DB 커넥션풀은 Mybatis 대신에 스프링에서 관리한다. 
- 트랜잭션을 다룰 수 있도록 트랜잭션 관리자를 설정한다. 
- Proxy 패턴을 사용한 DAO 자동 생성 기능을 이용한다.

## Spring library 추가
- mvnrepository.com에서 "Mybatis spring"를 찾는다
- build.gradle 의존  라이브러리 정보를 추가
- 'gradle cleanEclipse'를 실행하여 기존 이클립스 설정을 제거한다.
- 'gradle eclipse'를 실행하여 이클립스 관련 설정 파일을 새로 만든다. 
- 이때 추가한 의존 라이브러리가 자동으로 다운로드 될 것이다.
- 웹 프로젝트를 refresh 하여 라이브러리 정보를 갱신한다.


## Mybatis에서 제공하는 SqlSessionFactoryBean 객체 사용하기
- 기존의 SqlSessionFacotryBean 대신에 Mybatis-Spring에서 제공하는 클래스 사용
- Mybatis를 Spring과 연동할 때 DataSource는 Spring 설정된 것을 사용해야 한다.
- Mybatis 설정 파일에 등록된 DataSource는 사용하지 않는다.

## Spring에 DataSource 등록하기
- mvnrepository.com에서 "commons dbcp"를 검색하여 라이브러리를 찾는다
- 라이브러리를 build.gradle 파일에 등록하고 gradle을 이용하여 가져온다.
- 웹 프로젝트를 refresh한다.  
- application-context.xml 스프링 설정 파일에 DataSource를 설정한다.
- Spring에서 DataSource를 설정할 때는 "Spring-jdbc" 라이브러리를 추가해야 한다.
- 트랜잭션 관리자도 Spring에 등록한다.

## DAO 구현체를 자동 생성하는 MapperScannerConfigurer 등록하기
- Mybatis에서 제공하는 DAO 구현체 자동 생성기를 등록하면 개발자가 DAO 클래스를 직접 작성할 필요가 없다.
- 대신 개발자는 DAO 인터페이스만 만들면 된다.

## 기존의 DAO 클래스를 인터페이스로 변경한다.
- 기존에 작성된 DAO 클래스를 인터페이스로 변경한다.
- 단, 인터페이스명과 SQL 맵퍼의 namespace가 같게 해야 한다.
- 인터페이스의 메서드명과 SQL의 id도 같아야 한다.
- 인터페이스의 메서드 파라미터는 한 개여야 한다. 
- 물론 메서드의 파라미터는 SQL의 파라미터타입과 같아야 한다.



## ApplicationContext 클래스 제거

## 우리가 작성한 애노테이션 제거한다.
  -@Component 제거, @Controller 제거, @Reposity 제거
  @Autowired 제거
  
## DAO와 페이지 컨트롤러에서 사용한 에노테이션 패키지를 변경한다.
- 스프링 애ㅔ노테이션으로 변경ㅎ나다.





