package com.three.web2.student.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Student;

//学生操作接口
@Repository
public interface StudentRepository extends MongoRepository<Student,String >{
	//自定义
}
