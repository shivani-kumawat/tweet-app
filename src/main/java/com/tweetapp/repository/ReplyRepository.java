package com.tweetapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;

public interface ReplyRepository extends MongoRepository<Reply,String> {

	@Query("{'tweetId': ?0}")
	List<Tweets> findReplyByTweet(String tweetId);

	@DeleteQuery(value = "{$and:[{$or:[{'email':?0},{'login_id':?0}]},{'tweetMessage':?1}]}")
	Long deleteTweet(String id, String description);

	@Query(value = "{$and:[{$or:[{'email':?0},{'login_id':?0}]},{'tweetMessage':?1}]}")
	List<Reply> getAllRepliesOfUser(String id, String description);


}
