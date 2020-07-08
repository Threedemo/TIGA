package com.three.web2.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.LoginMapper;
import com.three.web2.pojo.Score;
import com.three.web2.pojo.Student;
import com.three.web2.pojo.Teacher;
import com.three.web2.repository.AdminRepository;
import com.three.web2.repository.ScoreRepository;
import com.three.web2.repository.StudentRepository;
import com.three.web2.repository.TeacherRepository;



/**
 * Admin权限下的删除和修改 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminPyyController {
	@Autowired
	AdminRepository ar;
	@Autowired
	StudentRepository stur;
	@Autowired
	ScoreRepository scor;
	@Autowired
	TeacherRepository tr;
	
	@Autowired
	LoginMapper ls;
	/**
	 * 修改学生成绩
	 */
	@PutMapping
	public Score updateScore(@RequestBody Score score) {
		return	scor.save(score);
	}
	
	/**
	 * 修改学生信息
	 */
	
	@PutMapping
	public Student updateStudent(@RequestBody Student student) {
		return stur.save(student);
	}
	
	
	/**
	 * 修改老师信息
	 */
	
	@PutMapping
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		return tr.save(teacher);
	}
	
	
	/**
	 * 
	 * 删除学生/老师信息    修改状态---隐藏
	 * @param id
	 * @return
	 */
	@PutMapping
	public void delStudent(@RequestParam String loginName) {
		 ls.update(loginName);
	}
	
	
}
