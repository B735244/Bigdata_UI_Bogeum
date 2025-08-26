<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
%>
<jsp:useBean id="dto" class="Ch02.UserDto" scope="request" />
<jsp:setProperty name="dto" property="*" />

<%
request.setAttribute("userDto", dto);//request인 상태로 계속 유지되도록 한다
request.setAttribute("url", "/join");
//request.setAttribute("serviceNo", 1); //C:1 R:2 U:3 D:4
//유효성 검사
//request.getRequestDispatcher("./Isvalid.jsp").forward(request, response);

//DB저장
request.getRequestDispatcher("./DbUtils.jsp").forward(request, response);
//main.js or login.jsp
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	UserDto:
	<%=dto%><br />
</body>
</html>