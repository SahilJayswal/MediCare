package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.medicare.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

	@Modifying
	@Query("update Purchase p set p.quantity=?2, p.subtotal=?3 where p.id=?1")
	@Transactional
	void updateProduct(int id, int quantity, int subtotal);
	
	@Modifying
	@Query("update Purchase p set p.quantity=?2, p.subtotal=?3 where p.pid=?1")
	@Transactional
	void updateProd(int id, int quantity, int subtotal);
	
	@Modifying
	@Transactional
	public void deleteAll();
	
}
