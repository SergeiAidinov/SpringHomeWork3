package ru.yandex.incoming34.models;

import javax.persistence.CascadeType;

import ru.yandex.incoming34.dto.ProductDto;
import ru.yandex.incoming34.models.Category;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "price")
	Integer price;
	
	/*
	@ManyToOne
	@JoinTable(name = "category")
	@JoinColumn(name = "category_id")
	*/
	@Column(name = "category_id")
	int categoryId;

	public Product() {
		
	}
	
	public Product(ProductDto productDto) {
		name = productDto.getName();
		price = productDto.getPrice();
		categoryId = productDto.getCategoryId();
	}
	/*
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
*/
	public void setPrice(Integer price) {
		this.price = price;
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

	
	public int getProductCategoryId() {
		return categoryId;
	}
/*
	public void setProductCategoryId(int category) {
		categoryId = category;
	}
	*/
	

}
