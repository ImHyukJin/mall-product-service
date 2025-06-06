package com.dmall.productservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
	private Long id;
	private String name;
	private int price;
	private String description;
	
	//기본 생성자 , Getter , Setter
	
	public Product(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	

	public Product() {

	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
