package com.three.web2.repository;
/**
 * 周表
 * @author Sqi
 * @version 2020年7月3日 上午9:14:07
 */

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Zhou;
@Repository
public interface ZhouRrpository extends MongoRepository<Zhou, String> {

}
