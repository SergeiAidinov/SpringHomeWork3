package ru.yandex.incoming34.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
	
	/*
	@Autowired
	public Service(ProductsRepo productsRepo) {
		this.productsRepo = productsRepo;
	}
	*/

	ObjectMapper objectMapper = new ObjectMapper();
	Map<UUID, Product> products = new HashMap<UUID, Product>();
	Gson gson = new Gson();

	public JsonNode getProducts() throws JsonProcessingException {
		String gString = gson.toJson(products);
		JsonNode jsonNode = objectMapper.readTree(gString);
		return jsonNode;
	}

	public void putProduct(ProductDto productDto) {
		//products.put(UUID.randomUUID(), product);
		Product product = new Product(productDto);
		product.setId(12345L);
		
		//productsRepo.save(product);

	}

	public JsonNode getProduct(UUID id) throws JsonProcessingException {
		Product product = products.get(id);
		if (Objects.nonNull(product)) {
			String gString = gson.toJson(product);
			JsonNode jsonNode = objectMapper.readTree(gString);
			return jsonNode;
		} else {
			return objectMapper.createObjectNode();
		}

	}

}
