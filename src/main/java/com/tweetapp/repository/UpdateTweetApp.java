package com.tweetapp.repository;

import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;
import com.tweetapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
@Document(collation = "userprofile")
public class UpdateTweetApp implements IUpdateTweetApp {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public User updateTweetApp(String id, String password) {
    Query query = new Query();
    query.addCriteria(new Criteria().orOperator(where("email").is(id), where("login_id").is(id)));
    Update update = new Update();
    update.set("password", password);
    update.set("confirm_password", password);
    return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), User.class);
  }

  @Override
  public Tweets updateTweet(String id, String updatedTweet, String oldTweet) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    Query query = new Query();
    query.addCriteria(new Criteria().andOperator(Criteria.where("email").is(id),
        Criteria.where("description").is(oldTweet)));
    Update update = new Update();
    update.set("description", updatedTweet);
    update.set("msgPostTime", dateFormat.format(date));
    return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Tweets.class);
  }

  @Override
  public Reply updateReply(String id, String updatedTweet, String oldTweet) {
    Query query = new Query();
    query.addCriteria(new Criteria().andOperator(Criteria.where("email").is(id),
        Criteria.where("tweetMessage").is(oldTweet)));
    Update update = new Update();
    update.set("tweetMessage", updatedTweet);
    return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Reply.class);
  }

  @Override
  public Tweets doLike(String id, String description, int count) {

    Query query = new Query();
    query.addCriteria(new Criteria().andOperator(Criteria.where("email").is(id),
        Criteria.where("description").is(description)));
    Update update = new Update();
    update.set("like", ++count);
    return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Tweets.class);
  }
}
