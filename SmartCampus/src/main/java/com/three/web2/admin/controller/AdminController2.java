package com.three.web2.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.admin.repository.AdminRepository;
import com.three.web2.pojo.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController2 {

	@Autowired
	AdminRepository adminRepository;
	
	
	@PostMapping
	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}
}
