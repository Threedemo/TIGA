package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Semester;

@Repository
public interface SemesterRepository extends MongoRepository<Semester, String>{

}
