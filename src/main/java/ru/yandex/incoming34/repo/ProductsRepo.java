package ru.yandex.incoming34.repo;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.yandex.incoming34.models.Product;
@PropertySource("classpath:SpringHomeWork3.properties")
@Repository
public interface ProductsRepo extends CrudRepository<Product, Long>{

	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM product WHERE id = ?1")
	Long countById(Long id);
	
	
}
