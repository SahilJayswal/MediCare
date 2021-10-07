package com.medicare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="purchase")
public class Purchase {
	
	@Id
	@GeneratedValue	
	@Column(name="pid")
	private int pid;
	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	@Column(name="subtotal")
	private int subtotal;
	
	@Column(name="quantity")
	private int quantity;
	
	public Purchase() {
		
	}
	
	public Purchase(int id, String name, String brand, String description, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public Purchase(int pid, int id, String name, String brand, String description, int price, int quantity) {
		super();
		this.pid = pid;
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	

	public Purchase(int pid, int id, String name, String brand, String description, int price, int subtotal,
			int quantity) {
		super();
		this.pid = pid;
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.subtotal = subtotal;
		this.quantity = quantity;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "Purchase [pid=" + pid + ", id=" + id + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", price=" + price + ", subtotal=" + subtotal + ", quantity=" + quantity + "]";
	}

	
	
}
