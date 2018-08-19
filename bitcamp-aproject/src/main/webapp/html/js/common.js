
"use strict"

 var serverApiAddr = "http://localhost:8080/bitcamp-assignment-04";
 
/* window.onload = () => {
     console.log('onload.....');
 }
 $(document.body).ready(() => {//document dom.API가 완성됐을 때 실행하라
     console.log('ready()....');
 });*/
 
 $(() => {
     $('footer').load(`${serverApiAddr}/html/footer.html`);
 });
 