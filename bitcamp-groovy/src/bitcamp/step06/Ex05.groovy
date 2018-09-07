// 문자열 다루기 - GString
package bitcamp.step06

name = "홍길동"
str1 = "이름은 $name 입니다." //GString
str2 = "이름은"+ name+"입니다." //달러가 안들어간 일반 스트링 

println str1 instanceof String
println str1 instanceof GString

println str2 instanceof String
println str2 instanceof GString