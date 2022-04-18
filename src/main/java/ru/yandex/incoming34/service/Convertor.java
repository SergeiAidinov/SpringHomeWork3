package ru.yandex.incoming34.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.dto.ProductFullDto;
import ru.yandex.incoming34.entities.product.ProductBrief;
import ru.yandex.incoming34.entities.product.ProductFull;

@Component
public class Convertor {
	private final static ModelMapper productBriefMapper = new ModelMapper();
	//private final static ModelMapper productFullMapper = new ModelMapper();

	public ProductBriefDto convertProductBriefToDto(ProductBrief productBrief) {

		return productBriefMapper.map(productBrief, ProductBriefDto.class);
	}

	public ProductFullDto convertProductFullToDto(ProductFull productFull) {
		ModelMapper productFullMapper = new ModelMapper();
		 productFullMapper.createTypeMap(ProductFull.class, ProductFullDto.class)
				.addMappings(mapping -> mapping.map(ProductFull::getCategoryList, ProductFullDto::setCategoryBriefList));
		return productFullMapper.map(productFull, ProductFullDto.class);
	}
	
}
