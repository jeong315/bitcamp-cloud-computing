// 주졔 : 요청정보 다루기 - POST 요청 다루기
// 

const http = require('http');
const url = require('url');
const querystring = require('querystring');

const server = http.createServer((req, res) => {
    var urlInfo = url.parse(req.url, true);

    if(urlInfo.pathname !== "/"){
        res.end();
        return;
    }
    
    res.writeHead(200,{
        'Content-Type': 'text/http;charset=UTF-8'
    });
    
    if(req.method !== 'POST'){
        res.end('GET 요청을 지원하지 않습니다.');
        return;
    }
    
    // POST 요청 데이터 처리
    //1) data 이벤트 처리
    // => 클라이언트가 보낸 데이터를 일부 읽을 때 마다 발생하는 이벤트다.
    // => 주의! 
    //    클라이언트가 보낸 데이터를 모두 읽었을 때 발생하는 이벤트가 아니다
    //    즉, 클라이언트가 보낸 데이터를 한번에 모두 읽는게 아니라 
    //    일부 읽을 때 마다 알려주는 방식으로 동작한다.
    
    // => 따라서 데이터를 일부 읽었으면 'data' 이벤트가 발생하고 ,
    //    그 이벤트에 등록된 함수가 있다면 호출해준다.
    // => 리스너(이벤트 핸들러)에 넘어오는 파라미터는 클라이언트가 보낸 
    //    데이터의 일부다. 그래서 chunk(일부데이터; 정크)라 씀 
    var data = '';
    req.on('data',(chunk) => {//그래서 일부 데이터 받을 때마다 보관
        data += chunk;
    });
    
    req.on('end', () => {//데이터를 모두 받았을 때 end(응답 완료)를 하는 상황
        // 읽은 데이터를 사용하기 좋게 key/value로 분리한다.
        var params = querystring.parse(data);
        
        res.write(`name=${params.name}\n`)
        res.write(`age=${params.age}`)
        res.end()        
    });
    
    // 데이터에 대해 호출될 메서드를 등록한 후 
    // 다음과 같이 바로 응답을 완료하면 안된다.
    //res.end();
});

server.listen(8000,() => {
    console.log('서버가 시작됨.');
});