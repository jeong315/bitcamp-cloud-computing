// 주졔 : 데이터베이스 프로그래밍 - update 실행

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

var mid = 'user001';

con.query(
    `update pms2_member set email='user002@test.comxx' where mid='${mid}'`, 
    function(err, results){
    if (err) throw err;
    
    console.log("변경 성공");//

});


con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다.');//5
}); 
console.log('update 실행!');//1



