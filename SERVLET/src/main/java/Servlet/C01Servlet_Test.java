package Servlet;
//request요청 -> 서블릿 파일 맵핑(URI) -> request 처리 -> 결과 반환(웹페이지)

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/TEST_01")
public class C01Servlet_Test extends HttpServlet{


	@Override
	public void init() throws ServletException {
		//서블릿 최초 실행함수
		System.out.println("INIT() 함수가 실행되었습니다...");

}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//요청시마다 동작합니다.
		System.out.println("Service() 함수가 실행되었습니다...");
	}

	@Override
	public void destroy() {
		//내용 변경시 동작합니다.
		System.out.println("Destroy() 함수가 실행되었습니다...");
	}
}

