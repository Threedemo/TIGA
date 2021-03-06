package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Admin;
/**
 * 管理员仓库
 * @author 陈明明
 *
 */
@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

}
