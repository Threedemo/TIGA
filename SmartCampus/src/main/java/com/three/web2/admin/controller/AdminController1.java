package com.three.web2.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController1 {

	@GetMapping("/")
	public String adc() {
		return "index.html";
	}
	
	@GetMapping("/success")
	public String ad() {
		return "show.html";
	}
	
	@GetMapping("/err")
	public String error() {
		return "erro.html";
	}
	
	@PostMapping("/student/studentHome")
	public String stuhome() {
		return "redirect:/studentHome";
	}
	
	@GetMapping("/studentHome")
	public String stuhome1() {
		return "studentHome.html";
	}
	
	@PostMapping("/admin/adminHome")
	public String adminHome() {
		return "redirect:/adminHome";
	}
	
	@GetMapping("/adminHome")
	public String adminHome1() {
		return "adminHome.html";
	}
	
	@PostMapping("/teacher/teacherHome")
	public String teacherHome() {
		return "redirect:/teacherHome";
	}
	
	@GetMapping("/teacherHome")
	public String teacherHome1() {
		return "teacherHome.html";
	}
	
}
