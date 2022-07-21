package com.wipro.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "product")
public class Product {
	
	@Id
	private String id;
	
	private String name,brand;
	private String category,madein;
	private double price;
	private String imgpath;
	
	public void setPrice(Object price2) {
		// TODO Auto-generated method stub
		
	}
	public void setMadein(Object madein2) {
		// TODO Auto-generated method stub
		
	}
	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}
	
	public Product() {
		
	}

	public Product(String name, String brand, String category, double price, String imgpath, String madein) {
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.imgpath = imgpath;
		this.madein = madein;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	} 

}
