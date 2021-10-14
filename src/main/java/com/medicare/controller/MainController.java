package com.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.medicare.model.User;
import com.medicare.repository.UserRepository;
import com.medicare.service.LoginService;

@Controller
public class MainController {

	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/index")
	public String home() {
		return "index";
	}
	@RequestMapping(value = "/medicareapp/about")
	public String about() {
		return "about";
	}
	@RequestMapping(value = "/contact")
	public String contact() {
		return "contact";
	}
	@RequestMapping(value = "/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}
	
	@Autowired
	LoginService service;
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping(value = "/auth" , method = RequestMethod.POST)
	public String login(ModelMap model,Model map, @RequestParam String email, @RequestParam String password ) {
		boolean isvalidAdmin = service.validateAdmin(email, password);
		boolean isvalidUser = service.validateUser(email, password);
		if(isvalidAdmin) {
			model.put("email", email);
			model.put("password", password);
			return "admindashboard";
		}else if(isvalidUser){
			List<User> allUser = repo.findAll();
			for (User valUser : allUser) {
				if(email.equalsIgnoreCase(valUser.getEmail())) {
					map.addAttribute("firstname", valUser.getFirstName());
					map.addAttribute("lastname", valUser.getLastName());
					map.addAttribute("id", valUser.getId());
				}
			}
			return "userdashboard";
		}
		model.put("errorMessage", "Invalid Credential");
		return "login";
		
		
		
	}
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/register")
	public String Registration(User user) {
		user.setRole("customer");
		userRepo.save(user);
		return "registerSuccess";
	}
	
	
}

