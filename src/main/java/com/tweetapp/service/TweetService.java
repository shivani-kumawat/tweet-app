package com.tweetapp.service;

import java.util.List;

import com.tweetapp.model.Reply;
import com.tweetapp.model.TweetReply;
import com.tweetapp.model.Tweets;

public interface TweetService {

	List<Tweets> getAllTweets();

	Tweets postTweet(Tweets tweet, String userName);

	Tweets updateTweet(String newTweet,String oldTweet, String tweetId);

	void deleteTweetbyId(String tweetId,String description);

	Tweets doLike(String id, String description);
	Reply postReply(Reply reply);

	List<Tweets> getTweetsByUser(String userName);
	List<TweetReply> getAllTweetsOfUser(String id);

	List<Tweets> getTweetsReply(String tweetId);


}
