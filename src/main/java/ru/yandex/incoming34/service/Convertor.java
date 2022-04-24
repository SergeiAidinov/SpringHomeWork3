package ru.yandex.incoming34.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.yandex.incoming34.components.Cart;
import ru.yandex.incoming34.dto.CartDto;
import ru.yandex.incoming34.dto.NewProductDto;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.dto.ProductFullDto;
import ru.yandex.incoming34.entities.product.ProductBrief;
import ru.yandex.incoming34.entities.product.ProductFull;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Convertor {
	private final ModelMapper productBriefMapper;
	private final ModelMapper productFullMapper;
	private final ModelMapper newProductMapper;
	private final ModelMapper cartMapper;

	public Convertor() {
		productBriefMapper = new ModelMapper();
		productFullMapper = new ModelMapper();
		newProductMapper = new ModelMapper();
		cartMapper = new ModelMapper();
	}

	@PostConstruct
	private void initializeMappers(){
		productFullMapper.createTypeMap(ProductFull.class, ProductFullDto.class)
				.addMappings(mapping -> mapping.map(ProductFull::getCategoryBriefList, ProductFullDto::setCategoryBriefList));

		cartMapper.createTypeMap(Cart.class, CartDto.class)
				.addMappings(mapping -> mapping.map(Cart::getProductBriefQuantityMap, CartDto::setMapProductBriefAndQuantity));


	}

	public ProductBriefDto convertProductBriefToDto(ProductBrief productBrief) {

		return productBriefMapper.map(productBrief, ProductBriefDto.class);
	}

	public ProductFullDto convertProductFullToDto(ProductFull productFull) {

		return productFullMapper.map(productFull, ProductFullDto.class);
	}

	public ProductFull convertNewProductToProductFull(NewProductDto newProductDto) {

		return newProductMapper.map(newProductDto, ProductFull.class);
	}

	public CartDto convertcartToCartDto(Cart cart){
		Map<ProductBriefDto, Integer> productBriefDtoQuantityHashMap = new HashMap<>();
		cart.getProductBriefQuantityMap().forEach((productBrief, quantity) -> {
			ProductBriefDto productBriefDto = convertProductBriefToDto(productBrief);
			productBriefDtoQuantityHashMap.put(productBriefDto, quantity);
		});
		CartDto cartDto = new CartDto();
		cartDto.setMapProductBriefAndQuantity(productBriefDtoQuantityHashMap);
		cartDto.setTotalPrice(cart.getCartTotalPrice());
		return cartDto;
	}
}
