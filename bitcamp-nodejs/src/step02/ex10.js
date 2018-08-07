// 주졔 : 데이터베이스 프로그래밍 - select 실행

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

var mid = "user13";
//var mid = "user99' or 1=1 or ''='";//다 날려버림; 

// in-parameter 사용하기!
// => 인 파라미터 방식에서는 사용자가 입력한 값으로 SQL을 만드는 것이 아니기 때문에
//    SQL조직이 불가능하다.

con.query(
    `delete from pms2_member where mid=?`, 
    [mid], //?(인 파라미터) 개수만큼 배열에 값을 담아놓으면 된다.
    function(err, results){
    if (err) throw err;
    
    console.log("삭제 성공");//

});


con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다.');//5
}); 
console.log('delete 실행!');//1



