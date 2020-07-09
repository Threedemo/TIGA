package com.three.web2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Department;
import com.three.web2.pojo.Major;

@Repository
public interface MajorRepository extends MongoRepository<Major, String>{
	
	List<Major>findByDepId(String depid);
}
