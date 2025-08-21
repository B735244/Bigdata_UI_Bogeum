<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Scanner" %>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- SCRIPTLET : JSP -> SERVLET 파일로 변환 될 때 SERVLET 내의 Service 함수 안에서 처리되는 로직
Service 함수 내에서 동작하기 때문에 변수를 선언하는 경우에는 지역변수가 되고, 반복문/분기문 처리가 가능하다.
하지만 함수를 벗어나면 지역변수는 소멸되기 때문에 요청 시(ex 새로고침) 상태값(지역변수값)은 초기화 된다. -->
<%
Scanner sc = new Scanner(System.in); 
String str1 = "HELLO WORLD!!!";
String str2 = "HELLO WORLD&&&";
String str3 = str1+str2;
System.out.println("몇 행?");
int n = sc.nextInt();
System.out.println("몇 열?");
int m = sc.nextInt();
int a =0;
 for(int i =0; i<n; i++){
	
	for(int j=0; j<m; j++){
		System.out.printf(" %d:%d ", i,j);
	}
	System.out.println("");
} 

%>


</body>
</html>