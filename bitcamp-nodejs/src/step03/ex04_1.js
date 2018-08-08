// 주졔 : SQL 요청 처리하기 - 회원 목록 보기
// [실행 URL]
// => http://localhost:8000/member/list?pageNo=1&pageSize=3
// [출력 결과]
// 아이디, 이메일

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
    
    if(urlInfo.pathname !== '/member/list'){
        res.end('해당 URL을 지원하지 않습니다.');
        return;
    }
    
    var pageNo = 1;
    var pageSize = 3;
    
    if(urlInfo.query.pageNo){
        var pageNo = parseInt(urlInfo.query.pageNo);        
    }
    if(urlInfo.query.pageSize){
        var pageSize = parseInt(urlInfo.query.pageSize);       
    }
    
    var startIndex = (pageNo -1) * pageSize;
    
    pool.query('select mid, email from pms2_member limit ?,?',
            [startIndex, pageSize],
        function(err, results){
            if (err){
                res.end('DB조회 중 예외 발생');
                return;
            };
            
            for(var row of results){
                res.write(`email : ${row.email}, id : ${row.mid}\n`);
            };
            //pool.end(); 서버는 계속 진행중이기 때문에 쓰면 안됨
            res.end();
    });
    

    //res.write(`${pageNo} ${pageSize} ${startIndex}\n`);
    //res.end(); db에서 데이터 다 받아온 후 종료해야함
    
});

server.listen(8000,() => {
    console.log('서버가 시작됨.');
});