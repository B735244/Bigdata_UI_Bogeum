<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Ch02.ProfileDto" %>
    
    <%
    /*
    request 내장객체 : 요청정보값 저장 (Http request Protocol의 구조형태)
    
    */
/* 문자셋 설정*/    
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    
    
    
    
    
    
    
    /* request 내장객체 : 요청정보값 저장 (Http Request Protocol)*/
    String username = request.getParameter("username");
    String age = request.getParameter("age");
    String addr = request.getParameter("addr");
    String bgColor = request.getParameter("bgColor");
    String textColor= request.getParameter("textColor");
    ProfileDto dto = new ProfileDto(username,age,addr,bgColor,textColor);
    System.out.println("dto : "+dto);
    
    
    
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
<h1>보동 금동이가 너무 보고싶다.</h1>
username:<%=username %><br/>
age:<%=age %><br/>
addr:<%=addr %><br/>

bgcolor:<%=bgColor %><br/>
textcolor:<%=textColor %><br/>

</body>
</html>