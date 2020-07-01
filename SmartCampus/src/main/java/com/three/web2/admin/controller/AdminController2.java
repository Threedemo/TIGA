package com.three.web2.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.pojo.Admin;
import com.three.web2.pojo.Classes;
import com.three.web2.pojo.Department;
import com.three.web2.pojo.Student;
import com.three.web2.repository.AdminRepository;
import com.three.web2.repository.ClassRepository;
import com.three.web2.repository.DepartmentRepository;
import com.three.web2.repository.StudentRepository;

@RestController
@RequestMapping("/admin")
public class AdminController2 {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	DepartmentRepository deprepository;
	
	@Autowired
	ClassRepository clarepository;
	
	@Autowired
	StudentRepository sturepository;
	
	
	@PostMapping("/admin")
	public Admin saveadmin(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}
	
	@PostMapping("/dep")
	public Department savedep(@RequestBody Department department) {
		System.out.println(department);
		return deprepository.save(department);
	}
	
	@PostMapping("/classes")
	public Classes saveclass(@RequestBody Classes cla) {
		return clarepository.save(cla);
	}
	
	@PostMapping("/student")
	public Student savestudent(@RequestBody Student stu) {
		return sturepository.save(stu);
	}
}
