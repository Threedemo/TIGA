package com.three.web2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Score;


@Repository
public interface ScoreRepository extends MongoRepository<Score, String>{
	
	/**
	 * 通过学号学期查询学生成绩
	 * @param stuId
	 * @param semId
	 * @return
	 */
	@Query(value = "{'semesterId':?0,'stuId':?1}")
	Score findByStuIdAndSemesterId(String semesterId,String stuId);
	
	/**
	 * 查询一个班的学生成绩信息
	 * @param claId
	 * @return
	 */
	@Query(value = "{'claId':?0,'semesterId':?1}")
	List<Score> findByClaId(String claId,String semesterId);
	
	
    @Query(value = "{'stuId':?0,'semesterId':?1}")
	Score findByStuIdScore(String stuId,String semesterId);
}
