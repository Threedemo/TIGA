package com.three.web2.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController1 {

//	@GetMapping("/")
//	public String adc() {
//		return "index.html";
//	}
	
	@GetMapping("/success")
	public String ad() {
		return "show.html";
	}
	
	@GetMapping("/err")
	public String error() {
		return "erro.html";
	}
	
	@GetMapping("/studentHome")
	public String stuhome() {
		return "studentHome.html";
	}
	
	@GetMapping("/adminHome")
	public String adminHome() {
		return "adminHome.html";
	}
	
	@GetMapping("/teacherHome")
	public String teacherHome() {
		return "teacherHome.html";
	}
	
}
