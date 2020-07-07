package com.three.web2.repository;

import com.three.web2.pojo.StudentXuanKe;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
/**
 * 学生选课仓库
 * @author 何根文
 *
 */
@Repository
public interface StudentXuanKeRepository extends MongoRepository<StudentXuanKe,String> {
	
	List<StudentXuanKe> findBystuId(String stuId);
}
