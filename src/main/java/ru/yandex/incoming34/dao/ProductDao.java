package ru.yandex.incoming34.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.incoming34.entities.product.ProductBrief;
import ru.yandex.incoming34.entities.product.ProductFull;
import ru.yandex.incoming34.repo.ProductBriefRepo;
import ru.yandex.incoming34.repo.ProductFullRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ProductDao {
	
	private final ProductFullRepo productFullRepo;
	private final ProductBriefRepo productBriefRepo;
	
	@Autowired
	public ProductDao(ProductFullRepo productFullRepo, ProductBriefRepo productBriefRepo) {
		this.productFullRepo = productFullRepo;
		this.productBriefRepo = productBriefRepo;
	}

	public List<ProductFull> getProducts() {
		Iterable<ProductFull> iterable = productFullRepo.findAllFullProducts();
		List<ProductFull> products = new ArrayList<ProductFull>();
				iterable.forEach(p -> products.add(p));
		return products;
	}

	public void putProduct(ProductFull productFull) {
		if (productFullRepo.countById(productFull.getId()) == 0) {
			productFullRepo.save(productFull);
		} else {
			productFullRepo.deleteById(productFull.getId());
			productFullRepo.save(productFull);
		}

	}

	public void removeProductById(Long id) {
		productFullRepo.deleteById(id);
		
	}

	public void countById(Long id) {
		productFullRepo.countById(id);
		
	}

    public List<ProductBrief> findAllProductBrief() {

		return (List<ProductBrief>) productBriefRepo.findAll();
    }

	public List<ProductFull> findAllProductsFull() {

		return  (List<ProductFull>) productFullRepo.findAll();
	}

	public Optional<ProductFull> findProductFullById(Long id) {

		return productFullRepo.findProductFullById(id);
	}

	public void saveProductFull(ProductFull productFull) {

		productFullRepo.save(productFull);
	}

    public Optional<ProductBrief> getProductBriefById(Integer id) {
		Long longId = new Long(id);
		return productBriefRepo.findById(longId);
    }
}
