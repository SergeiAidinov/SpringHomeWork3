package ru.yandex.incoming34.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import ru.yandex.incoming34.dto.ProductDto;
import ru.yandex.incoming34.entities.Product;

@Component
public class Convertor {
	private final ModelMapper modelMapper = new ModelMapper();

	public ProductDto convertToDto(Product product) {

		return modelMapper.map(product, ProductDto.class);
	}
	
}
