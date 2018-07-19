# bitcamp-cloud-computing
비트캠프 클라우드 컴퓨팅 과정

## web-01 : 웹 프로젝트 폴더 준비
- gradle을 이용하여 프로젝트 폴더를 만드는 방법

## web-02 : 서블릿 + JDBC
- 서블릿으로 웹 애플리케이션을 만들고 배포하는 방법

## web-03 : JDBC
- JDBC를 이용하여 데이터를 다루는 방법

## web-04 : DAO + DTO(VO) + ServletContextListener
- 데이터 처리를 전문으로 하는 DAO 객체를 도입
- ServletContextListener에서 DAO 객체를 도입
- ServletContext 보관소에 DAO 객체를 저장한다.
- 서블릿은 Servlet

## web-05 : 서블릿 + DAO + JSP = MVC 아키텍처
- JSP 기술을 사용하여 출력을 단순화 하는 방법
- MVC 아키텍처의 개념


## web-06 : Front Controller 도입
- 서블릿들이 공통으로 수행하는 작업을 프론트 컨트롤러에게 맡긴다.
- 나머지 서블릿들은 Page Controller로 부른다.

## web-07 : Page Controller를 POJO로 변환
- 프론트 컨트롤러가 도입되면 페이지 컨트롤러는 일반 자바 객체로 만들어도 된다.
- 
- Page Controller는 POJO로 만들어도 된다.


# web-08 : 애노테이션으로 요청 핸들러 다루기
- 요청 핸들러(Request Handler) : 클라이언트 요청이 들어 왔을 때 호출되는 메서드.
  즉, 클라이언트 요청을 처리하는 메서드
- 인터페이스룰 구현하는 대신에 애노테이션으로 요청 핸들러를 표시하여 프론트 컨트롤러가 찾게 한다.
- 이렇게 함으로써 페이지 컨트롤러를 만들 때 특정 인터페이스에 종속되지 않게 한다.

# web-09 :객체 생성을 자동화 하기 위해 IoC 컨테이너를 만들기
- IoC 컨테이너를 통해 페이지 컨트롤러의 객체를 자동 생성한다.
- 페이지 컨트롤러의 의존 객체를 자동으로 주입한다.

# web-10 : Spring IoC 컨테이너 도입
- 기존 직접 만든 IoC 컨테이너 대신에 스프링 컨테이너를 사용한다.

# web-11 : Spring + Mybatis 연동하기
- 기존에 직접 만든 SqlSessionFactoryBean 대신에 Mybatis가 제공하는 SqlSessionFactoryBean을 사용한다. 
- DB 커넥션풀은 Mybatis 대신에 스프링에서 관리한다. 
- 트랜잭션을 다룰 수 있도록 트랜잭션 관리자를 설정한다. 
- Proxy 패턴을 사용한 DAO 자동 생성 기능을 이용한다.

# web-12 : Spring WebMVC의 ContextLoaderListener 사용하기
- 기존에 직접 만든 ContextLoaderListener 대신에 Spring WebMVC에서 제공하는 클래스를 사용한다.

# web-13 : Spring WebMVC의 DispatcherServlet 사용하기
- 기존에 직접 만든 DispatcherServlet 대신에 Spring WebMVC에서 제공하는 클래스를 사용한다.

# web-14 : JSP 경로를 /WEB-INF/ 폴더 아래로 옮긴다.
- WEB-INF 폴더 아래로 JSP를 옮기면 외부(클라이언트)에서 직접 요청할 수 없다.
- 이렇게 하면 JSP를 실행하기 위해 반드시 페이지 컨트롤러를 경유하도록 제안 할 수 있다.

# web-15 : 요청 핸들러의 파라미터와 리턴 값 다루기
- 요청 핸들러의 파라미터 다루기 
- 요청 핸들러의 리턴 다루기

# web-16 : 

## 패키지 생성
bitcamp.pms.servlet 패키지 생성

## 회원 관리 서블릿
- sevlet -api 의존 라이브러리 추가하기
    - mvnrepository.com에서 servlet -api 라이브러리 검색
    - bulid.gradle에 라이브러리 등록
    - 'gradle eclipse' 실행하여 .classpath 갱신
    - 이클립스 프로젝트 refresh
- mysql JDBC Driver 의존 라이브러리 추가하기
 bitcamp.pms.servlet.member 패키지 생성
MemberListServlet, MemberViewServlet, MemberAddServlet, MemberUpdateServlet

# bitcamp-web-02 : 서블릿
pms2_member 테이블에 대한 CRUD 서블릿을 만들기