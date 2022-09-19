package com.tweetapp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tweetapp.model.TweetReply;
import com.tweetapp.model.TweetReplyMapper;
import com.tweetapp.repository.IUpdateTweetApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;
import com.tweetapp.repository.ReplyRepository;
import com.tweetapp.repository.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
	private IUpdateTweetApp updateTweetApp;

	@Autowired
	private TweetReplyMapper tweetReplyMapper;

	@Override
	public List<Tweets> getAllTweets() {
		List<Tweets> allTweets = new ArrayList<Tweets>();
		try {
			allTweets = tweetRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allTweets;
	}

	@Override
	public Tweets postTweet(Tweets tweet, String userName) {
		System.out.println("twe");
		Tweets savedTweet=new Tweets();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		try {
		tweet.setEmail(userName);
		tweet.setMsgPostTime(dateFormat.format(date));
		savedTweet= tweetRepository.save(tweet);}
		catch (Exception e) {
			e.printStackTrace();
		}
		return savedTweet;
	}

	@Override
	public Tweets updateTweet(String newTweet,String oldTweet, String tweetId) {

		Tweets tweet=updateTweetApp.updateTweet(tweetId, newTweet, oldTweet);
		Reply reply=updateTweetApp.updateReply(tweetId,newTweet,oldTweet);
		return tweet;
	}

	public Tweets doLike(String id, String description) {
		Tweets tweet = tweetRepository.findByDescriptionAndEmail(description, id);
		System.out.println("tweet"+tweet);
		int count = tweet.getLike();
		Tweets returnedTweet = updateTweetApp.doLike(id, description, count);
		return returnedTweet;
	}

	@Override
	public void deleteTweetbyId(String tweetId,String description) {
		// TODO Auto-generated method stub

		try {
			tweetRepository.deleteTweet(tweetId,description);
			replyRepository.deleteTweet(tweetId,description);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public Reply postReply(Reply reply) {
		Tweets tweet = tweetRepository.findByDescriptionAndEmail(reply.getTweetMessage(),reply.getEmail());
		if (tweet != null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			Reply tweetReply = new Reply();
			tweetReply.setReplyId(tweet.getTweetId());
			tweetReply.setEmail(tweet.getEmail());
			tweetReply.setEmail(reply.getEmail());
			tweetReply.setMsgPostTime(dateFormat.format(date));
			tweetReply.setMessage(reply.getMessage());
			tweetReply.setTweetMessage(reply.getTweetMessage());
			tweetReply.setUserName(tweet.getUserName());
			return replyRepository.save(tweetReply);
		} else {
			return null;
		}
	}

	@Override
	public List<Tweets> getTweetsByUser(String userName) {
		
		return tweetRepository.findTweetsByuserName(userName);
	}

	@Override
	public List<Tweets> getTweetsReply(String tweetId) {
		// TODO Auto-generated method stub
		return replyRepository.findReplyByTweet(tweetId);
	}

	@Override
	public List<TweetReply> getAllTweetsOfUser(String id) {
		System.out.println("email   "+id);
		List<Tweets> tweets = tweetRepository.findByEmail(id);
		System.out.println("tweets  "+tweets);
		List<TweetReply> tweetReplies = new ArrayList<>();
		for (Tweets tweet : tweets) {
			if (tweet != null && tweet.getDescription() != null) {
				String tweet_msg = tweet.getDescription();
				List<Reply> replies = replyRepository.getAllRepliesOfUser(id, tweet_msg);
				tweetReplies = tweetReplyMapper.mapToTweetReply(replies, tweet,tweetReplies);

			}
		}

		return tweetReplies;
	}


}
