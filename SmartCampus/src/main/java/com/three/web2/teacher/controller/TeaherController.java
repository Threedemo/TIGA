package com.three.web2.teacher.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.three.web2.pojo.ClassCourse;
import com.three.web2.pojo.ClassHours;
import com.three.web2.pojo.ClassRoom;
import com.three.web2.pojo.Classes;
import com.three.web2.pojo.Course;
import com.three.web2.pojo.Score;
import com.three.web2.pojo.Semester;
import com.three.web2.pojo.Student;
import com.three.web2.pojo.TeaClass;
import com.three.web2.pojo.Teacher;
import com.three.web2.pojo.Week;
import com.three.web2.pojo.Zhou;
import com.three.web2.repository.ClassCourseRepository;
import com.three.web2.repository.ClassHoursRepository;
import com.three.web2.repository.ClassRoomRepository;
import com.three.web2.repository.CourseRepository;
import com.three.web2.repository.ScoreRepository;
import com.three.web2.repository.SemesterRepository;
import com.three.web2.repository.StudentRepository;
import com.three.web2.repository.TeaClassRepository;
import com.three.web2.repository.TeacherRepository;
import com.three.web2.repository.WeekRepository;
import com.three.web2.repository.ZhouRrpository;

@RestController
@RequestMapping("/teacher")
public class TeaherController {

	private static final HashMap<String, Double> Score = null;

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

	@Autowired
	ClassCourseRepository classCourseRepository;

	@Autowired
	ScoreRepository scoreRepository;

	@Autowired
	SemesterRepository semesterRepository;

	/**
	 * 添加教师信息 后续放到教务Controller
	 * 
	 * @param teacher
	 * @return
	 */
	@PostMapping("/tea")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		return tr.save(teacher);
	}

	/**
	 * 添加成绩 后续放到 adminController
	 * 
	 * @param course
	 * @return
	 */
	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}

	/**
	 * 老师班级表， 老师上课的班级 后放到AdminController
	 * 
	 * @param teaClass
	 * @return
	 */
	@PostMapping("/teaClass")
	public TeaClass saveTeaClass(@RequestBody TeaClass teaClass) {
		return teaClassRepository.save(teaClass);
	}

	@GetMapping("/tea/{teaId}")
	public List<TeaClass> findAl(@PathVariable String teaId) {
		return teaClassRepository.all(teaId);
	}

	@GetMapping("/teac/{claId}")
	public List<TeaClass> findA(@PathVariable String claId) {
		return teaClassRepository.al(claId);
	}

	/**
	 * 添加星期表
	 * 
	 * @param week
	 * @return 后放到AdminRepository
	 */
	@PostMapping("/week")
	public Week find(@RequestBody Week week) {
		return weekrepositpry.save(week);
	}

	/**
	 * 添加周表
	 * 
	 * @param zhou
	 * @return 后放到AdminRepository
	 */
	@PostMapping("/zhou")
	public Zhou fin(@RequestBody Zhou zhou) {
		return zhouRrpository.save(zhou);
	}

	/**
	 * 添加授课时间表
	 * 
	 * @param classhours
	 * @return
	 */
	@PostMapping("/classhours")
	public ClassHours fi(@RequestBody ClassHours classhours) {
		return classHoursRepository.save(classhours);
	}

	/**
	 * 添加教室
	 * 
	 * @param classRoom
	 * @return
	 */
	@PostMapping("/classroom")
	public ClassRoom classroom(@RequestBody ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
	}

	/**
	 * 添加课程表
	 * 
	 * @param classCourse
	 * @return
	 */
	@PostMapping("/classcourse")
	public ClassCourse classcourse(@RequestBody ClassCourse classCourse) {
		return classCourseRepository.save(classCourse);
	}

	/**
	 * 通过班级查询课表 学生课程表
	 * 
	 * @param claId
	 * @return
	 */
	@GetMapping("/classCou/{claId}")
	public List<ClassCourse> courseclassAll(@PathVariable String claId) {
		return classCourseRepository.classc(claId);
	}

	/**
	 * 通过老师查询课表 老师课程表
	 * 
	 * @param teaId
	 * @return
	 */
	@GetMapping("/teacou/{teaId}")
	public List<ClassCourse> courseteaAll(@PathVariable String teaId) {
		return classCourseRepository.classtea(teaId);
	}

	/**
	 * 查询老师任课课程
	 * 
	 * @param loginName
	 * @return
	 */
//	@GetMapping("/teachercourse/{loginName}")
//	public Teacher teachercourse(@PathVariable String loginName) {
//		return tr.teacourse(loginName);
//	}

	/**
	 * 添加成绩
	 * 
	 * @param stuId     学生对象
	 * @param semId     学期
	 * @param claId     班级
	 * @param loginName 老师编号
	 * @param ping      平时成绩*0.4
	 * @param kao       考试成绩*0.6
	 * @return
	 */
	@PostMapping("/stuScore")
	@Transactional
	public Score stuScore(@RequestParam String stuId,
			@RequestParam String semesterId, @RequestParam String loginName,
			@RequestParam Double ping, @RequestParam Double kao) {
		Score score = new Score();
		HashMap<String, Double> stuscore = new HashMap<>();
		// 判断成绩表是否为空
		if (scoreRepository.findByStuIdScore(stuId, semesterId) != null) {
			score = scoreRepository.findByStuIdScore(stuId, semesterId);
			stuscore = score.getScore();
			// 老师授课课程
			Teacher teacher = tr.teaload(loginName);
			String name = teacher.getCourseId().getCourseName();
			
			Double src = ping * 0.6 + kao * 0.4;
			stuscore.put(name, src);
			score.setScore(stuscore);
			return scoreRepository.save(score);

		} else {
			Teacher teacher = tr.teaload(loginName);
			String name = teacher.getCourseId().getCourseName();
			Double src = ping * 0.6 + kao * 0.4;
			score.setStuId(studentRepository.findById(stuId).get());
			score.setClaId(studentRepository.findById(stuId).get().getClaId());
			score.setSemesterId(semesterRepository.findById(semesterId).get());
			stuscore.put(name, src);
			return scoreRepository.save(score);
		}

	}

	/**
	 * 查询教师基本信息 邵琪
	 */
	@GetMapping
	public List<Teacher> FindAll() {
		return tr.findAll();
	}

	/**
	 * 查询某个班级学生信息
	 * 
	 * @param claId
	 * @return
	 */
	@GetMapping("/stu/{claId}")
	public List<Student> findAll(@PathVariable String claId) {
		return studentRepository.all(claId);
	}

	/**
	 * 查询任课班级
	 */

	/**
	 * 查询任课班级详细信息
	 */

	/**
	 * 查询任课成绩
	 * 
	 * @return
	 * 
	 */
//	@GetMapping("/stuscorelist/{claId}/{semesterId}")
//	public List<Score> stuscorelist(
//			@PathVariable String claId,
//			@PathVariable String semesterId){
//		
//		List<Score> scorelist=scoreRepository.findByClaId(claId,semesterId);
//		for (Score score : scorelist) {
//			HashMap<String,Double>hash=score.getScore();
//			for (String Key : hash.keySet()) {
//				if (!Key.equals("")) {
//					
//				}
//			}
//		}
//		return null;
//		
//	
//		 
//	}

	@GetMapping("/stuscorelist/{claId}/{loginName}/{semesterId}")
	public List<Score> stuscorelist(@PathVariable String claId,
			@PathVariable String loginName,
			@PathVariable String semesterId ) {

		Teacher teacher = tr.teaload(loginName);
		String name = teacher.getCourseId().getCourseName();
		

		 System.out.println(name);
		
		List<Score> scorelist = scoreRepository.findByClaId(claId, semesterId);
		System.out.println(scorelist);
		
		for (Score score : scorelist) {
			//遍历map
			HashMap<String,Double>map=score.getScore();
			
			for (String key : map.keySet()) {
				if (!name.equals(key)) {
//					map.remove(key);
				}
			}
			System.out.println(map);
			
		}
		return scorelist ;

	}

}
