package com.three.web2.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.LoginMapper;
import com.three.web2.pojo.Admin;
import com.three.web2.pojo.Classes;
import com.three.web2.pojo.Department;
import com.three.web2.pojo.Login;
import com.three.web2.pojo.Major;
import com.three.web2.pojo.Student;
import com.three.web2.pojo.TeaClass;
import com.three.web2.pojo.Teacher;
import com.three.web2.repository.AdminRepository;
import com.three.web2.repository.ClassRepository;
import com.three.web2.repository.DepartmentRepository;
import com.three.web2.repository.MajorRepository;
import com.three.web2.repository.StudentRepository;
import com.three.web2.repository.TeaClassRepository;
import com.three.web2.repository.TeacherRepository;

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
	
	@Autowired
	MajorRepository majorrepository;
	
	@Autowired
	LoginMapper loginmapper;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	TeaClassRepository teaClassRepository;
	
	/**
	 * 添加院系API
	 * @param department
	 * @return
	 */
	@PostMapping("/dep")
	public Department savedep(@RequestBody Department department) {
		return deprepository.save(department);
	}
	
	/**
	 * 添加一个班级
	 * @param cla
	 * @return
	 */
	@PostMapping("/classes")
	public Classes saveclass(@RequestBody Classes cla) {
		return clarepository.save(cla);
	}
	
	/**
	 * 添加一个学生
	 * @param stu
	 * @return
	 */
	@PostMapping("/student")
	public Student savestudent(@RequestBody Student stu,@RequestBody Login login) {
		//添加到登录表单中
		loginmapper.save(login);
		return sturepository.save(stu);
	}
	/**
	 * 删除所有学生
	 */
	@DeleteMapping("/student")
	public void savestudent() {
		
		sturepository.deleteAll();
	}
	
	/**
	 * 添加专业
	 * @param major
	 * @return
	 */
	@PostMapping("/major")
	public Major savemajor(@RequestBody Major major) {
		return majorrepository.save(major);
	}
	/**
	 * 添加教师信息
	 * @param teacher
	 * @param login
	 * @param teaClass
	 * @return
	 */
	@PostMapping("/teacher")
	public Teacher saveteacher(@RequestBody Teacher teacher
			,@RequestBody Login login
			,@RequestBody TeaClass teaClass) {
		/**
		 * 添加登录信息
		 */
		loginmapper.save(login);
		//添加教师班级表信息
		teaClassRepository.save(teaClass);
		return teacherRepository.save(teacher);
	}
}
