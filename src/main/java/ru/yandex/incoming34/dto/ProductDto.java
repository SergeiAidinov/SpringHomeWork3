package ru.yandex.incoming34.dto;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ru.yandex.incoming34.models.Category;

public class ProductDto {
	
	String name;

	int price;
	
	int categoryId;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int category) {
		this.categoryId = category;
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

	/*
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	*/

}
