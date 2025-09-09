<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1> MAIN PAGE</h1>
<hr/>
<div>

<span>${message}</span><br/>
    <a href="/memo/add">메모쓰기</a>

</div>

</body>
</html>
