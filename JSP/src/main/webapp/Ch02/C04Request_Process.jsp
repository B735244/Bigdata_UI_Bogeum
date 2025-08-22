<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
%>
<jsp:useBean id="dto" class="Ch02.ProfileDto" scope="request" />
<jsp:setProperty name="dto" property="*" />




<%
/*
request 내장객체 : 요청정보값 저장 (Http request Protocol의 구조형태)

*/

System.out.println("dto :" + dto);
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>보동 금동이가 너무 보고싶다.</h1>
	ProfileDto :
	<%=dto%><br />

</body>
</html>