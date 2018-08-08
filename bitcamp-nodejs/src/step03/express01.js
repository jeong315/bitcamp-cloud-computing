// 요청 핸들러를 관리하는 모듈 
// => 

module.exports = {
    reqMap: {},
    get(url, handler){
        this.reqMap[url] = handler;
    },
    getHandler(url){
        return this.reqMap[url];
    }
};
