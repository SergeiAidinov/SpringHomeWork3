package ru.yandex.incoming34.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends AbstractProduct {
	
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "price")
	private Integer price;
	
	public Product() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
