package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/index.do") //어디에 필터를 적용할거야??
public class HomeFilter_2 implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 필터 처리에 사용되는 함수
		
		// Request가 Servlet으로 전달되기 전 코드를 chainFilter위에 붙여 줍니다.
		
		
		System.out.println("[FILTER] HOME FILTER_2 START");
		chain.doFilter(req, resp);
		
		//Response가 Client로 전달되기 전
		System.out.println("[FILTER] HOME FILTER_2 END");
		
	}

	

}
