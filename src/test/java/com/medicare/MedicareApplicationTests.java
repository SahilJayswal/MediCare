package com.medicare;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.medicare.model.User;
import com.medicare.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class MedicareApplicationTests {

	@Autowired
	private UserRepository userRepo;
	
	@Test
	void UserCreateTest() {
		
		  User user = new User(); 
		  user.setEmail("abc@gmail.com");
		  user.setFirstName("Test"); 
		  user.setLastName("User");
		  user.setPassword("1234"); 
		  user.setRole("customer");
		  User savedUser = userRepo.save(user);
		  
		  assertThat(savedUser.getEmail()).isEqualTo("abc@gmail.com");
		  
	}
	
	@Test
	void testFindByEmail() {
		String email = "sahil@gmail.com";
		
		User user = userRepo.findByEmailId(email);
				
		assertThat(user).isNotNull();
	}
	

}
