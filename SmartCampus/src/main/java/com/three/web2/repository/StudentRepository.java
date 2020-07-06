package com.three.web2.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Classes;
import com.three.web2.pojo.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	/**
	 * 查询班级学生
	 * @param claName
	 * @return
	 * 邵琪
	 */
	@Query(value = "{'claId': ?0}")
	List<Student> all(String claId);
	
	
	
	List<Student> findByClaId(Classes claId);
}
