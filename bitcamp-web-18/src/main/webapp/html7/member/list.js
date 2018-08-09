"use strict"

var trTemplateSrc = $('#tr-template-src').text();
var trTemplateFn = Handlebars.compile(trTemplateSrc);//웹에서는 H대문자로 써줘야함

var {page, size} = $.parseQuery(location.href);
let tbody = $('#eListTable > tbody'); 
let data = null;
if (page != undefined && size != undefined) {
    loadList(page, size);
} else {
    loadList(1, 3);
}
//오리지널 태그에는 on이라는 메서드가 없다. 즉$()
$(ePrevBtn).click(function() {//event와 listener함수
    loadList(data.page - 1, data.size);
});
$(eNextBtn).click(function() {
    loadList(data.page + 1, data.size);
});

function loadList(page, size) {
    $.getJSON(serverApiAddr + '/json/member/list', 
        {
            page: page,//프로퍼티명: 변수명
            size: size
        }, function() {console.log("로딩 성공!")})
     .done(function(result) {
       data = result;
       
       var trListHTML = trTemplateFn({list: data.list});
       tbody.html(trListHTML); // 반복문을 돌릴 필요가 없다.
//       for (var item of data.list) {
//           var trHTML = trTemplateFn(item);
//           $(trHTML).appendTo(tbody);
//       }
       
       $(ePageNo).html(data.page);
       if (data.page <= 1)
           $(ePrevBtn).attr('disabled', '');
       else 
           $(ePrevBtn).removeAttr('disabled');
       
       if (data.page >= data.totalPage)
           $(eNextBtn).attr('disabled', '');
       else
             $(eNextBtn).removeAttr('disabled');
       
    });
}
// console.log($('.viewLink'));
//뷰링크를 찾아서 클릭을 호출하라
//이 방식은 실행 시점에 존재하는 태그에 대해서만 이벤트 핸들러를 등록할 수 있다.
/* $('.viewLink').click(function clickViewLink(event) {
    alert('okokokokokokokokokokokokokokokokokokokokok');
            event.preventDefault();//event.currentTarget 얘도 오리지날 태그 객체
            var id = $(event.currentTarget).attr('data-id');//이름만 주고 값을 안주면 getter로 사용됨(set과 get을 나누지 않아도 된다는 장점)
            location.href = `view.html?id=${id}&page=${data.page}&size=${data.size}`;
        }); */
                                                               //위 방법보다 아래방법 
     // 실행 시점에 존재하지 않더라도 이벤트 핸들러를 등록하는 방법은?
     // => 앞으로 생성될 태그의 부모에 리스너를 등록하는 것이다.=>버블링 때문에   
     tbody.on('click','a.viewLink',function(event){
     //=$(document.body)
         
         event.preventDefault();//event.currentTarget 얘도 오리지날 태그 객체, event.currentTarget 대신 event.target
         var id = $(event.target).attr('data-id');//이름만 주고 값을 안주면 getter로 사용됨(set과 get을 나누지 않아도 된다는 장점)
         location.href = `view.html?id=${id}&page=${data.page}&size=${data.size}`;
     });
