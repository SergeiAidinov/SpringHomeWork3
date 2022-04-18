package ru.yandex.incoming34.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.incoming34.entities.product.AbstractProduct;
import ru.yandex.incoming34.entities.product.ProductFull;
import ru.yandex.incoming34.repo.ProductsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ProductDao {
	
	ProductsRepo productsRepo;
	
	@Autowired
	public ProductDao(ProductsRepo productsRepo) {
		this.productsRepo = productsRepo;
	}

	public List<ProductFull> getProducts() {
		Iterable<ProductFull> iterable = productsRepo.findAllFullProducts();
		List<ProductFull> products = new ArrayList<ProductFull>();
				iterable.forEach(p -> products.add(p));
		return products;
	}

	public void putProduct(ProductFull productFull) {
		if (productsRepo.countById(productFull.getId()) == 0) {
			productsRepo.save(productFull);
		} else {
			productsRepo.deleteById(productFull.getId());
			productsRepo.save(productFull);
		}

	}

	public Optional<AbstractProduct> getProduct(Long id)  {
		return productsRepo.findById(id);

	}

	public void removeProductById(Long id) {
		productsRepo.deleteById(id);
		
	}

	public void countById(Long id) {
		productsRepo.countById(id);
		
	}

}
