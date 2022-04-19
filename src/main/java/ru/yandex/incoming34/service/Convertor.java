package ru.yandex.incoming34.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.yandex.incoming34.dto.NewProductDto;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.dto.ProductFullDto;
import ru.yandex.incoming34.entities.product.ProductBrief;
import ru.yandex.incoming34.entities.product.ProductFull;

import javax.annotation.PostConstruct;

@Component
public class Convertor {
	private final ModelMapper productBriefMapper;
	private final ModelMapper productFullMapper;
	private final ModelMapper newProductMapper;

	public Convertor() {
		productBriefMapper = new ModelMapper();
		productFullMapper = new ModelMapper();
		newProductMapper = new ModelMapper();
	}

	@PostConstruct
	private void initializeMappers(){
		productFullMapper.createTypeMap(ProductFull.class, ProductFullDto.class)
				.addMappings(mapping -> mapping.map(ProductFull::getCategoryBriefList, ProductFullDto::setCategoryBriefList));
/*
		newProductMapper.createTypeMap(ProductFullDto.class, ProductBrief.class)
				.addMappings(mapping -> mapping.map(ProductFullDto::getCategoryBriefList, ProductFull::setCategoryBrifList));

 */
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
}
