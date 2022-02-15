package ru.yandex.incoming34.models;

import javax.persistence.CascadeType;

import ru.yandex.incoming34.dto.ProductDto;
import ru.yandex.incoming34.models.Category;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	Long id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "price")
	int price;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category", referencedColumnName = "id")
	//@Column(name = "product_category")
	Category category;
	
	public Product(ProductDto productDto) {
		name = productDto.getName();
		price = productDto.getPrice();
		category = productDto.getCategory();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Category getProductCategory() {
		return category;
	}

	public void setProductCategory(Category category) {
		this.category = category;
	}

	

}
