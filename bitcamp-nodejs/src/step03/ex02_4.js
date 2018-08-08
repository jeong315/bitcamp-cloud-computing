// 주졔 : HTTP 서버 만들기 - 컨텐트 멀티라인 처리
// 

const http = require('http');

const server = http.createServer((req, res) => {
    console.log('요청 받았습니다.');
    
    res.writeHead(200,{
        'Content-Type': 'text/html;charset=UTF-8'
    });
    
    //write()를 사용하여 컨텐트를 출력할 수 있다.
    // \를 통해 멀티라인을 처리할 수 있다.띄어쓰기도 인식하기 때문에 잘 조절하자.
    res.write(
'<html>\n\
<head>\n\
   <title>Node.js</title>\n\
</head>\n\
<body>\n\
   <h1>안녕~!</h1>\n\
</body>\n\
</html>\n');
    res.end(); //end()에서 꼭 출력할 필요는 없다.
    
});

server.listen(8000,() => {
    console.log('서버가 시작됨. 서버주소:',server.address());
});