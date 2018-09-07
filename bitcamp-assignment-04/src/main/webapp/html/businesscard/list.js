'use strict'
//$('#name-list').on('click', 'li', (e) => {//부모 중 li가 클릭됐을 경우만
//    var no = $(e.target).attr('data-no');
//    $(document.body).trigger('show.detail', [no]);//넘겨줄 값이 있으면 배열로 넘겨주면 된다=>[no].
//});

//=> arrow 함수를 쓰려면 this(window객체)를 사용 못하니 target이라는 property를 사용한다.
//$('#name-list').on('click','li', (e) => {
//    console.log($(e.target).attr('data-no')); 
//});

var liTemplateSrc = $('#li-template').text();
var template = Handlebars.compile(liTemplateSrc);

loadList();

$('#name-list').on('click', 'li', (e) => {
    $('#name-list li.list-group-item-secondary')
        .removeClass('list-group-item-secondary');
    $(e.target).addClass('list-group-item-secondary');
    
    var no = $(e.target).attr('data-no');
    $(document.body).trigger('show.detail', [no]);
});

$(document.body).on('refresh.list', () => loadList());

function loadList() {
    $.getJSON(`${serverApiAddr}/json/businesscard/list`, (result) => {
        var html = template(result);
        $('#name-list').html(html);
        $('#name-list li:first-child').click();
    })
}

//////////////////////////////
var boardTemplateSrc = $('.aa2').text();
var template = Handlebars.compile(boardTemplateSrc);

loadList();

$('#boardInfo-title').on('click',(e) => {
    $('#boardInfo-title li.list-group-item-secondary')
    .removeClass('list-group-item-secondary');
    $(e.target).addClass('list-group-item-secondary');

    var no = $(e.target).attr('data-no');
    $(document.body).trigger('show.detail', [no]);
})

function loadList() {
    $.getJSON(`${serverApiAddr}/json/html/main`, (result) => {
        var html = template(result);
        $('#a22').html(html);
        $('#a22 div:first-child').click();
    })
}
