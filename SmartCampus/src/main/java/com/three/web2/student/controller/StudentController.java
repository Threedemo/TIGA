package com.three.web2.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.LoginMapper;
import com.three.web2.pojo.ClassCourse;
import com.three.web2.pojo.Score;
import com.three.web2.pojo.Student;
import com.three.web2.pojo.StudentXuanKe;
import com.three.web2.repository.ClassCourseRepository;
import com.three.web2.repository.ScoreRepository;
import com.three.web2.repository.StudentRepository;
import com.three.web2.repository.StudentXuanKeRepository;

/**
 * 学生管理模块控制器
 * @author 何根文
 *
 */
@RequestMapping("/student")
@RestController
public class StudentController {
	@Autowired
	LoginMapper lm;
	@Autowired
	StudentRepository str;
	@Autowired
	ClassCourseRepository ccr;
	@Autowired
	ScoreRepository sr;
	@Autowired
	StudentXuanKeRepository sxkr;
	
	//学生管理首页
//	@GetMapping("/student")
//	public String ind() {
//		return "student.html";
//	}
	
	/**
	 * 查个人信息
	 * @param sid
	 * @return
	 */
	@ResponseBody
	@GetMapping("/me/{loginName}")
	public Student getO(@PathVariable String loginName) {
		return str.findById(loginName).get();
	}
	
	/**
	 * 查课表
	 * @param stu
	 * @param zo
	 * @return
	 */
	@GetMapping("/cl/{claid}")
	public List<ClassCourse> getcc(
			@PathVariable String claid){
		return ccr.classc(claid);
	}
	
	/**
	 * 查成绩
	 * @param stu
	 * @param ssr
	 * @return
	 */
	@GetMapping("/sc")
	public Score getss(@RequestParam String stu,
			@RequestParam String ssr){
		return sr.findByStuIdAndSemesterId(stu, ssr);
	}
	
	/**
	 * 添加选课
	 * @param xk
	 * @return
	 */
	@ResponseBody
	@PostMapping("/sxk")
	public StudentXuanKe setXk(@RequestBody StudentXuanKe xk) {
		return sxkr.save(xk);
	}
	/**
	 *查 我的选课
	 * @param stuid
	 * @return
	 */
	@GetMapping("/myxk/{stuid}")
	public List<StudentXuanKe> myxk(@PathVariable String stuid){
	
		return sxkr.findBystuId(stuid);
	}
	/**
	 * 删除选课
	 * @param sid
	 * @param xk
	 */
	@ResponseBody
	@DeleteMapping("/delxk/{xkid}")
	public void delXk(@PathVariable String xkid) {
		 sxkr.deleteById(xkid);
	}
	
	/**
	 * 修改密码
	 * @param lp
	 * @param ln
	 * @return
	 */
	@ResponseBody
	@PutMapping("/ups/{lp}/{ln}/{odlp}")
	public void upSm(@PathVariable String lp
			,@PathVariable String ln,@PathVariable String odlp) {
		System.out.println(lm.getOne(ln).toString());
		if(odlp.equals(lm.getOne(ln).getLoginPassword())) {
			//加密密码
			lp=new BCryptPasswordEncoder().encode(lp);
			lm.upl(ln, lp);
		}
		
	}
	
	/**
	 * 我忘记密码
	 * @param sin
	 * @param ln
	 * @return
	 */
	@PostMapping("/cko/{stuidnum}/{loginName}/{loginpwd}")
	public void ckO(@PathVariable String stuidnum,
			@PathVariable String loginName,@PathVariable String loginpwd) {
		if(str.cheko(loginName, stuidnum)!=null) {
			//加密密码
			loginpwd=new BCryptPasswordEncoder().encode(loginpwd);
			lm.upl(loginName, loginpwd);
		}
	}
	
}
