package ru.yandex.incoming34.repo;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.entities.product.AbstractProduct;
import ru.yandex.incoming34.entities.product.ProductFull;
import ru.yandex.incoming34.entities.product.ProductBrief;

import java.util.List;
import java.util.Optional;

@PropertySource("classpath:SpringHomeWork3.properties")
@Repository
public interface ProductsRepo extends CrudRepository<AbstractProduct, Long>{
String queryForProductById = "SELECT product_id, product_name, price FROM product WHERE product_id = ?1";
String queryForAllProduct = "SELECT product_id, product_name, price FROM product";

	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM product WHERE product_id = ?1")
	Long countById(Long id);
	
	@Query(nativeQuery = true, value = queryForAllProduct)
	List<ProductFull> findAllFullProducts();

	@Query(nativeQuery = true, value = queryForAllProduct)
	List<ProductBrief> findAllBriefProducts();

	@Query(nativeQuery = true, value = queryForAllProduct)
	List<ProductFull> findAllProductsWithCategories();

	@Query(nativeQuery = true, value = queryForProductById)
	Optional<ProductFull> findProductFullById(Long id);

	@Query(nativeQuery = true, value = queryForProductById)
	Optional<ProductBrief> findProductBriefById(Long id);
}
