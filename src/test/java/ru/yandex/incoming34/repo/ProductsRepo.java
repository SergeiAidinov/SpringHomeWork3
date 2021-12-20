package ru.yandex.incoming34.repo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
@PropertySource("classpath:SpringHomeWork3.properties")
@Repository
public class ProductsRepo {
	@Value("${data}")
	private int data;
	
	
}
