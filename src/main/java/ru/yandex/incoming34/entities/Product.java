package ru.yandex.incoming34.entities;

import javax.persistence.*;
import java.util.List;

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

	@ManyToMany
	@JoinTable(name = "link_product_category",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


}
