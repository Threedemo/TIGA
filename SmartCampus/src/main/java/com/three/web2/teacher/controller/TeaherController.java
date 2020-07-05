package com.three.web2.teacher.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.pojo.ClassHours;
import com.three.web2.pojo.ClassRoom;
import com.three.web2.pojo.Course;
import com.three.web2.pojo.Student;
import com.three.web2.pojo.TeaClass;
import com.three.web2.pojo.Teacher;
import com.three.web2.pojo.Week;
import com.three.web2.pojo.Zhou;
import com.three.web2.repository.ClassHoursRepository;
import com.three.web2.repository.ClassRoomRepository;
import com.three.web2.repository.CourseRepository;
import com.three.web2.repository.StudentRepository;
import com.three.web2.repository.TeaClassRepository;
import com.three.web2.repository.TeacherRepository;
import com.three.web2.repository.WeekRepository;
import com.three.web2.repository.ZhouRrpository;

@RestController
@RequestMapping("/teacher")
public class TeaherController {

	@Autowired
	TeacherRepository tr;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TeaClassRepository teaClassRepository;
	
	@Autowired
	WeekRepository weekrepositpry;
	
	@Autowired
	ZhouRrpository zhouRrpository;
	
	@Autowired
	ClassHoursRepository classHoursRepository;
	
	
	@Autowired
	ClassRoomRepository classRoomRepository;
	
	/**
	 * 添加教师信息
	 * 后续放到教务Controller
	 * @param teacher
	 * @return
	 */
	@PostMapping("/tea")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		return tr.save(teacher);
	}
	
	/**
	 * 添加成绩  后续放到  adminController
	 * @param course
	 * @return
	 */
	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	/**
	 * 老师班级表，
	 * 老师上课的班级
	 * 后放到AdminController
	 * @param teaClass
	 * @return
	 */
	@PostMapping("/teaClass")
	public TeaClass saveTeaClass(@RequestBody TeaClass teaClass) {
		return teaClassRepository.save(teaClass);
	}
	
	@GetMapping("/tea/{teaId}")
	public List<TeaClass> findAl(@PathVariable String teaId){
		return teaClassRepository.all(teaId);
	}
	
	@GetMapping("/teac/{claId}")
	public List<TeaClass> findA(@PathVariable String claId){
		return teaClassRepository.al(claId);
	}
	
	/**
	 * 添加星期表
	 * @param week
	 * @return
	 * 后放到AdminRepository
	 */
	@PostMapping("/week")
	public Week find(@RequestBody Week week) {
		return weekrepositpry.save(week);
	}
	
	/**
	 * 添加周表
	 * @param zhou
	 * @return
	 * 后放到AdminRepository
	 */
	@PostMapping("/zhou")
	public Zhou fin(@RequestBody Zhou zhou) {
		return zhouRrpository.save(zhou);
	}
	
	@PostMapping("/classhours")
	public ClassHours fi(@RequestBody ClassHours classhours) {
		return classHoursRepository.save(classhours);
	}
	
	@PostMapping("/classroom")
	public ClassRoom classroom(@RequestBody ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
	}
	
	
	
	
	
	
	
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
