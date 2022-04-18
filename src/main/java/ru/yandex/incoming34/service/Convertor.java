package ru.yandex.incoming34.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.entities.product.ProductBrief;

@Component
public class Convertor {
	private final ModelMapper modelMapper = new ModelMapper();

	public ProductBriefDto convertProductBriefToDto(ProductBrief product) {

		return modelMapper.map(product, ProductBriefDto.class);
	}
	
}
