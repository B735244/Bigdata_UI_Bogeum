<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//쿠키는 response 내장객체를 통해서 던져진다
//쿠키의 유지기간(기본값:-1 -> 파일생성X, 브라우저가 종료될 떄까지 cookie 유지)
//-------------------------------------------------
Cookie cookie1 = new Cookie("cookie1", "value1");
cookie1.setMaxAge(60 * 10);//10분 유지
cookie1.setPath("/");// 도메인의 모든 URI에서 접근 가능

Cookie cookie2 = new Cookie("cookie2", "value2");//
cookie2.setMaxAge(60 * 10);//10분 유지
cookie2.setPath("./");//현재 위치 폴더에 있는 모든 곳에서 접근 가능 http://localhost:8090/JSP/Ch06/02/*

Cookie cookie3 = new Cookie("cookie3", "value3");//
cookie2.setMaxAge(60 * 10);//10분 유지
cookie2.setPath("/JSP/Ch01");
//-------------------------------------------------
response.addCookie(cookie1);
response.addCookie(cookie2);
response.addCookie(cookie3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>