<%@page import="bitcamp.pms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시판</title>
</head>
<body>
<h1>게시판</h1>
<p><a href='boardForm.jsp'>새회원</a></p>
<table border='1'>
<tr>
    <th>아이디</th><th>이메일</th>
</tr>
<c:forEach items="${list}" var="board">
<tr>
    <td>${board.no}</td>
    <td><a href='view?no=${board.no}'>${board.title}</a></td>
    <td>${board.createDate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
    
    
    
    
    
    
    