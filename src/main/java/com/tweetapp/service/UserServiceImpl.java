package com.tweetapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.model.User;
import com.tweetapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		User savedUser = new User();
		try {
			if (user != null) {
				savedUser = userRepository.save(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savedUser;

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getTweetsByUser(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findTweetsByuserName(userName);
	}

	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		User loginUser = new User();
		try {
			loginUser = userRepository.findUserByUserNameAndPassword(user.getEmail(), user.getPassword());
			if (loginUser != null && loginUser.getEmail().equals(user.getEmail())
					&& loginUser.getPassword().equals(user.getPassword())) {
				return loginUser;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginUser;
	}

	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUserName(userName);
	}

	@Override
	public User updatePassword(User user, String userName) {
		User updateUser=userRepository.findUserByUserName(userName);
		User updatedPassword=new User();
		try {
		if(updateUser!=null) {
		updateUser.setPassword(user.getPassword());
		updateUser.setConfirmPassword(user.getConfirmPassword());
		 updatedPassword=userRepository.save(updateUser);}}
		catch (Exception e) {
			e.printStackTrace();
		}
		return updatedPassword;
	}

}
