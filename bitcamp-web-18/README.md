# web-18 : AJAX를 이용하여 Back-end 와 Front-end 분리하기
- JSP에서 HTML을 렌더링하는ㄷ ㅐ신에 HTMl의 자바스크립트를 이용하여 서버에서 
  데이터를 받아서 UI를 출력하는 방식으로 바꾼다.
  
## JSON 데이터 요청을 처리하는 프론트 컨트롤러 설정하기
- web.xml에 /json/* URL 요청을 처리할 프론트 컨트롤러를 추가한다.
- ContextLoadListener에서 관리하는 객체 중에 웹 관련 컴포넌트 들은 
   프론트 컨트롤러의 IoC 컨테이너가  관리하도록 이관한다.
- app-servlet.xml, json-servlet.xml 파일 생성
- web.xml에서 프론트 컨트롤러에 IoC 컨테이너 설정 파일을 등록한다. 

## 페이지 컨트롤러 추가
- *.json.MemberController 추가
- 페이지 컨트롤러를 @RestController로 선언했꼬
- 리턴 값으로 JSP URL 대신 데이터 객체를 리턴

### html
AJAX 기반 front-end 웹 페이지 작성
- html/member/list.html : AJAX 기반 회원 목록 페이지 출력 HTML 생성
- html/member/view.html : AJAX 기반 회원 상세 조회 페이지 출력 HTML 생성
- html/js/common.js : Query String 분석 함수 추가

### html2
mini jQuery 라이브러리 작성
- DOM API 랩퍼 함수 작성
- AJAX 랩 퍼 함수 작성
- Event 랩퍼 함수 작성

### html3
jQuery 적용
기존에 bit.js대신 jQuery 라이브러리를 적용한다.

### html4
Bootstrap 적용
- UI에 bootstrap 적용하기
- css 폴더를 만들어 공통 css 관리하기

### html5
HTML과 JavaScript 분리하기(회사 마다 다르지만 분리시키는게 좋다)
- 유지보수를 쉽게 만들기 위해  HTML과 자바스크립트 코드를 분리한다. 

### html6
모바일 웹 앱 배포 준비
- 외부 라이브러리(jQuery, bootstrap 등)를 모두 다운받아서 로컬로 가져온다.
- npm(node package)를 사용하여 외부 라이브러리르 가져온다.
- 작업
 - 'src/main/webapp/html6폴더에서 '①npm init'를 실행한다.(모두 엔터) : package.json 생성
   jquery 라이브러리 가져온다. : ②npm install jquery --save : package.json 빼고 두개 삭제 
   popper.js 라이브러리 가져온다. : ③npm install popper.js --save
   bootstrap 라이브러리 가져온다. : ④npm install bootstrap --save
 - node_modules 폴더를 삭제한 다음 'npm install'을 실행하면 자동으로 
    package.json에 등록한 모든 라이브러리를 가져온다.  
    
 모바일 앱에서   서버에 접속하려면 정확한 서버 주소를 입력해야 한다.
 왜? HTML, CSS, JavaScript가 서버와 같은 컴퓨터에 있는 것이 아니라 각각의 사용자 핸드폰에 있기 때문이다 
 - src/main/webapp/html6/js 폴더에 common.js을 만든다.
 - common.js에 서버 주소를 등록한다.
 - 나머지 모든 파일에서 AJAX 요청 주소를 변경한다. 
   
Phonegap을 이용하여 모바일 웹 앱 만들기 // 관리하기 어려우니 node package를 쓴다.
- ios/andriod phonegap 앱 설치

Cross Domain 설정
- @CrossOrigin 또는 <mvc-cors> 태그로 설정하기

### html7
템플릿 엔진 적용하여 HTML 태그를 생성한다.
- handlebars 라이브러리 가져오기
  - 'npm install handlebars --save'
- HTMl 페이지 라이브러리 삽입
  - <script src='...'></script>
- 자바스크립트에 적용하기
  - <script>