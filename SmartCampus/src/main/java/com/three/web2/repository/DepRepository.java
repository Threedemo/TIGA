package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Department;
/**
 * 院系仓库
 * @author 陈明明
 *
 */
@Repository
public interface DepRepository extends MongoRepository<Department, String>{

}
