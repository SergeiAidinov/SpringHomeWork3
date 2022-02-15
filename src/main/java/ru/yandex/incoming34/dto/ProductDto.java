package ru.yandex.incoming34.dto;

import ru.yandex.incoming34.models.Category;

public class ProductDto {
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	String name;
	
	int price;
	
	Category category;
}
