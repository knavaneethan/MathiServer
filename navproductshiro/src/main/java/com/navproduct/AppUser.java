package com.navproduct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.navproduct.configuration.AppConfig;
import com.navproduct.exception.NavServiceException;
import com.navproduct.model.User;
import com.navproduct.service.UserService;

public class AppUser {

	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService service = (UserService) context.getBean("userService");

		User user = new User();
		user.setId(1);
//		user.setCompany(1);
//		user.setDisplayName("Navnith2");
		user.setEmail("test4@nasf.com");
		user.setPassword("asf");
		
		try {
			service.update(user);
		} catch (NavServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.close();
	}
}
