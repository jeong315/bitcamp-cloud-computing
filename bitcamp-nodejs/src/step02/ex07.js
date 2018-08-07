// 주졔 : 데이터베이스 프로그래밍 - insert 실행

const mysql = require('mysql');

console.log(mysql);

var con = mysql.createConnection({
    host: '52.79.189.185', 
    database: 'studydb',
    user: 'study',
    password: '1111'
  });

con.connect(function(err){
    console.log('연결을 성공했습니다');//2
});

var email = 'user001@test.com';
var mid = 'user001';
var pwd = '1111';


con.query(
    `insert into pms2_member(email, mid, pwd)
     values('${email}','${mid}',password('${pwd}'))`, 
    function(err, results){
    if (err) throw err;
    
    console.log("입력성공");//

});


con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다.');//5
}); 
console.log('insert 실행!');//1



