package com.three.web2.securityconf;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandle implements AuthenticationSuccessHandler {
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		System.out.println(basePath);
		if (roles.contains("ROLE_STUDENT")) {
			response.sendRedirect(basePath + "student/studentHome");
			return;
		}else if (roles.contains("ROLE_TEACHER")) {
			response.sendRedirect(basePath + "teacher/teacherHome");
			return;
		}else if (roles.contains("ROLE_ADMIN")) {
			response.sendRedirect(basePath + "admin/adminHome");
			return;
		}
		response.sendRedirect(basePath + "/");
	}
}
