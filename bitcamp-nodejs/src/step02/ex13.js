// 주졔 : 데이터베이스 프로그래밍 - insert 실행 후 auto_increment PK 컬럼 값 알아내기

const mysql = require('mysql');

var con = mysql.createConnection({
    host: '52.79.189.185', 
    database: 'studydb',
    user: 'study',
    password: '1111'
  });

con.connect(function(err){
    console.log('연결을 성공했습니다');//2
});

var title = '제목~';
var content = '내용~';

con.query(
    `insert into pms2_board(titl, cont, cdt) values(?,?,now())`, 
    [title, content],
    function(err, result){
    if (err) throw err;
    
    console.log("입력성공");
    console.log(result.insertId);

});


con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다.');//5
}); 
console.log('insert 실행!');//1



