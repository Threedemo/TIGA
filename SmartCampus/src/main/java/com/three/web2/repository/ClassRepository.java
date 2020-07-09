package com.three.web2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Classes;
import com.three.web2.pojo.Major;

@Repository
public interface ClassRepository extends MongoRepository<Classes, String>{
	
	@Query(value = "{'mId': ?0}")
	List<Classes> findByMId(String mar);
}
