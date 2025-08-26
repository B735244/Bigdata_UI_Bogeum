<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 
    
    Cookie
    문자열 데이터만 저장 가능
    4Kbyte 이하의 공간을 차지
    여러개의 쿠기 설정 가능(최대 300개)
    도메인당 20개까지 저장 가능
    저장한도를 초과하면 최근에 사용되지 않는 쿠기부터 자동삭제
     -->

<%
Cookie cookie1 = new Cookie("cookie1", "value1");
//쿠키는 response 내장객체를 통해서 던져진다
//쿠키의 유지기간(기본값:-1 -> 파일생성X, 브라우저가 종료될 떄까지 cookie 유지)
//-------------------------------------------------
Cookie cookie2 = new Cookie("cookie2", "value1");//cookie2 은 유지기간 설정
cookie2.setMaxAge(60 * 5);//5분 유지
cookie2.setPath("./cookie.txt");
//-------------------------------------------------
response.addCookie(cookie1);
response.addCookie(cookie2);//cookie2 은 유지기간 설정
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