package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/index.do"} )
public class Home extends HttpServlet{//요청이 들어왔을 때 처리하는 작업해줘

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /index.do ...");
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
	
	}


}
