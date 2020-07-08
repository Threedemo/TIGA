package com.three.web2.securityconf;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.three.web2.jwt.JwtUtil;

public class LoginSuccessHandle implements AuthenticationSuccessHandler {
	
	JwtUtil jwtUtil=new JwtUtil();
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//响应回去的token
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		
		if (roles.contains("ROLE_STUDENT")) {
			response.sendRedirect("student/studentHome?username="+request.getParameter("username"));
			return;
		}else if (roles.contains("ROLE_TEACHER")) {
			response.sendRedirect("teacher/teacherHome?username="+request.getParameter("username"));
			return;
		}else if (roles.contains("ROLE_ADMIN")) {
			response.sendRedirect("admin/adminHome?username="+request.getParameter("username"));
			return;
		}
		response.sendRedirect(basePath + "/");
	}
}
