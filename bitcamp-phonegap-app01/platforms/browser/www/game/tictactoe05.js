//다른 변수 선언 방법
var human = 'X',
    com = 'O',
    cells = $('.cell'),
    count = 0;


$('.cell').click((e) => {
    console.log($(e.target).attr('data-pos'));//이벤트가 발생된 객체 e.target, 그것의 태그속성값 getAttribute(jQuery로 attr로 가공), e.target오리지널태그라서 $()
    $(e.target).text(human);
    
    //마지막 표시를 했으면 더이상 컴퓨터가 작업하지 않는다.
    if(++count == 5) return;
    
    //타이머 가동하여 1초 후에 컴퓨터가 표시하게 한다.
    setTimeout(() => {
        while(true){
//          console.log('computer');
            var no = Math.floor(Math.random()*9);//Math.floor():내림, ParseInt()써도 됨
    /*        $('.cell:nth-child()').each((i,e) => {//일단 cell클래스인 것들을 찾고 .each():그 각각의 태그에 대해서 다음 함수를 호출해다오
                console.log($(e).text());//e:오리지날태그, text():jQuery태그
            });*/
//            console.log(no, getCellText(no));//$(`.cell:nth-child(${no+1})`).text()
            if(!isCellChecked(no)){
                checkCell(no, 'com');
                return;
            };
        };
    }, 1000);
        
});

$('#new-game').click((e) => {
    console.log('new game!');
});
//e.innerHTML;//=$(e).html();

function isCellChecked(no){
    return cells[no].innerHTML != "" ? true : false;
}
function checkCell(no, player){
     cells[no].innerHTML = 
        (player == 'com') ? com : human;
}