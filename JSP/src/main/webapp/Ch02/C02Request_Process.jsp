<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    /*
    request 내장객체 : 요청정보값 저장 (Http request Protocol의 구조형태)
    
    */
/* 문자셋 설정*/    
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    
    
    
    
    
    
    
    /* request 내장객체 : 요청정보값 저장 (Http Request Protocol)*/
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String bgColor = request.getParameter("bgColor");
    String textColor= request.getParameter("textColor");
    System.out.printf("%s %s %s %s \n", username, password,bgColor,textColor);
    
    
    
    %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

</style>
<title>Insert title here</title>
</head>
<body style= "background-color:<%=bgColor%>; color:<%= textColor %>;">
<h1>TEST</h1>
username:<%=username %><br/>
password:<%=password %><br/>
bgcolor:<%=bgColor %><br/>
textcolor:<%=textColor %><br/>

</body>
</html>