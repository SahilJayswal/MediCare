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

import com.medicare.repository.ProductRepository;
import com.medicare.repository.PurchaseRepository;
import com.medicare.service.ProductService;
import com.medicare.model.Product;
import com.medicare.model.Purchase;


@Controller
public class PurchaseController {

	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	PurchaseRepository purcRepo;
	
	@Autowired
	ProductService service;
	
	@PostMapping("/addcart")
	public String addToCart(Model map, @RequestParam String id) {
		int id1 = Integer.parseInt(id);
		
		Product listprod = prodRepo.findById(id1);
		
		int productid = listprod.getId();
		String name = listprod.getName();
		String description = listprod.getDescription();
		int price = listprod.getPrice();
		String brand = listprod.getBrand();
			  
		
		boolean isAvailable = service.isAlreadyAvailable(id1);
		if(!isAvailable) {
			Purchase p = new Purchase(); 
			p.setId(productid); 
			p.setName(name);
			p.setBrand(brand); 
			p.setDescription(description);
			p.setSubtotal(price);
			p.setPrice(price);
			p.setQuantity(1); 
			purcRepo.save(p);
		}
		 
		return "redirect:/viewproduct";
	}
	
	@RequestMapping(value = "/cart")
	public String viewAllProduct(Model map, ModelMap model) {
		List<Purchase> listprod = purcRepo.findAll();
		map.addAttribute("listprod", listprod);
		int price = service.Total();
		model.put("price", price);
		return "cart";
	}
	
	@RequestMapping(value = "/checkout")
	public String Checkout(ModelMap model) {
		int price = service.Total();
		
		if(price==0) {
			model.put("errorMessage", "Your cart is empty... Please add medicine");
			model.put("price", price);
			return "cart";
		}
		return "checkout";
	}
	@RequestMapping(value = "/ordersummary")
	public String ordersummary(Model map, ModelMap model) {
		List<Purchase> listprod = purcRepo.findAll();
		map.addAttribute("listprod", listprod);
		int price = service.Total();
		model.put("price", price);
		return "order";
	}
	
	@RequestMapping(value = "/thankyou")
	public String ThankYou() {
		purcRepo.deleteAll();
		return "thankyou";
	}

	@PostMapping("/remove")
	public String Delete(@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		purcRepo.deleteById(id1);
		return "redirect:/cart";
	}
	
	@RequestMapping(value = "/increase", method = RequestMethod.POST)
	public String Increase(@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		List<Purchase> PurchaseId = purcRepo.findAll();
		for(Purchase p1 : PurchaseId){
			if(id1==p1.getPid()) {
				int quant = p1.getQuantity();
				int subtotal = p1.getPrice();
				quant+=1; 
				int subtotal1=quant*subtotal;
				purcRepo.updateProd(id1, quant, subtotal1);
			}
		}
		return "redirect:/cart";
	}
	
	@RequestMapping(value = "/decrease", method = RequestMethod.POST)
	public String Decrease(@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		List<Purchase> PurchaseId = purcRepo.findAll();
		for(Purchase p1 : PurchaseId){
			if(id1==p1.getPid()) {
				if(p1.getQuantity()==1) {
					purcRepo.deleteById(id1);
				}else {
					int quant = p1.getQuantity();
					int price = p1.getPrice();
					int subtotal = p1.getSubtotal();
					quant-=1; 
					int subtotal1=subtotal-price;
					purcRepo.updateProd(id1, quant, subtotal1);

				}
			}
		}
		return "redirect:/cart";
	}
}
