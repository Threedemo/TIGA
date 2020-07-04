package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Score;
import com.three.web2.pojo.Semester;
import com.three.web2.pojo.Student;

@Repository
public interface ScoreRepository extends MongoRepository<Score, String>{
	
	/**
	 * 通过学号学期查询学生成绩
	 * @param stuId
	 * @param semId
	 * @return
	 */
	@Query(value = "{'stuId':?0,'semesterId':?1}")
	Score findByStuIdAndSemesterId(Student stuId,Semester semId);
	
	
}
