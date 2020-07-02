package com.three.web2.teacher.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.pojo.Student;
import com.three.web2.pojo.Teacher;
import com.three.web2.repository.StudentRepository;
import com.three.web2.repository.TeacherRepository;

@RestController
@RequestMapping("/teacher")
public class TeaherController {

	@Autowired
	TeacherRepository tr;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	/**
	 * 查询教师基本信息
	 * 邵琪
	 */
	@GetMapping
	public List<Teacher> FindAll(){
		return tr.findAll();
	}
	
	
	@GetMapping("/stu/{claId}")
	public List<Student> findAll(@PathVariable String claId){
		return studentRepository.all(claId);
	}
	/**
	 * 查询任课班级
	 */
	
	
	
	/**
	 * 查询任课班级详细信息
	 */
}
