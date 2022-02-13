package ru.yandex.incoming34.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ru.yandex.incoming34.models.Product;
import ru.yandex.incoming34.service.Service;

@Api
@RestController
@RequestMapping("/main")
public class Controller {
	ObjectMapper objectMapper = new ObjectMapper();
	Service service;

	@Autowired
	public Controller(Service service) {
		this.service = service;
	}

	@RequestMapping(path = "/show", method = RequestMethod.GET)
	public ResponseEntity<JsonNode> showProducts() {
		JsonNode jsonNode = objectMapper.createObjectNode();
		
		try {
			jsonNode = service.getProducts();
		} catch (JsonProcessingException jsonProcessingException) {
			return new ResponseEntity<JsonNode>(jsonNode, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JsonNode>(jsonNode, HttpStatus.OK);
	}

	@RequestMapping(path = "/addProduct", method = RequestMethod.PUT)
	public HttpStatus putProduct(@RequestBody Product product) {
		service.putProduct(product);
		return HttpStatus.OK;
	}
	
	@RequestMapping(path = "/getProductById", method = RequestMethod.GET)
	public ResponseEntity<JsonNode> getProduct(@RequestParam UUID id) {
		JsonNode jsonNode = objectMapper.createObjectNode();
		try {
			jsonNode = service.getProduct(id);
		} catch (JsonProcessingException jsonProcessingException) {
			return new ResponseEntity<JsonNode>(jsonNode, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<JsonNode>(jsonNode, HttpStatus.OK);
	}
	

}
