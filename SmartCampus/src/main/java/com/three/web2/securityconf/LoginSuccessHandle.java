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
			response.setHeader("token", jwtUtil.creattoken(request.getParameter("username")));
			request.getRequestDispatcher("student/studentHome").forward(request, response);
			System.out.println(request.getParameter("username"));
			return;
		}else if (roles.contains("ROLE_TEACHER")) {
			response.setHeader("token", jwtUtil.creattoken(request.getParameter("username")));
			request.getRequestDispatcher("teacher/teacherHome").forward(request, response);
			response.sendRedirect(basePath + "teacher/teacherHome");
			return;
		}else if (roles.contains("ROLE_ADMIN")) {
			response.setHeader("token", jwtUtil.creattoken(request.getParameter("username")));
			request.getRequestDispatcher("admin/adminHome").forward(request, response);
			return;
		}
		response.sendRedirect(basePath + "/");
	}
}
