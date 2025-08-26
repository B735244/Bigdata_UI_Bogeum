<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //Request 객체
    request.setAttribute("test1", "test1_value");
    
    //Session 객체(지정된 시간까지 유지됨, default 1800초(30분), 시간도 지정할 수 있음)
    session.setAttribute("test2", "test2_value");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./getSession.jsp">속성확인 페이지로 이동</a>
</body>
</html>