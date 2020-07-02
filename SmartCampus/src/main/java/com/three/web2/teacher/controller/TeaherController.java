package com.three.web2.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.pojo.Teacher;
import com.three.web2.teacher.repository.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class TeaherController {

	@Autowired
	TeacherRepository tr;
	
	@PostMapping
	public Teacher save(@RequestBody Teacher teacher) {
		
		return tr.save(teacher);
	}
	
	
}
