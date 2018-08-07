// 모듈 정의6
// - 응용 : private 변수를 갖는 객체 만들기

var result = 0;

module.exports = {
        plus(value){result += value},
        minus(value){result -= value},
        multiple(value){result *= value},
        divide(value){result /= value},
        getResult(){return result}
}; 
