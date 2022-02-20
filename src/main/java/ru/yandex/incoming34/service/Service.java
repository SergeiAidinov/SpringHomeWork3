package ru.yandex.incoming34.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ru.yandex.incoming34.dto.ProductDto;
import ru.yandex.incoming34.models.Product;
import ru.yandex.incoming34.repo.ProductsRepo;

@org.springframework.stereotype.Service
public class Service {
	
	ProductsRepo productsRepo;
	
	
	@Autowired
	public Service(ProductsRepo productsRepo) {
		this.productsRepo = productsRepo;
	}

	ObjectMapper objectMapper = new ObjectMapper();
	Map<UUID, Product> products = new HashMap<UUID, Product>();
	Gson gson = new Gson();

	public List<Product> getProducts() {
		Iterable<Product> iterable = productsRepo.findAll();
		List<Product> products = new ArrayList<Product>();
				iterable.forEach(p -> products.add(p));
		return products;
	}

	public void putProduct(Product product) {
		productsRepo.save(product);

	}

	public Optional<Product> getProduct(Long id)  {
		return productsRepo.findById(id);

	}

}
