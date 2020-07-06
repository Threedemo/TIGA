package com.three.web2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.three.web2.pojo.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String>{

}
