package com.three.web2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.ClassCourse;
import com.three.web2.pojo.TeaClass;
/**
 * 排课表
 * @author Sqi
 * @version 2020年7月5日 下午9:29:46
 */
@Repository
public interface ClassCourseRepository extends MongoRepository<ClassCourse,String>{

	/**
	 * 通过班级查课表
	 * @param claId
	 * @return
	 */
	@Query(value = "{'claId': ?0}")
	List<ClassCourse> classc(String claId);
	
	/**
	 * 通过教师id查询课表
	 * @param claId
	 * @return
	 */
	@Query(value = "{'teaId': ?0}")
	List<ClassCourse> classtea(String teaId);
	
}
