<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 선언문 -->
<%@ page import="Ch02.*,Ch04.*"%>
<%!public boolean isValid(UserDto dto) {
		if (dto.getUserid().isEmpty()) {
			System.out.println("Userid를 입력하세요.");
			return false;
		}
		if (dto.getUserid().length() <= 5) {
			System.out.println("Userid를 5자 이상 입력하세요.");
			return false;

		}
		return true;
	}
	%>

<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
%>
<!-- 1. 파라미터 값 받기 -->
<jsp:useBean id="dto" class="Ch02.UserDto" scope="request" />
<jsp:setProperty name="dto" property="*" />

<%
//2. 유효성 검증
if (!isValid(dto)) {
	//유효하지 않을 때 01Join.html로 이동합니다.
	response.sendRedirect("./01Join.html");

}
//3. 서비스 처리(회원가입 -> DB저장)
DbUtils.conn();//DB연결처리
//동일 계정 유무 확인
//동일 계정이 없으면 회원가입 처리(계정정보 저장)

//연결해제
//DbUtils.disConn();

//4. 로그인 페이지로 이동
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