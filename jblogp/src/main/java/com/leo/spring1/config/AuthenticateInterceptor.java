package com.leo.spring1.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.leo.spring1.domain.User;

public class AuthenticateInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");
		if(principal == null) {
			response.sendRedirect("/auth/login");
		}
		return true;
	}
	
	

}
