package com.medicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.model.Product;
import com.medicare.model.Purchase;
import com.medicare.repository.ProductRepository;
import com.medicare.repository.PurchaseRepository;


@Service
public class ProductService {

	
	@Autowired
	PurchaseRepository purcRepo;
	
	
	  @Autowired ProductRepository prodRepo;
	  
	  public void insertProduct(Product product) { prodRepo.save(product); }
	 
	
	public boolean isAlreadyAvailable(int id) {
		List<Purchase> PurchaseId = purcRepo.findAll();
		for(Purchase p1 : PurchaseId){
			if(id==p1.getId()) {
				int quant = p1.getQuantity();
				int subtotal = p1.getPrice();
				quant+=1; 
				int subtotal1=quant*subtotal;
				purcRepo.updateProduct(id, quant, subtotal1);
				  return true;
				 }
	}
		return false;
}
	public int Total() {
		List<Purchase> list= purcRepo.findAll();
		int price = 0;
		for(Purchase p : list) {
			int price1 = p.getSubtotal();
			price=price+price1;
		}
		return price;
	}
	
}
