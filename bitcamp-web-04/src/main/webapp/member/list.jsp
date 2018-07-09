<%@page import="bitcamp.pms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1 {
	color: tomato;
}
</style>
<meta charset="UTF-8">
<title>멤버 목록</title>
</head>
<body>


	<h1>멤버 목록 5</h1>
	<p>
		<a href='/bitcamp-web-04/member/add.jsp'>새 회원</a>
	</p>
	<table border='1'>
		<tr>
			<th>아이디</th>
			<th>이메일</th>
		</tr>
		<!--
		2)<jsp:useBean id="list"
			type="java.util.List<bitcamp.pms.domain.Member>"
			scope="request"></jsp:useBean> -> 3)jstl을 추가해줫기 때문에 지워도 됨 
		 		
 		    1)List<Member> list = (List)request.getAttribute("list");
                        위에 jsp:useBean 때문에 적어 줄 필요가 없음 		
 		   for (Member member : list){
 		 -->
		<!-- JSTL -->
		<c:forEach items="${list}" var="member">

			<tr><!-- 익스프레션 태그<'%' member.getId '%'> 대신 익스프레션 랭귀지 ${member.id}를 써준다. -->
				<td><a href='view?id=${member.id}'>${member.id}</a></td>
				                    <!-- .id 이거는 프로퍼티 이름이다.getId의 get 빼고 I를 소문자로 바꾼 이름  -->
				<td>${member.email}</td>
			<tr>
		</c:forEach>
	</table>


</body>
</html>