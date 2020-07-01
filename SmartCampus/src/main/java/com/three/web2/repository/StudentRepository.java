package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
