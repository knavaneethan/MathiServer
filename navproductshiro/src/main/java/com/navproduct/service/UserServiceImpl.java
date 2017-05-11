package com.navproduct.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navproduct.dao.UserDao;
import com.navproduct.exception.NavDaoException;
import com.navproduct.exception.NavServiceException;
import com.navproduct.model.MyCustomRealm;
import com.navproduct.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
    private UserDao userDao;
		
	@Resource
	MyCustomRealm realm;
	
	@Override
	public List<User> getAllUsers() throws NavServiceException {
		try {
			return userDao.getAllUsers();
		} catch (NavDaoException e) {
			throw NavServiceException.Builder.create(e).build();
		}
	}

	@Override
	public void update(User user) throws NavServiceException {
		try {
			userDao.update(user);
		} catch (NavDaoException e) {
			throw NavServiceException.Builder.create(e).build();
		}
	}

	@Override
	public void Save(User user) throws NavServiceException {
		try {
			userDao.save(user);
		} catch (NavDaoException e) {
			throw NavServiceException.Builder.create(e).build();
		}
	}
	
		
		
		
}
