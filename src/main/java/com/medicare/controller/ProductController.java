package com.medicare.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.medicare.model.Product;
import com.medicare.repository.ProductRepository;
import com.medicare.repository.UserRepository;

@Controller
public class ProductController {

	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value = "/viewproduct")
	public String viewAllProduct(Model map) {
		List<Product> listprod = prodRepo.findByState();
		map.addAttribute("listprod", listprod);
		return "viewproduct";
	}
	
	@RequestMapping(value = "/usersearch" , method = RequestMethod.POST)
	public String searchProduct(Model map, @RequestParam String search) {
		List<Product> listprod = prodRepo.findByProdName(search);
		map.addAttribute("listprod", listprod);
		return "viewproduct";
	}
	
	@RequestMapping(value = "/userAntipyretics")
	public String findByAntipyretics(Model map) {
		List<Product> listprod = prodRepo.findByAntipyretics();
		map.addAttribute("listprod", listprod);
		return "viewproduct";
	}
	
	@RequestMapping(value = "/userAnalgesics")
	public String findByAnalgesics(Model map) {
		List<Product> listprod = prodRepo.findByAnalgesics();
		map.addAttribute("listprod", listprod);
		return "viewproduct";
	}
	
	@RequestMapping(value = "/userAntibiotics")
	public String findByAntibiotics(Model map) {
		List<Product> listprod = prodRepo.findByAntibiotics();
		map.addAttribute("listprod", listprod);
		return "viewproduct";
	}
	
	@RequestMapping(value = "/userdashboard")
	public String userdash() {		
		return "userdashboard";
	}
	
	
	
}
