// 주졔 : 요청정보 다루기 - URL 분석하기
// 

const http = require('http');

// URL 분석에 사용할 모듈 로딩
const url = require('url');

const server = http.createServer((req, res) => {
    console.log('요청 받았습니다.');
    
    res.writeHead(200,{
        'Content-Type': 'text/http;charset=UTF-8'
    });
    
    //클라이언트가 요청한 url을 보기
    // => http://localhost:8000/aaa/bbb/ccc?name=hong&age=20
    res.write(req.url + '\n');// => aaa/bbb/ccc?name=hong&age=20를 출력한다.
    
    // URL 분석기를 이용하여 URL을 분석해보자
    var urlInfo = url.parse(req.url);
    
    res.write(`href=${urlInfo.href}\n`);// href= /aaa/bbb?name=hong&age=20
    res.write(`pathname=${urlInfo.pathname}\n`);// pathname= /aaa/bbb
    res.write(`search=${urlInfo.search}\n`);// search= ?name=hong&age=20
    res.write(`query=${urlInfo.query}`);// query= name=hong&age=20
    
    res.end();
    
});

server.listen(8000,() => {
    console.log('서버가 시작됨.');
});