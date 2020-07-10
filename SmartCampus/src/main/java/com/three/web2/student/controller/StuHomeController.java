package com.three.web2.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StuHomeController {
	@GetMapping("/stuhome")
	public String student() {
		return "student.html";
	}
}
