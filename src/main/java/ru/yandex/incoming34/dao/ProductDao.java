package ru.yandex.incoming34.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ru.yandex.incoming34.entities.Product;
import ru.yandex.incoming34.repo.ProductsRepo;

@org.springframework.stereotype.Service
public class ProductDao {
	
	ProductsRepo productsRepo;
	
	@Autowired
	public ProductDao(ProductsRepo productsRepo) {
		this.productsRepo = productsRepo;
	}

	public List<Product> getProducts() {
		Iterable<Product> iterable = productsRepo.findAllProducts();
		List<Product> products = new ArrayList<Product>();
				iterable.forEach(p -> products.add(p));
		return products;
	}

	public void putProduct(Product product) {
		if (productsRepo.countById(product.getId()) == 0) {
			productsRepo.save(product);
		} else {
			productsRepo.deleteById(product.getId());
			productsRepo.save(product);
		}

	}

	public Optional<Product> getProduct(Long id)  {
		return null;
				//productsRepo.findById(id);

	}

	public void removeProductById(Long id) {
		productsRepo.deleteById(id);
		
	}

	public void countById(Long id) {
		productsRepo.countById(id);
		
	}

}
