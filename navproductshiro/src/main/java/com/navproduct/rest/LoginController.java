package com.navproduct.rest;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.navproduct.exception.NavServiceException;
import com.navproduct.model.User;
import com.navproduct.service.UserService;
import com.navproduct.utils.SessionUtil;

@RestController
@RequestMapping("/logging")
public class LoginController {

	@Resource
	private UserService userService;
	
	@Resource
	private SessionUtil sessionUtil;
	
    private static final String template = "Hello, %s!";

    @RequestMapping(method = RequestMethod.GET)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
                            return String.format(template, name+" logging");
    }
    
    @PostMapping
    @RequestMapping("/login")
	Boolean login(@RequestBody User user) {
    	try {
			return sessionUtil.login(user);
		} catch (NavServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
	@PostMapping
	@RequestMapping("/register")
	public void register(@RequestBody Map<String,String> payload) {
		User user = new User();
		user.setUsername(payload.get("email"));
		user.setEmail(payload.get("email"));
		
		generatePassword(user, payload.get("password"));
		
		try {
			userService.Save(user);
		} catch (NavServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("User with email:" + user.getEmail() + " hashedPassword:"+ user.getPassword() + " salt:" + user.getSalt());
	}
    	
		private void generatePassword(User user, String plainTextPassword) {
		  RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		  Object salt = rng.nextBytes();
	
		  // Now hash the plain-text password with the random salt and multiple
		  // iterations and then Base64-encode the value (requires less space than Hex):
		  String hashedPasswordBase64 = new Sha256Hash(plainTextPassword, salt,1024).toBase64();
		
		  user.setPassword(hashedPasswordBase64);
		  user.setSalt(salt.toString());
		}
    	
    	@PostMapping
        @RequestMapping("/logout")
    	Boolean logout() {
    			return sessionUtil.logout();
        }
}
