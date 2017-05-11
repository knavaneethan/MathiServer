package com.navproduct.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.navproduct.exception.NavServiceException;
import com.navproduct.model.User;
import com.navproduct.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;

    @RequestMapping(method = RequestMethod.GET)    
    public List<User> getAllUsers() {
    	List<User> list = null;
		try {
			list = userService.getAllUsers();
		} catch (NavServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
    
    @RequestMapping(method = RequestMethod.POST)
	boolean updateUser(@RequestBody User user) {
    	boolean success = false;
		try {
			 userService.update(user);
			 success = true;
		} catch (NavServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;

	}
}
