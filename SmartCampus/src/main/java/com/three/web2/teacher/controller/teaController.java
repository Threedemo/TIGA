package com.three.web2.teacher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class teaController {

	
	@GetMapping("/teamag")
	public String teamsg() {
		return "stumsg.html";
	}
	
	
	@GetMapping("/evaluate")
	public String evaluate() {
		return "evaluate.html";
	}
}
