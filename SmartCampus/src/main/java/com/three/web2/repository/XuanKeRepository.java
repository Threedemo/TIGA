package com.three.web2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.XuanKe;

/**
 * 选课仓库
 * @author win10
 *
 */
@Repository
public interface XuanKeRepository extends MongoRepository<XuanKe, String> {
	
	@Query(value = "{'semesterId': ?0}")
	List<XuanKe> findBySemesterId(String semesterId);
	
}
