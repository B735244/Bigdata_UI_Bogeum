<%@ page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Global Error Page입니다.
</h1>

EX : ${ex}<hr/>
EXCEPTION : <%=exception %><br/>
</body>
</html>
