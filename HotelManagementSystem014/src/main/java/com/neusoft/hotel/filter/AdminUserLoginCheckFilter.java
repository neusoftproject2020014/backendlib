package com.neusoft.hotel.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录检查过滤器，如果没有登录拦截到login.jsp
 */
//@WebFilter("/*")
public class AdminUserLoginCheckFilter implements Filter {

    

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		String uri=request.getRequestURI();
		if(uri.equals("/oaweb/login.jsp") ||uri.equals("/oaweb/userlogin.do") || uri.endsWith(".css") ||uri.endsWith(".js") || uri.endsWith(".jpg")) {
			chain.doFilter(request, response);
		}
		else {
			HttpSession session=request.getSession();
			if(session!=null&&session.getAttribute("user")!=null) {
				chain.doFilter(request, response);
			}
			else {
				response.sendRedirect("/oaweb/login.jsp");
			}
			
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
