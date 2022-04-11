package ru.yandex.incoming34.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.yandex.incoming34.dao.ProductDao;
import ru.yandex.incoming34.dto.ProductDto;

@Service
public class ProductService {
	
	private final ProductDao productDao;
	private final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	public ProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<ProductDto> showAllProducts(){
		
		return productDao.getProducts().stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
		
	}
	

}
