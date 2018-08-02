$('.cell').click((e) => {
    console.log($(e.target).attr('data-pos'));//이벤트가 발생된 객체 e.target, 그것의 태그속성값 getAttribute(jQuery로 attr로 가공), e.target오리지널태그라서 $()
});

$('#new-game').click((e) => {
    console.log('new game!');
});