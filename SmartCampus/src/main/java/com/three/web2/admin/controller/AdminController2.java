package com.three.web2.admin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.LoginService;
import com.three.web2.jwt.JwtUtil;
import com.three.web2.pojo.Admin;
import com.three.web2.pojo.Classes;
import com.three.web2.pojo.Department;
import com.three.web2.pojo.Evaluate;
import com.three.web2.pojo.Login;
import com.three.web2.pojo.Major;
import com.three.web2.pojo.Message;
import com.three.web2.pojo.Notice;
import com.three.web2.pojo.Score;
import com.three.web2.pojo.Semester;
import com.three.web2.pojo.Student;
import com.three.web2.pojo.Teacher;
import com.three.web2.pojo.XuanKe;
import com.three.web2.repository.AdminRepository;
import com.three.web2.repository.ClassRepository;
import com.three.web2.repository.DepartmentRepository;
import com.three.web2.repository.EvaluateRepository;
import com.three.web2.repository.MajorRepository;
import com.three.web2.repository.MessageRepository;
import com.three.web2.repository.NoticeRepository;
import com.three.web2.repository.ScoreRepository;
import com.three.web2.repository.SemesterRepository;
import com.three.web2.repository.StudentRepository;
import com.three.web2.repository.TeaClassRepository;
import com.three.web2.repository.TeacherRepository;
import com.three.web2.repository.XuanKeRepository;

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
	LoginService loginService;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	TeaClassRepository teaClassRepository;
	
	@Autowired
	ScoreRepository scoreRepository;
	
	@Autowired
	SemesterRepository semesterRepository;
	
	@Autowired
	NoticeRepository noticeRepository;
	
	@Autowired
	EvaluateRepository evaluateRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	XuanKeRepository xuanKeRepository;
	
	@Autowired
	JwtUtil jwtUtil;
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
	@Transactional
	public Student savestudent(@RequestBody Student stu) {
		Login login =new Login();
		login.setLoginName(stu.getLoginName());
		//获取密码
		String pwd=stu.getLoginName();
		//加密密码
		login.setLoginPassword(new BCryptPasswordEncoder().encode(pwd));
		login.setEndbled(1);
		login.setAuthority("ROLE_STUDENT");
		//添加到登录表单中
		loginService.save(login);
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
	 * @return
	 */
	@PostMapping("/teacher")
	@Transactional
	public Teacher saveteacher(@RequestBody Teacher teacher) {
		//获取对象
		Login login=new Login();
		login.setLoginName(teacher.getLoginName());
		//获取密码
		String pwd=teacher.getLoginName();
		//加密密码
		login.setLoginPassword(new BCryptPasswordEncoder().encode(pwd));
		login.setEndbled(1);
		login.setAuthority("ROLE_TEACHER");
		//添加教师登录信息
		loginService.save(login);
		//添加教师班级表信息
		return teacherRepository.save(teacher);
	}
//	@PostMapping("/admin")
//	public Admin saveadmin(@RequestBody Admin admin) {
//		return adminRepository.save(admin);
//	}
	
	/**
	 * 通过班级查询该班的学生基本学生
	 * @param claId
	 * @return
	 */
	@GetMapping("/student")
	public List<Student> stulist(@RequestBody Classes classes){
		
		return sturepository.findByClaId(classes);
	}
	/**
	 * 通过学号查询一个学生基本信息
	 * @param id
	 * @return
	 */
	@GetMapping("/student/{id}")
	public Student stuload(@PathVariable String id) {
		return sturepository.findById(id).get();
	}
	/**
	 * 通过院系的选择显示该院系的专业
	 * @param claId
	 * @return
	 */
	@GetMapping("/major")
	public List<Major> majorlist(@RequestBody Department department){
		
		return majorrepository.findByDepId(department);
	}
	
	/**
	 * 查询学院
	 * @return
	 */
	@GetMapping("/department")
	public List<Department>departments(){
		return deprepository.findAll();
	}
	/**
	 * 查询一个学生的成绩
	 * @param stuId
	 * @return
	 */
	@GetMapping("/score")
	public Score scores(@RequestParam String semesterId
						,@RequestParam String stuId){
		
		return scoreRepository.findByStuIdAndSemesterId(semesterId,stuId);
	}
	/**
	 * 查询一个班级学生的成绩
	 * @param claId
	 * @return
	 */
	@GetMapping("/score/{semesterId}/{claId}")
	public List<Score>scorelist(@PathVariable String semesterId
			,@PathVariable String claId){
		
		return scoreRepository.findByClaId(claId,semesterId);
	}
	
	/**
	 * 通过学院查询一个学院的教师信息
	 * @param depId
	 * @return
	 */
	@GetMapping("/teacher")
	public List<Teacher>teacherBydep(@RequestParam String depId){
		return teacherRepository.findByDepId(depId);
	}
	
	/**
	 * 添加公告的方法
	 * @param notice
	 * @return
	 */
	@SuppressWarnings("deprecation")//抑制警告
	@PostMapping("/notice")
	public Notice saveNotice(@RequestBody Notice notice) {
		notice.setNoticeDate(new Date().toLocaleString().toString());
		return noticeRepository.save(notice);
	}
	
	/**
	 * 显示公告
	 * @return
	 */
	@GetMapping("/notice")
	public List<Notice> noticeList(@RequestParam(name = "p",defaultValue = "1") int page){
		return noticeRepository.findAll(PageRequest.of(page-1, 5)).getContent();
	}
	/**
	 * 添加教评
	 * @param evaluate
	 * @return
	 */
	@PostMapping("/evaluate")
	public Evaluate saveEvaluate(@RequestBody Evaluate evaluate) {
		return evaluateRepository.save(evaluate);
	}
	/**
	 * 分页查看教评
	 * @param page
	 * @return
	 */
	@GetMapping("/evaluate")
	public List<Evaluate>evaluateList(@RequestParam(name = "p",defaultValue = "1") int page){
		return evaluateRepository.findAll(PageRequest.of(page-1, 6)).getContent();
	}
	/**
	 *	添加意见箱
	 * @param message
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@PostMapping("/message")
	public Message saveMessage(@RequestBody Message message) {
		message.setMessageDate(new Date().toLocaleString().toString());
		System.out.println(message);
		return messageRepository.save(message);
	}
	/**
	 *	查询意见箱
	 * @param page
	 * @return
	 */
	@GetMapping("/message")
	public List<Message>messageList(@RequestParam(name = "p",defaultValue = "1") int page){
		return messageRepository.findAll(PageRequest.of(page-1, 10)).getContent();
	}
	/**
	 * 添加选课表课程
	 * @param xuanKe
	 * @return
	 */
	@PostMapping("/xuanke")
	public XuanKe saveXuanke(@RequestBody XuanKe xuanKe) {
		return xuanKeRepository.save(xuanKe);
	}
	/**
	 * 通过id查询一个教师的基本信息
	 * @param id
	 * @return
	 */
	@GetMapping("/teacher/{id}")
	public Teacher loadteacher(@PathVariable String id) {
		try {
			teacherRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
		return teacherRepository.findById(id).get();
	}
	
	
	
	
	/**
	 * 添加学期
	 * @param semester
	 * @return
	 */
	@PostMapping("/semester")
	public Semester saveseme(@RequestBody Semester semester) {
		return semesterRepository.save(semester);
	}
	/**
	 * 添加一条学生成绩
	 * @param score
	 * @return
	 */
	@PostMapping("/score")
	public Score savescore(@RequestBody Score score) {
		return scoreRepository.save(score);
	}
	
	@GetMapping("/admin")
	public Admin Load(@RequestHeader String id) {
		return adminRepository.findById(id).get();
	}
	@GetMapping("/gettoken")
	public String b(@RequestHeader(name = "token") String token) {
		String loginName=jwtUtil.gettoken(token);
		System.out.println(loginName);
		return loginName;
	}
	
}
