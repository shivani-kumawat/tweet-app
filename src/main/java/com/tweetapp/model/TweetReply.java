package com.tweetapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;
import org.springframework.stereotype.Component;
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class TweetReply {

  @JsonProperty("_id")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String id;

  public Integer getReplyId() {
    return replyId;
  }

  public void setReplyId(Integer replyId) {
    this.replyId = replyId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getReplierName() {
    return replierName;
  }

  public void setReplierName(String replierName) {
    this.replierName = replierName;
  }

  public String getTweetDescription() {
    return tweetDescription;
  }

  public void setTweetDescription(String tweetDescription) {
    this.tweetDescription = tweetDescription;
  }

  public String getReplyDescription() {
    return replyDescription;
  }

  public void setReplyDescription(String replyDescription) {
    this.replyDescription = replyDescription;
  }

  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRepliedDate() {
    return repliedDate;
  }

  public void setRepliedDate(String repliedDate) {
    this.repliedDate = repliedDate;
  }

  public String getTweetedDate() {
    return tweetedDate;
  }

  public void setTweetedDate(String tweetedDate) {
    this.tweetedDate = tweetedDate;
  }

  public int getTweetLike() {
    return tweetLike;
  }

  public void setTweetLike(int tweetLike) {
    this.tweetLike = tweetLike;
  }

  @JsonProperty("replyId")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer replyId;
  @JsonProperty("userName")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String userName;
  @JsonProperty("replierName")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String replierName;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String tweetDescription;
  @JsonProperty("Reply")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String replyDescription;
  @JsonProperty("loginId")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String loginId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String email;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("reliedDate")
  private String repliedDate;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonProperty("tweetedDate")
  private String tweetedDate;

  private int tweetLike;

}
