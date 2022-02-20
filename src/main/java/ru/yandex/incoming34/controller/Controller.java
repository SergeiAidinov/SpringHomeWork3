package ru.yandex.incoming34.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import ru.yandex.incoming34.Dao.ProductDao;
import ru.yandex.incoming34.models.Product;

@Api
@RestController
@RequestMapping("/main")
public class Controller {
	
	ObjectMapper objectMapper = new ObjectMapper();
	ProductDao productDao;

	@Autowired
	public Controller(ProductDao service) {
		this.productDao = service;
	}

	@RequestMapping(path = "/all_products", method = RequestMethod.GET)
	public List<Product> showProducts() {
				return  productDao.getProducts();
	}
	
	@RequestMapping(path = "/delete_products", method = RequestMethod.GET)
	public void deleteProduct(@RequestParam Long id) {
				productDao.removeProductById(id);
	}

	@RequestMapping(path = "/new_product", method = RequestMethod.PUT)
	public HttpStatus putProduct(@RequestBody Product product) {
		productDao.countById(product.getId());
		
		productDao.putProduct(product);
		return HttpStatus.OK;
	}
	
	@RequestMapping(path = "/product_by_id", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@RequestParam Long id) {
		Optional<Product> optionalProduct = productDao.getProduct(id);
		if (optionalProduct.isPresent()) {
			return new ResponseEntity<Product>(optionalProduct.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}

}
