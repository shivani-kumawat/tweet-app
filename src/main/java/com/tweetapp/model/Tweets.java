package com.tweetapp.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document("tweet")
public class Tweets {
	@Id
	private String tweetId; 
	private String description;
	private String msgPostTime;
	private int like;
	private String userName;

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	private String email;
//
//
//	public String getTweetId() {
//		return tweetId;
//	}
//	public void setTweetId(String tweetId) {
//		this.tweetId = tweetId;
//	}
////	public String getMessage() {
////		return message;
////	}
////	public void setMessage(String message) {
////		this.message = message;
////	}
//	public String getMsgPostTime() {
//		return msgPostTime;
//	}
//	public void setMsgPostTime(String msgPostTime) {
//		this.msgPostTime = msgPostTime;
//	}
//	public Integer getLike() {
//		return like;
//	}
//	public void setLike(Integer like) {
//		this.like = like;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
	
}
