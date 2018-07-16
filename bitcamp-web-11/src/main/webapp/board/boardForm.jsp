<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 등록</h1>
	
	<form action="add" method="post">
	
		제목: <input type="text" name="title"><br>
		내용: <textarea name="content" rows="10" cols="60"></textarea> <br> 
		
		  <input type="text" hidden="" name="no">
		  <input type="date" hidden="" name="createDate">
		
		<button>등록</button>
		
	</form>

</body>
</html>