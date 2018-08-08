// 주졔 : 데이터베이스 프로그래밍 - 커넥션 풀 사용2

const mysql = require('mysql');

var pool = mysql.createPool({
    ConnectionLimit: 10,
    host: '52.79.189.185', 
    user: 'study',
    password: '1111',
    database: 'studydb'
  });

//커넥션 풀 객체를 이용해 바로 질의를 수행한다.
// => pool.getConnection() -> con.query() -> con.release()의 단축사용법
pool.query('select * from pms2_member', function(err, results){
        if (err) throw err;
        
        for(var row of results){
            console.log(row.email, row.mid, row.pwd);
        };
        //이 예제에서는 sql 수행한 후에 프로그램을 종료해야 하기 때문에
        //커넥션 풀을 닫는다.커넥션 예약과는 다르다.
        pool.end();
        //서버로서 실행할때 pool을 쓰기 때문에 매번 end하는 경우는 없을 것이다. 지금은 연습이기 때문에 쓰는 것이다.
    });


console.log('select 실행!');

// ex11.js와 ex12.js의 비교
//
// [ex12.js]
// => ex12.js는 커넥션 풀에 대해 바로 쿼리를 호출할 수 있어
//    코드가 간결해져서 좋다.
// => 하지만 query를 호출할 때마다 새 커넥션을 만들어(꺼내) 사용하기 때문에
//    한 번에 여러 개의 SQL을 실행할 때 불리하다
//    왜? 같은 커넥션을 사용하지 않기 때문이다.
// => 예)
//    pool.query(...); //커넥션1
//    pool.query(...); //커넥션2
//
// [ex11.js]
// => sql을 실행할 때마다 매번 커넥션을 얻어야 하기 때문에
//    ex12.js 보다는 코드가 복잡하다.
// => 그러나 한 번 커넥션을 얻으면 여러번 사용할 수 있기 때문에 
//    여러개의 sql을 실행할 때 ex12.js 방식 보다는 유리하다.
//=> 예)
//    pool.getConnection(function(err, con){
//       con.query(...); //커넥션1
//       con.query(...); //커넥션2
//    });













