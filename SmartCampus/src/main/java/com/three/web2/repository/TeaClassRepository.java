package com.three.web2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Student;
import com.three.web2.pojo.TeaClass;

@Repository
public interface TeaClassRepository extends MongoRepository<TeaClass, String>{

	
	/**
	 * 查询班级学生
	 * @param claName
	 * @return
	 * 邵琪
	 */
	@Query(value = "{'teaId': ?0}" ,fields = "{'claId':1}")
	List<TeaClass> all(String teaId);
	@Query(value = "{'claId': ?0}",fields = "{'teaId':1}" )
	List<TeaClass> al(String claId);
}
