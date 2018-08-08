// 주졔 : 여러개의 요청 처리하기 - 회원 목록조회/등록/변경/삭제 하기
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
    
    if(urlInfo.query.id){
        var id = urlInfo.query.id;        
    }
    if(urlInfo.query.email){
        var email = urlInfo.query.email;        
    }
    if(urlInfo.query.password){
        var password = urlInfo.query.password;        
    }
    
    if(urlInfo.pathname === '/member/list'){
        
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
                res.end();
        });
        
    }else if(urlInfo.pathname === '/member/add'){
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
    }else if(urlInfo.pathname === '/member/update'){
        pool.query('update pms2_member set email=? where mid=?',
                [email, id],
            function(err){
                if (err){
                    res.end('DB조회 중 예외 발생');
                    return;
                };
                res.write('수정 완료');
                res.end();
        });
    }else if(urlInfo.pathname === '/member/delete'){
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
    }else {
        res.end('해당 URL을 지원하지 않습니다.');
        return;
    }
});

server.listen(8000,() => {
    console.log('서버가 시작됨.');
});