package com.three.web2.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

}
