package com.navproduct.service;

import java.util.List;

import com.navproduct.exception.NavServiceException;
import com.navproduct.model.User;

public interface UserService {

	public List<User> getAllUsers()  throws NavServiceException;

	public void update(User user)  throws NavServiceException;
	
	public void Save(User user)  throws NavServiceException;
}
