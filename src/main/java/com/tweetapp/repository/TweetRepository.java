package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetapp.model.Tweets;

@Repository
public interface TweetRepository extends MongoRepository<Tweets,String>{

	@Query("{'email':{'$regex':'?0','$options':'i'}}")
	List<Tweets> findTweetsByuserName(String userName);

	@DeleteQuery(value = "{$and:[{$or:[{'email':?0},{'login_id':?0}]},{'description':?1}]}")
	Long deleteTweet(String id, String description);

//	@Query(value = "{$and:[{$or:[{'email':?1},{'login_id':?1}]},{'description':?0}]}")
	Tweets findByDescriptionAndEmail(String name, String id);

	@Query(value = "{$or:[{'email':?0},{'login_id':?0}]}")
	List<Tweets> findByEmail(String id);
}
