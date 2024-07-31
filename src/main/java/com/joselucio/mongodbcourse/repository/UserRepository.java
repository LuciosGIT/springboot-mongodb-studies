package com.joselucio.mongodbcourse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joselucio.mongodbcourse.domain.User;

public interface UserRepository extends MongoRepository<User,String>{

}
