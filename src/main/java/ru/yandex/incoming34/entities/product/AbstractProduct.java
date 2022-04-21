package ru.yandex.incoming34.entities.product;

import javax.persistence.*;

@Entity
@Table(name = "product")
public abstract class AbstractProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
