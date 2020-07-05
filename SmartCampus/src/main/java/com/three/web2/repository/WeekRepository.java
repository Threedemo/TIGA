package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.three.web2.pojo.Week;

/*
 * 周表
 */
public interface WeekRepository extends MongoRepository<Week, String>{

}
