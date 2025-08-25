<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
  String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    request.setAttribute("C02","C02_value");//02번이라는 key와 value값을 내용을 그대로 간직하면서 03.jsp
//그 전에 요청했던건 초기화된다.\

//Redirect
//1. 파라미터 전달방법 :  QueryString으로 전송
//2. 스코프를 이용(Session & 쿠키)/ Application)
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>03.JSP_PAGE입니다.</h1>
USERNAME:<%=username %><br/>
PASSWORD:<%=password %><br/>
</body>
</html>