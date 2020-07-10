package com.three.web2.admin.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.three.web2.jwt.JwtUtil;

@Controller
public class AdminController1 {
	
	@Autowired
	JwtUtil jwtUtil;
	

	@GetMapping("/")
	public String adc() {
		return "index.html";
	}
	/**
	 * 添加学生页面
	 * @return
	 */
	@GetMapping("/admin/toaddstudents")
	public String toaddclacou() {
		return "addstudent.html";
	}
	/**
	 * 添加教师页面
	 * @return
	 */
	@GetMapping("/admin/toaddteachers")
	public String toaddteacher() {
		return "addteacher.html";
	}
	
	@GetMapping("/admin/toshowstudent")
	public String toshowstudent() {
		return "showstudentById.html";
	}
	
	@GetMapping("/admin/showstusco")
	public String toshowstusco() {
		return "showstusco.html";
	}
	@GetMapping("/admin/showstuinfo")
	public String toshowstuinfo() {
		return "showstuinfo.html";
	}
	@GetMapping("/admin/showmessage")
	public String toshowmessage() {
		return "showmessage.html";
	}
	
	@GetMapping("/admin/toxk")
	public String toxk() {
		return "xk.html";
	}
	@GetMapping("/success")
	public String ad() {
		return "show.html";
	}
	@GetMapping("/err")
	public String error() {
		return "erro.html";
	}
	@GetMapping("/student/studentHome")
	public String stuhome(HttpServletRequest request,HttpServletResponse res,@RequestParam String username) {
		res.setHeader("token", jwtUtil.creattoken(username));
		return "/studentHome";
	}
	@GetMapping("/admin/adminHome")
	public String adminHome(HttpServletRequest request,HttpServletResponse res,@RequestParam String username) {
		res.setHeader("token", jwtUtil.creattoken(username));
		return "adminHome.html";
	}
	@GetMapping("/teacher/teacherHome")
	public String teacherHome(HttpServletRequest request,HttpServletResponse res,@RequestParam String username) {
		res.setHeader("token", jwtUtil.creattoken(username));
		return "teacherHome.html";
	}
	
}
