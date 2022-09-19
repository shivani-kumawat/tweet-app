package com.tweetapp.controller;

import java.util.List;

import com.tweetapp.model.TweetReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.tweetapp.kafka.Producer;
import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweets;
import com.tweetapp.model.User;
import com.tweetapp.service.TweetService;
import com.tweetapp.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/tweets")
public class UserTweetController {

	@Autowired
	private UserService userService;

	@Autowired
	private TweetService tweetservice;

//	public Producer producer;

	@PostMapping(path = "/register")
	public User registerUSer(@RequestBody User user) {
		return userService.registerUser(user);

	}

	@GetMapping(path = "/login")
	public User loginUser(@RequestHeader String id, @RequestHeader String password) {
		User user=new User();
		System.out.println(id+password);
		user.setEmail(id);
		user.setPassword(password);
		User loggedInUser = userService.loginUser(user);
		System.out.println(loggedInUser);
		return loggedInUser;

	}

	@PostMapping(path = "/{email}/forgot")
	public User updatePassword(@RequestHeader String password, @RequestHeader String confirmPassword, @PathVariable String email) {
		User user =new User();
		user.setPassword(password);
		user.setConfirmPassword(confirmPassword);
		User loggedInUser = userService.updatePassword(user, email);
		System.out.println(loggedInUser);
		return loggedInUser;
	}

	@GetMapping(path = "/user/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(path = "/search/{email}")
	public User getUserByName(@PathVariable String email) {
		return userService.getUserByName(email);
	}

	@PostMapping(path = "/add/{email}")
	public Tweets postTweet(@RequestBody Tweets tweet, @PathVariable String email) {
		System.out.println(tweet);
		return tweetservice.postTweet(tweet, email);

	}

	@GetMapping(path = "/all")
	public List<Tweets> getAllTweets() {
		List<Tweets> tweet = tweetservice.getAllTweets();
		return tweet;
	}

	@GetMapping(path = "/{id}")
	public List<TweetReply> getAllTweetsofUser(@PathVariable String id) {
		List<TweetReply> tweet = tweetservice.getAllTweetsOfUser(id);
		System.out.println("tweet  "+tweet);
		return tweet;
	}

	@PutMapping(path = "/update/{email}")
	public Tweets updateTweet(@RequestParam String newTweet, @RequestParam String oldTweet, @PathVariable String email) {
		Tweets updatedTweet = tweetservice.updateTweet(newTweet,oldTweet, email);
		return updatedTweet;
	}

	@DeleteMapping(path = "/delete/{email}")
	public void deleteTweet(@PathVariable String email,@RequestHeader String description) {
		tweetservice.deleteTweetbyId(email,description);

	}

	@PostMapping(path = "/{email}/reply")
	public Reply postReply(@PathVariable String email, @RequestParam String tweetDescription, @RequestParam String replyDescription, @RequestParam(required = false) String replierName) {
		Reply reply=new Reply();
		reply.setEmail(email);
		reply.setMessage(replyDescription);
		reply.setTweetMessage(tweetDescription);
		return tweetservice.postReply(reply);

	}

	@GetMapping(path = "/all/{email}")
	public List<Tweets> getTweetByUser(@PathVariable String email) {
		return tweetservice.getTweetsByUser(email);
	}

	@GetMapping(path = "/getReply/{tweetId}")
	public List<Tweets> getTweetReply(@PathVariable String tweetId) {
		return tweetservice.getTweetsReply(tweetId);
	}

	@PutMapping(path="/like/{email}")
	ResponseEntity<Object> likeTweet(@PathVariable String email, @RequestParam String description){
		System.out.println(email+description);
		Tweets tweet=tweetservice.doLike(email, description);
		System.out.println(tweet.getLike());
		return new ResponseEntity<>(tweet.getLike(), HttpStatus.OK);
	}
//	@Autowired
//	UserTweetController(Producer producer) {
//		this.producer = producer;
//
//	}

//	@GetMapping("/publish")
//	public String sendMessage(@PathVariable String message) {
//		this.producer.sendMessage(message);
//		return "connection established";
//
//	}

}
