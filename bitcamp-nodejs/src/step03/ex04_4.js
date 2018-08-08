// 주졔 : SQL 요청 처리하기 - 회원 삭제하기
// [실행 URL]
// => http://localhost:8000/member/delete?id=user100
// [출력 결과]
// 삭제 성공입니다.

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
    
    if(urlInfo.pathname !== '/member/delete'){
        res.end('해당 URL을 지원하지 않습니다.');
        return;
    }

    if(urlInfo.query.id){
        var id = urlInfo.query.id;        
    }else{
        res.write('제대로 입력하쇼');
    }
    
    pool.query('delete from pms2_member where mid=?',
            [id],
        function(err){
            if (err){
                res.end('DB조회 중 예외 발생');
                return;
            };
            res.write('삭제 완료');
            res.end();
    });
    

    //res.write(`${pageNo} ${pageSize} ${startIndex}\n`);
    //res.end(); db에서 데이터 다 받아온 후 종료해야함
    
});

server.listen(8000,() => {
    console.log('서버가 시작됨.');
});