package com.medicare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.medicare.model.Product;
import com.medicare.model.User;
import com.medicare.repository.UserRepository;
import com.medicare.service.ProductService;

@SpringBootApplication
public class MedicareApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MedicareApplication.class, args);
	}

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProductService prod;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User(); 
		 user.setEmail("sahil@gmail.com");
		  user.setFirstName("Sahil"); 
		  user.setLastName("Jayswal");
		  user.setPassword("1234"); 
		  user.setRole("customer");
		  userRepo.save(user);
		
		 prod.insertProduct(new Product(2, "Paracetamol", "Generic name: acetaminophen systemic", "Antipyretics", 3, 90, "Cipla", "yes"));
		 prod.insertProduct(new Product(3, "Acetaminophen", "Generic name: acetaminophen systemic", "Antipyretics", 12, 30, "Cipla","no"));
		 prod.insertProduct(new Product(4, "Tramadol", "Generic name: tramadol systemic", "Analgesics", 3, 45, "Cipla","yes"));
		 prod.insertProduct(new Product(5, "Oxycodone", "Generic name: oxycodone systemic", "Analgesics", 9, 50, "Cipla","yes"));
		 prod.insertProduct(new Product(6, "Amoxicillin", "Generic name: amoxicillin (am OX i sil in)", "Antibiotics", 15, 30, "Cipla","yes"));
		 prod.insertProduct(new Product(7, "Cephalexin", "Generic name: cephalexin (sef a LEX in)", "Antibiotics", 18, 50, "Cipla","yes"));
	
	}

}
