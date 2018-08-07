// 주졔 : 데이터베이스 프로그래밍 - select 실행2

const mysql = require('mysql');

console.log(mysql);

var con = mysql.createConnection({
    host: '52.79.189.185', 
    database: 'studydb',
    user: 'study',
    password: '1111'
  });

con.connect(function(err){
    if (err) throw err; 
    
    console.log('연결을 성공했습니다.');
    
    //연결에 성공 했을 때만 SQL을 실행하라고 예약 할 수 있다.
    con.query('select * from pms2_member', function(err, results){
        if (err) throw err;
        
        console.log("결과를 가져왔습니다.");
        for(var row of results){
            console.log(row.email, row.mid, row.pwd);
        };
    });
});

// 이 예제에서는 연결 완료 후 END를 먼저 실행하라고 예약했기 때문에
// connect()에 등록한 함수가 호출되어 SQL을 예약하더라도
// end보다 그 이후에 실행되기 때문에
// SQL 실행 오류가 발생할 것이다.
//
// 해결책 : end는 sql실행을 먼저 예약한 다음에 end실행을 예약하라
// ex06.js를 보쇼
con.end(function(err){
    if(err) throw err;
    console.log('연결을 끊었습니다.');
});

console.log('select 실행!');















