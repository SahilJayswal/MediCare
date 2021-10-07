package com.medicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.model.User;
import com.medicare.repository.UserRepository;


@Service
public class LoginService {
	public static String password ="1234";

	@Autowired
	UserRepository repo;
	
	
	public boolean validateAdmin(String userid, String pass) {
	return userid.equalsIgnoreCase("admin@gmail.com") && pass.equals(LoginService.password);
	}
	
	public boolean validateUser(String userid, String pass) {
		List<User> allUser = repo.findAll();
	
		for (User valUser : allUser) {
			if(userid.equalsIgnoreCase(valUser.getEmail()) && pass.equals(valUser.getPassword()) ) {
				return true;
			}
		}
		
		return false;
	}
}
