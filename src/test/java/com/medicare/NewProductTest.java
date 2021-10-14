package com.medicare;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.medicare.model.Product;
import com.medicare.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewProductTest {
	
	@Autowired
	ProductRepository pRepo;
	
	
	@Test
	void createProductTest() {
		Product p = new Product();
		p.setName("Crocine");
		p.setDescription("For Fever");
		p.setCategory("Antibiotics");
		p.setBrand("cipla");
		p.setPrice(3);
		p.setQuantity(30);
		p.setState("yes");
		Product savedprod = pRepo.save(p);
		
		assertThat(savedprod.getName()).isEqualTo("Crocine");
		assertThat(savedprod).isNotNull();
	}

}
