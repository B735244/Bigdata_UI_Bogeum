<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String cookieName = request.getParameter("name");
    if(cookieName!=null){
    	Cookie cookie = new Cookie(cookieName,null); //빈 value의 쿠키 생성합니다.
    	cookie.setMaxAge(0);//쿠키 만료시키기/ 쿠키 유지시간 0초
    	cookie.setPath("/");// 쿠키 적용 URI ("/") = 현재 도메인의 모든 영역이 포함됨 삭제 시 path설정이 상당히 중요해 보임
    	response.addCookie(cookie);
    }
  out.println("<script>alert('쿠키가 삭제되었습니다!'); location.href = './getCookie.jsp';</script>");
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