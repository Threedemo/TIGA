package com.three.web2.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController1 {

	@GetMapping("/")
	public String adc() {
		return "index.html";
	}
	
	@GetMapping("/student")
	public String ad() {
		return "show.html";
	}
}
