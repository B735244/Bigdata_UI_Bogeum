<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//1. 파라미터 확인
String username =request.getParameter("username");
String password = request.getParameter("password");
//2. 유효성 검사
//1) 유저이름을 입력하지 않았다면
if(username.isEmpty()){
	request.setAttribute("username_msg", "username을 입력하세요.");//오류메세지를 띄운후
	request.getRequestDispatcher("./Login_form.jsp");//다시 로그인 폼 페이지로 돌아가서 다시 입력해라.
	return ;
	
}
//2) password를 입력하지 않았다면
if(password.isEmpty()){
	request.setAttribute("password_msg","password를 입력하세요");
	request.getRequestDispatcher("./Login_form.jsp");
	return;
}
//3. 관련 서비스 실행
//1) username과 동일한 계정이 있는지 확인 후 가져와야 함
if(username.equals("admin")){
	request.setAttribute("user_msg", "해당 계정은 존재하지 않습니다.");
	request.getRequestDispatcher("./Login_form.jsp").forward(request,response);
	
}

if(!password.equals("1234")){
	request.setAttribute("password_msg","패스워드가 일치하지 않습니다.");
	request.getRequestDispatcher("./Login_form.jsp").forward(request,response);
}
//2) password의 값이 입력한 값이랑 동일한 지 확인
//3) session에 해당 계정에 작업에 필요한 속성을 저장

session.setAttribute("isAuth", true);
session.setAttribute("role","ROLE_ADMIN");
session.setMaxInactiveInterval(30);
//4. 뷰로 이동

response.sendRedirect("./Main.jsp");
%>