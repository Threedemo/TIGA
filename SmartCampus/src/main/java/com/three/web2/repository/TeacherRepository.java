package com.three.web2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Login;
import com.three.web2.pojo.Teacher;

//教师基本信息
@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {

	//自定义
	
	@Query(value = "{'loginName': ?0}", fields = "{'_id':0,'oginName':1,'teaName':1}")
	List<Teacher> aa(String loginName);
	
	
	@Query(value ="{'loginName':?0}" ,fields = "{'courseId':1}")
	Teacher teaload(String loginName); 
	
	List<Teacher>findByDepId(String depId);
}
