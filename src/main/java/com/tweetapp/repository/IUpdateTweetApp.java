package com.tweetapp.repository;

import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;
import com.tweetapp.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUpdateTweetApp {

  User updateTweetApp(String id, String password);

  Tweets updateTweet(String id, String updatedTweet, String oldTweet);
  Reply updateReply(String id, String updatedTweet, String oldTweet);


  Tweets doLike(String id, String description, int count);
}
