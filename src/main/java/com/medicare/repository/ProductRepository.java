package com.medicare.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.medicare.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.name LIKE :search% AND p.state='yes' ")
	List<Product> findByProdName(String search);
	
	@Query("SELECT p FROM Product p WHERE p.category='Antipyretics'")
	List<Product> findByAntipyretics();
	
	@Query("SELECT p FROM Product p WHERE p.category='Analgesics'")
	List<Product> findByAnalgesics();
	
	@Query("SELECT p FROM Product p WHERE p.category='Antibiotics'")
	List<Product> findByAntibiotics();
	
	@Query("SELECT p FROM Product p WHERE p.state='yes'")
	List<Product> findByState();
	
	@Query("SELECT p FROM Product p WHERE p.id=?1")
	Product findById(int id);
	
	@Modifying
	@Query("update Product p set p.name=?2, p.description=?3, p.price=?4, p.quantity=?5 where p.id=?1")
	@Transactional
	void updateProduct(int id1, String mname, String description, int price1, int quantity1);
	
	@Modifying
	@Query("update Product p set p.state=?2 where p.id=?1")
	@Transactional
	void updateStatus(int id, String state);
	
}
