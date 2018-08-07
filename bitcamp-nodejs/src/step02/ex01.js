// 주졔 : 데이터베이스 프로그래밍 - 모듈 준비
//
// DBMS와 연동하여 데이터를 처리하려면
// 먼저 그 DBMS와 연결할 수 있는 module을 가져와야 한다.
//
// 0) package.json 파일 생성
//    > npm init
//
// 1) DBMS 모듈 설치
//    > npm install 모듈명
//    > npm install mysql --save
// 2) 모듈을 사용하여 프로그래밍
//    > const mysql = require('mysql');
const mysql = require('mysql');
console.log(mysql);


//nodejs는 단타성 업무에 쓴다.
//ex) 우편번호 찾기, 아이디중복검사, 대입지원