package com.mall.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UrlFilter
 */
public class UrlFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UrlFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
		System.out.println("filter该请求...");

		boolean flag=false;
		String  url=httpServletRequest.getRequestURI();
		if(url.indexOf("login.jsp") > 0||url.indexOf("LoginServlet") > 0){
			System.out.println("放过该请求...");
			flag=true;
		}
		if(flag){
			System.out.println("取消过滤...");
			chain.doFilter(request,response);
		} else{System.out.println("过滤中");
		HttpSession session = httpServletRequest.getSession();
		if(session.getAttribute("loginUser")!=null){
			System.out.println("过滤中1"+session.getAttribute("loginUser").toString());
			chain.doFilter(request,response);
		}else{
			System.out.println("过滤中2"+httpServletRequest.getContextPath());
			httpServletResponse.sendRedirect("login.jsp");
		}
		}

		System.out.println("完成过滤....");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
