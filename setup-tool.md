# 프로그래밍 준비
## 개발 도구 설치
- openjdk 10.0.1
- eclipse photon
- visul studio code
- git client
- scoop (package manager)
- scoop install gradle
- scoop install mariadb@10.3.7

## mysql 설정
```
//서버에 접속
> mysql -uroot -p
Enter password : (암호가 없기 때문에 엔터)

root 사용자의 암호 설정
mysql> update user set authentication_string=password('1111') where user='root';

암호 변경 후 권한 갱신
mysql> flush  privileges;
mysql> quit

다시 접속
>mysql -uroot -p
Enter password: 1111
```
애플리케이션에서 DB에 접속할 때 사용할 사용자를 추가한다.
mysql> create user 'study'@'localhost' identified by '1111';

study 사용자가 사용할 데이터베이스 생성
mysql> create database studydb character set utf8 collate utf8_general_ci;

studydb의 사용권한을 study 사용자에게 부여한다.
mysql> grant all privileges on studydb.* to 'study'@'localhost';


study 사용자로 접속한다.
mysql> quit 또는 exit
>mysql -ustudy -p
Enter password: 1111

```

study 사용자가 사용할 수 있는 데이터베이스 목록 보기.
mysql> show databases;

사용할 데이터베이스 선택
mysql> use studydb;

studydb에 존재하는 테이블 목록 보기
mysql> show tables;

studydb에 테이블 생성
=>bitcamp-sql/pms-ddl.sql 실행
mysql> SQL을 복사하여 붙여 넣는다.

```

## Tomcat 설치
```
1) 톰캣 다운로드
  tomcat.apache.org에서 다운로드

2) 톰캣 설치
 c://apps 폴더에 압축 푼다.

```


## eclipse 설정

```
워크스페이스 설정
 1) 문자 집합을 utf-8 로 설정한다.
     Preference/general/workspace/text file encoding 을 utf-8로 설정한다.
 2) 에디터 기본 환경 설정
     Preferences/General/Editior/Text Editors
     -탭 크기를 2 또는 4로 설정
     -insert spaces for tabs: 체크 (탭 누르면 4띄어쓰기)
     -show print margin: 한줄 크기는 80자 정도
     -show whitespace characters: 탭이나 공백에 대해 흐릿하게 표시.
         Carriage Return, Line Feed 체크 해제
         Transparency leve(투명도) 30 수정

 3) 자바 설정
    - Preferences/Java/Installed JREs : JDK 위치 지정하기 (10.0.1)
    - Code Style/Formatter
    - Compiler: 기본 컴파일 버전 설정 Use '--release' option 해제
 4) 웹 환경 설정
    - Preferences/Web css,html,jsp ->utf-8로 변경
 5) WAS 서버 환경 설정
    - Preferences/Server/Runtime Environments : 톰캣 서버 위치 설정   
       Add ->9.0 -> apps밑에 폴더 선택
 6) 애플리케이션을 배포하고 테스트할 톰캣 실행 환경 설정      
    - Server 뷰: 테스트용 실행 서버 추가 

```

## 웹 프로젝트 폴더 준비

```
1)예제 프로젝트 복사
   java106-java-project 를
   bitcamp-cloud-computing 폴더로 복사한다.

2) 프로젝트 폴더를 이클립스 프로젝트로 만든다.
   - 'gradle eclipse'를 실행하여 이클립스 설정 파일을 만든다.
   - .project, .classpath, .settings/

```




