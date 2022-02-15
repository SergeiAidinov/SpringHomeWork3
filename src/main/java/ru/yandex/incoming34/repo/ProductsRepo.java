package ru.yandex.incoming34.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.yandex.incoming34.models.Product;
@PropertySource("classpath:SpringHomeWork3.properties")
@Repository
public interface ProductsRepo extends CrudRepository<Product, Long>{
	
	
}
