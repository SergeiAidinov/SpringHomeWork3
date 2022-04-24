package ru.yandex.incoming34.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.dto.NewProductDto;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.dto.ProductFullDto;
import ru.yandex.incoming34.service.ProductService;

import java.util.List;

@Api
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(path = "/all_brief_products", method = RequestMethod.GET)
	public List<ProductBriefDto> showProducts() {
				return productService.showAllBriefProducts();
	}

	@RequestMapping(path = "/all_products_with_categories", method = RequestMethod.GET)
	public List<ProductFullDto> showProductsWithCategories() {
		return productService.showAllProductsWithCategories();
	}

	@RequestMapping(path = "/delete_product", method = RequestMethod.GET)
	public void deleteProduct(@RequestParam Long id) {

		productService.removeProductById(id);
	}

	@RequestMapping(path = "/new_product", method = RequestMethod.PUT)
	public HttpStatus putProduct(@RequestBody NewProductDto newProductDto) {
		productService.putProduct(newProductDto);
		return HttpStatus.OK;
	}
	
	@RequestMapping(path = "/product_by_id", method = RequestMethod.GET)
	public ResponseEntity<ProductFullDto> getProduct(@RequestParam Long id) {
		return productService.getProductFullById(id)
				.map(productFullDto -> new ResponseEntity<>(productFullDto, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

}
