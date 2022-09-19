package com.tweetapp.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TweetReplyMapper {

  public List<TweetReply> mapToTweetReply(List<Reply> replies, Tweets tweet,List<TweetReply> tweetReplies) {
    TweetReply tweetReply = new TweetReply();
     if(replies.size()==0) {
       tweetReply.setEmail(tweet.getEmail());
       tweetReply.setTweetDescription(tweet.getDescription());
       tweetReply.setTweetedDate(tweet.getMsgPostTime());
       tweetReply.setUserName(tweet.getUserName());
       tweetReply.setTweetLike(tweet.getLike());
       tweetReplies.add(tweetReply);
     }
     else {
       for (Reply reply : replies) {
         if (reply != null && tweet!=null) {
           tweetReply.setEmail(tweet.getEmail());
           tweetReply.setTweetDescription(tweet.getDescription());
           tweetReply.setTweetedDate(tweet.getMsgPostTime());
           tweetReply.setUserName(tweet.getUserName());
           tweetReply.setTweetLike(tweet.getLike());
           tweetReply.setReplyDescription(reply.getMessage());
           tweetReply.setRepliedDate(reply.getMsgPostTime());
         }
         tweetReplies.add(tweetReply);
       }

     }
    return tweetReplies;

  }
}
