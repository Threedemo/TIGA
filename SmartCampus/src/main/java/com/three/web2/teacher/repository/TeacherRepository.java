package com.three.web2.teacher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Teacher;

//教师基本信息
@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
//自定义
}
