<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String msg1 = "Hello World!!!";
    String msg2 = "Hello World!!!";
   //pageContext, request, session, application
    request.setAttribute("msg3","Hello World!!!" );//스코프안에 속성과 출력할것을 넣어주면 나옴
    
    request.setAttribute("msg4","Hello World!!!" );
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
const m1 = '<%=msg1 %>'
const m2 = '<%=msg2%>'
const m3 = '${msg3}'//EL표현식
const m4 = `${}`// JS의 보간법

console.log(m1);
console.log(m2);
console.log(m3);


</script>


</body>
</html>