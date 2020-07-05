package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.ClassHours;

/**
 * 授课时间表
 * @author Sqi
 * @version 2020年7月3日 下午12:10:07
 */
@Repository
public interface ClassHoursRepository extends MongoRepository<ClassHours, String>{

}
