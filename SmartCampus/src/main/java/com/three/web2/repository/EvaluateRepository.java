package com.three.web2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Evaluate;

/**
 * 教评仓库
 * @author win10
 *
 */
@Repository
public interface EvaluateRepository extends MongoRepository<Evaluate, String> {
	
	/**
	 * 查看教评
	 * 
	 * @param teaId
	 * @return
	 */
	@Query(value = "{'teald': ?0}")
	List<Evaluate> teaEvaluatae(String teaId);

}
