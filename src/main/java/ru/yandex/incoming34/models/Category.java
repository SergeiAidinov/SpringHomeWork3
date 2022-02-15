package ru.yandex.incoming34.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@Column(name = "id")
	Long id;
	
	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	@Column (name ="description")
	String description;
	
}
