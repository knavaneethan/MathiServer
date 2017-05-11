package com.navproduct.dao;

import java.util.List;

import com.navproduct.exception.NavDaoException;
import com.navproduct.model.User;

public interface UserDao {

	public User getUser(String email) throws NavDaoException;

	public List<User> getAllUsers()throws NavDaoException;

	public void update(User user)throws NavDaoException;
	
	public User getUserByEmail(String email)throws NavDaoException;

	public void save(User user)throws NavDaoException;

	public Boolean login(User user)throws NavDaoException;
}
