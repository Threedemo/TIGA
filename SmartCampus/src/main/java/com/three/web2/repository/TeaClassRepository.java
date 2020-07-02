package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.TeaClass;

@Repository
public interface TeaClassRepository extends MongoRepository<TeaClass, String>{

}
