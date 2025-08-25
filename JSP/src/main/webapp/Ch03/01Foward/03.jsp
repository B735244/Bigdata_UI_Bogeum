<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");

request.setAttribute("C03", "C03_value");//02번이라는 key와 value값을 내용을 그대로 간직하면서 03.jsp
//Forwarding할거임!!03.JSP로 던질건데 왜 던지는거지?
request.getRequestDispatcher("./04.jsp").forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>03.JSP_PAGE입니다.</h1>
	USERNAME:<%=username%><br /> PASSWORD:<%=password%><br />
	02_VALUE:${C02 }
	<br />
</body>
</html>