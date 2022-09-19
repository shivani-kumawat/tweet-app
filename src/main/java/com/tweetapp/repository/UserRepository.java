package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

	User findTweetsByuserName(String userName);

	@Query("{'email': ?0, 'password': ?1}")
	User findUserByUserNameAndPassword(String userName, String password);

	@Query("{'email':{'$regex':'?0','$options':'i'}}")
	List<User> findUserByName(String userName);

	@Query("{'email': ?0}")
	User findUserByUserName(String userName);
		
}
