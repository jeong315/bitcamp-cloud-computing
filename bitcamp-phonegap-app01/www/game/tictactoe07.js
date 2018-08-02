//다른 변수 선언 방법
var human = 'X',
    com = 'O',
    cells = $('.cell'),
    count = 0,
    isCompleted = false,
    isWorking = false;

$('#cell-box').on('complete', (e, result) => {//jQuery에서 이벤트 사용법:trigger
    if(result == 1) alert("인간 승리");
    else if(result == -1) alert("컴퓨터 승리");
});

$('.cell').click((e) => {
    if(isCompleted || isWorking) return;
    if(e.target.innerHTML != '') return;//눌러져 잇는 칸 또 선택 할 시 
    
    $(e.target).text(human);
    count++;
    
    var result = computeGame();
    if(result != 0){
        $('#cell-box').trigger('complete',[result]);//jQuery에서 이벤트 사용법:trigger
        isCompleted = true;
    }

//    //마지막 표시를 했으면 더이상 컴퓨터가 작업하지 않는다.
//    if(++count == 5) {
//        if(result == 0) alert("비겼다.");
//        
//        return;
//    }
    
    if(isCompleted) return;
    isWorking = true;
    //타이머 가동하여 1초 후에 컴퓨터가 표시하게 한다.
    setTimeout(() => {
        while(true){
            var no = Math.floor(Math.random()*9);

            if(!isCellChecked(no)){
                checkCell(no, 'com');
                break;
            };
        };
        var result = computeGame();
//        if(result == 1) alert("인간 승리");
//        else if(result == -1) alert("컴퓨터 승리");
        if(result != 0){
            $('#cell-box').trigger('complete',[result]);
            isCompleted = true;
        }else if(count == 5){
            alert("비겼다.");
        }
        isWorking = false;
    }, 1000);
        
});

$('#new-game').click((e) => {
    console.log('new game!');
    cells.each((i, e) => {//index, element
        e.innerHTML = '';
    });
    count = 0;
    isCompleted = false;
    isWorking = false;
});

function isCellChecked(no){
    return cells[no].innerHTML != "" ? true : false;
}

function checkCell(no, player){
     cells[no].innerHTML = 
        (player == 'com') ? com : human;
}

function computeGame(){
    console.log("--------------------");
    for (var row = 0; row <= 9 ; row += 3){
        var countHuman = 0;
        var countCom = 0; 
        for (var i = row ; i < (row+3); i++ ){
            if(cells[i].innerHTML == human) countHuman++;
            else if(cells[i].innerHTML == com) countCom++;
        }
        if(countHuman == 3) return 1;
        else if(countCom == 3) return -1;
    }
    
    for (var col = 0; col < 3 ; col++ ){
        var countHuman = 0;
        var countCom = 0; 
        for (var i = col ; i <= (col+6); i++ ){
            if(cells[i].innerHTML == human) countHuman++;
            else if(cells[i].innerHTML == com) countCom++;
        }
        if(countHuman == 3) return 1;
        else if(countCom == 3) return -1;
    }
    var countHuman = 0;
    var countCom = 0; 
    for (var i = 0; i <= 8 ; i += 4 ){
        if(cells[i].innerHTML == human) countHuman++;
        else if(cells[i].innerHTML == com) countCom++;
    }
    if(countHuman == 3) return 1;
    else if(countCom == 3) return -1;
    
    var countHuman = 0;
    var countCom = 0; 
    for (var i = 2; i <= 6 ; i += 2 ){
        if(cells[i].innerHTML == human) countHuman++;
        else if(cells[i].innerHTML == com) countCom++;
    }
    if(countHuman == 3) return 1;
    else if(countCom == 3) return -1;
    
    return 0;
    
}