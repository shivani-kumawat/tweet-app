package com.tweetapp.service;

import java.util.List;
import com.tweetapp.model.User;

public interface UserService {
	
	public User registerUser(User user);

	public List<User> getAllUsers();

	public User getTweetsByUser(String userName);

	public User loginUser(User user);

	public User getUserByName(String userName);

	public User updatePassword(User user, String userName);


}
