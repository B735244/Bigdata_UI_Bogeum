<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Scanner"%>
<%@ page import="java.io.*"%>
<%
Scanner sc = new Scanner(System.in);

System.out.println("몇 단부터 몇 단까지 외울래?");
int n = sc.nextInt();
int m = sc.nextInt();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border: 2px solid black;
	margin: 3px;
	background-color : yellow;
}

tr{
border: 1px solid black;
margin:10px;
background-color : black;
color:white;
}
</style>
</head>
<body>
	<table>
		<tbody>
		<%= "  <----구구단을 외자 구구단을 외자----" %>
			<%
			
			if (m >= n) {
				for (int i = n; i <= m; i++) {
			%>
			<tr>
				<%
				for (int j = 1; j <= 9; j++) {
				%>
				<td><%=i + "*" + j + "=" + i * j%></td>
				<%
				}
				
				%>

			</tr>
			<%
			}
			}
			
			else{
				int c=n;
				n=m;
				m=c;
				for (int i = n; i <= m; i++) {
					%>
					
					<tr>
						<%
						for (int j = 1; j <= 9; j++) {
						%>
						<td><%=i + "*" + j + "=" + i * j%></td>
						<%
						}
						%>

					</tr>
					<%
				
				}
			}
			%>

		</tbody>
	</table>

</body>
</html>