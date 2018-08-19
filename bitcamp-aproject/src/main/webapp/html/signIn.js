/*$('#addBtn').click(() => {
    $.post('',{},(result) => {}, 'json');
});*/

"use strict"

$('#loginBtn').click(() => {
                               //is(':checked')도 된다.
    //console.log($('#fSaveEmail').prop('checked'));
        
    $.post(`${serverApiAddr}/json/auth/signIn`,{
        'email' : $('#fEmail').val(),
        'password' : $('#fPassword').val(),
        'saveEmail' : $('#fSaveEmail').prop('checked')
    },(result) => {
        console.log(result);
    }, 'json')
    .fail(() => {
        alert('회원 가입 중 오류 발생!');
    });
}); 
