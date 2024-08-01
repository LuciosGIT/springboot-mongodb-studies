package com.joselucio.mongodbcourse.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joselucio.mongodbcourse.domain.Post;


public interface PostRepository extends MongoRepository<Post,String>{

	List<Post> findByTitleContainingIgnoreCase(String text);
		
	
}
