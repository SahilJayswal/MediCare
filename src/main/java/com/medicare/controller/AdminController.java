package com.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.medicare.model.Product;
import com.medicare.repository.ProductRepository;

@Controller
public class AdminController {

	@RequestMapping(value = "/admindashboard")
	public String admindash() {
		return "admindashboard";
	}
	
	@Autowired
	ProductRepository prodRepo;
	

	@RequestMapping(value = "/manageproduct")
	public String manageproduct(Model map) {
		List<Product> listprod = prodRepo.findAll();
		map.addAttribute("listprod", listprod);
		return "manageproduct";
	}
	
	@RequestMapping(value = "/managesearch" , method = RequestMethod.POST)
	public String searchProductManage(Model map, @RequestParam String search) {
		List<Product> listprod = prodRepo.findByProdName(search);
		map.addAttribute("listprod", listprod);
		return "manageproduct";
	}
	
	@RequestMapping(value = "/Antipyretics")
	public String findByAntipyretics(Model map) {
		List<Product> listprod = prodRepo.findByAntipyretics();
		map.addAttribute("listprod", listprod);
		return "manageproduct";
	}
	
	@RequestMapping(value = "/Analgesics")
	public String findByAnalgesics(Model map) {
		List<Product> listprod = prodRepo.findByAnalgesics();
		map.addAttribute("listprod", listprod);
		return "manageproduct";
	}
	
	@RequestMapping(value = "/Antibiotics")
	public String findByAntibiotics(Model map) {
		List<Product> listprod = prodRepo.findByAntibiotics();
		map.addAttribute("listprod", listprod);
		return "manageproduct";
	}
	
	@RequestMapping(value = "/addproduct")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		return "addproduct";
	}
	
	@PostMapping("/addmedicine")
	public String addMedicine(Product product) {
		prodRepo.save(product);
		return "operationsuccess";
	}
	
	@PostMapping("/delete")
	public String Delete(@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		prodRepo.deleteById(id1);
		return "redirect:/medicareapp/manageproduct";
	}
	
	@PostMapping("/editproduct")
	public String editProduct(Model map, @RequestParam String id) {
		int id1 = Integer.parseInt(id);
		Product listprod = prodRepo.findById(id1);
		map.addAttribute("listprod", listprod);
		return "edit";
	}
	
	@PostMapping("/edit")
	public String UpdateMedicine(Model map, @RequestParam String id, @RequestParam String mname, 
			@RequestParam String description, @RequestParam String price,@RequestParam String quantity) {
		int id1 = Integer.parseInt(id);
		int price1 = Integer.parseInt(price);
		int quantity1 = Integer.parseInt(quantity);
		prodRepo.updateProduct(id1,mname,description,price1,quantity1);
		return "operationsuccess";
		
	}
	
	@PostMapping("/updatestatus")
	public String updateStatus(@RequestParam String activeId, @RequestParam String active) {
		int id = Integer.parseInt(activeId);
		prodRepo.updateStatus(id, active);
		return "redirect:/medicareapp/manageproduct";
	}
}
