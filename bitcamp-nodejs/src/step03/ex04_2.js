// 주졔 : SQL 요청 처리하기 - 회원 등록하기
// [실행 URL]
// => http://localhost:8000/member/add?id=user100&email=user100@test.com&password=1111
// [출력 결과]
// 등록 성공입니다.

const http = require('http');

// URL 분석에 사용할 모듈 로딩
const url = require('url');
const mysql = require('mysql');

var pool = mysql.createPool({
    ConnectionLimit: 10,
    host: '52.79.189.185', 
    user: 'study',
    password: '1111',
    database: 'studydb'
  });

const server = http.createServer((req, res) => {
    var urlInfo = url.parse(req.url, true);
    
    //파비콘(의 출력?)을 무시하는 것 
    if(urlInfo.pathname === '/favicon.ico'){
        res.end();
        return;
    }
    
    res.writeHead(200,{
        'Content-Type': 'text/plain;charset=UTF-8'
    });
    res.write(urlInfo.pathname+'\n');
    res.write(urlInfo.query.id+'\n');
    res.write(urlInfo.query.email+'\n');
    res.write(parseInt(urlInfo.query.password)+'\n');
    
    if(urlInfo.pathname !== '/member/add'){
        res.end('해당 URL을 지원하지 않습니다.');
        return;
    }
    
    var id = urlInfo.query.id;   
    var email = urlInfo.query.email;   
    var password = urlInfo.query.password;
    
    
    pool.query('insert into pms2_member (mid, email, pwd) values (?,?,password(?))',
            [id, email, password],
        function(err){
            if (err){
                res.end('DB조회 중 예외 발생');
                return;
            };
            res.write("등록 성공입니다.");
            res.end();
    });
    
});

server.listen(8000,() => {
    console.log('서버가 시작됨.');
});