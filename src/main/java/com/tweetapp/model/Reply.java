package com.tweetapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("reply")
public class Reply {
	@Id
	private String replyId;
	private String message;
	private String msgPostTime;
	private String userName;
	private String tweetMessage;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String email;
	
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMsgPostTime() {
		return msgPostTime;
	}
	public void setMsgPostTime(String msgPostTime) {
		this.msgPostTime = msgPostTime;
	}
	public String getTweetMessage() {
		return tweetMessage;
	}
	public void setTweetMessage(String tweetMessage) {
		this.tweetMessage = tweetMessage;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
		
}
