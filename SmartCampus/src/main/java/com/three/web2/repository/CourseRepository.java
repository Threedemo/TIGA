package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Course;
/**
 * 成绩信息表
 * @author Sqi
 * @version 2020年7月2日 下午3:39:31
 */
@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

}
