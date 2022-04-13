package ru.yandex.incoming34.repo;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.yandex.incoming34.entities.AbstractProduct;
import ru.yandex.incoming34.entities.Product;
@PropertySource("classpath:SpringHomeWork3.properties")
@Repository
public interface ProductsRepo extends CrudRepository<AbstractProduct, Long>{

	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM product WHERE id = ?1")
	Long countById(Long id);
	
	@Query(nativeQuery = true, value = "SELECT product_id, product_name, price FROM product")
	List<Product> findAllProducts();
	
	
}
