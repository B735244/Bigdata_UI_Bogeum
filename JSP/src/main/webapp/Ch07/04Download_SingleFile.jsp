<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%
String dirPath = pageContext.getServletContext().getRealPath("/") + "Ch07\\Files\\";
System.out.println("dirPath : " + dirPath);

try {
	//INPUTSTREAM
	InputStream fin = new FileInputStream(dirPath + "test1.pdf");//파일을 연결했다.
	//OUTPUTSTREAM
	out.clear();//response outStream을 닫고 버퍼 초기화
	out = pageContext.pushBody();//현재 페이지의 Body에 out 연결
	ServletOutputStream bout = response.getOutputStream();
	//Response Header Setting
	response.setHeader("Content-Type", "application/octet-stream;charset-utf-8");//중요합니다.
	response.setHeader("Content-Disposition", "attachment; filename=test1.pdf");

	//buffer생성, while문 전에 만들어서 데이터는 buffer단위로 읽어온다.
	byte [] buff = new byte[4096];
	while (true) {
		int data = fin.read(buff);
		if (data == 1) {
	break;
		}
		bout.write(buff,0,data);
		bout.flush();
	}
	bout.close();
	fin.close();
} catch (Exception e) {

}
%>