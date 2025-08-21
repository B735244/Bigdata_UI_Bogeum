<!--  지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 선언문(SERVLET으로 변환되는 자바파일의 속성/기능을 추가 )-->
<%!
String name = "SON BO GEUM";
public String testFunc(){
	System.out.println(" 선언문 함수 테스트!!!");
	return "name: "  + name;
	
}
%>
<!--  표현식(SERVLET 파일(JAVA파일)안의 값을 FrontEnd로 전달할 때 사용한다. -->
NAME : <%= name %> <br>
testFunc : <%=testFunc() %><br>
</body>
</html>