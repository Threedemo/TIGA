package com.three.web2.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.LoginMapper;
import com.three.web2.jwt.JwtUtil;
import com.three.web2.pojo.ClassCourse;
import com.three.web2.pojo.Classes;
import com.three.web2.pojo.Score;
import com.three.web2.pojo.Student;
import com.three.web2.pojo.StudentXuanKe;
import com.three.web2.pojo.XuanKe;
import com.three.web2.repository.ClassCourseRepository;
import com.three.web2.repository.ClassRepository;
import com.three.web2.repository.ScoreRepository;
import com.three.web2.repository.StudentRepository;
import com.three.web2.repository.StudentXuanKeRepository;
import com.three.web2.repository.XuanKeRepository;

/**
 * 学生管理模块控制器
 * @author 何根文
 *
 */
@RestController
@RequestMapping("/student")
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
	@Autowired
	XuanKeRepository xkr;
	@Autowired
	ClassRepository classr;
	@Autowired
	JwtUtil jwtu;
	@Autowired
	ClassCourseRepository ccry;
	
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
	@GetMapping("/me")
	public Student getO(
			@RequestHeader(name = "token") String token) {
		String loginName=jwtu.gettoken(token);
		System.out.println(loginName);
		return str.findById(loginName).get();
	}
	
	/**
	 * 查课表
	 * @param stu
	 * @param zo
	 * @return
	 */
//	@GetMapping("/cl/{claid}")
//	public List<ClassCourse> getcc(
//			@PathVariable String claid){
//		return ccr.classc(claid);
//	}
	/**
	 * 查成绩
	 * @param stu
	 * @param ssr
	 * @return
	 */
	@GetMapping("/sc/{ssr}")
	public Score getss(@RequestHeader(name = "token") String token,
			@PathVariable String ssr){
		String loginName=jwtu.gettoken(token);
		return sr.findByStuIdAndSemesterId(loginName, ssr);
	}
	/**
	 * 查询全部选课
	 * @return
	 */
	@GetMapping("/selxk")
	public List<XuanKe> selXk(){
		return	xkr.findAll();
	}
	/**
	 * 查询班级
	 * @return
	 */
	@GetMapping("/selclass")
	public List<Classes> selclass(){
		return classr.findAll();
	}
	/**
	 * 添加选课
	 * @param xk
	 * @return
	 */
	@PostMapping("/sxk/{xkid}")
	public void setXk(
			@PathVariable String xkid ,
			@RequestHeader(name = "token") String token
			) {
		String loginName=jwtu.gettoken(token);
		StudentXuanKe sxk=new StudentXuanKe();
		sxk.setStuId(str.findById(loginName).get());
		sxk.setXkId(xkr.findById(xkid).get());
		List<StudentXuanKe> ls=sxkr.findAll();
		for(StudentXuanKe stk:ls) {
			if(!stk.equals(sxk)) {
				sxkr.save(sxk);
			}
		}
	}
	/**
	 *查 我的选课
	 * @param stuid
	 * @return
	 */
	@GetMapping("/myxk")
	public List<StudentXuanKe> myxk(
			@RequestHeader(name = "token") String token){
		String loginName=jwtu.gettoken(token);
		return sxkr.findBystuId(loginName);
	}
	/**
	 * 删除选课
	 * @param sid
	 * @param xk
	 */
	@DeleteMapping("/delxk/{sxkid}")
	public void delXk(@PathVariable String sxkid) {
		 sxkr.deleteById(sxkid);
	}
	
	/**
	 * 修改密码
	 * @param lp
	 * @param ln
	 * @return
	 */
	@PutMapping("/ups/{odlp}/{lp}")
	public void upSm(@PathVariable String odlp
			,@PathVariable String lp
			,@RequestHeader(name = "token") String token) {
		String loginName=jwtu.gettoken(token);
		System.out.println(lm.getOne(loginName).toString());
		if(odlp.equals(lm.getOne(loginName).getLoginPassword())) {
			//加密密码
			lp=new BCryptPasswordEncoder().encode(lp);
			lm.upl(loginName, lp);
		}
	}
	
	/**
	 * 班级课表
	 * @param claid
	 * @return
	 */
	@GetMapping("/stuCour/{claid}")
	public List<ClassCourse> stucr(@PathVariable String claid){
		return ccry.classc(claid);
	}
	/**
	 * 我忘记密码
	 * @param sin
	 * @param ln
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/cko/{stuidnum}/{loginpwd}")
	public void ckO(@PathVariable String stuidnum,
			@PathVariable String loginpwd
			,@RequestHeader(name = "token") String token){
		String loginName=jwtu.gettoken(token);
		if(str.cheko(loginName, stuidnum)!=null) {
			//加密密码
			loginpwd=new BCryptPasswordEncoder().encode(loginpwd);
			lm.upl(loginName, loginpwd);
		}
	}
	
}
