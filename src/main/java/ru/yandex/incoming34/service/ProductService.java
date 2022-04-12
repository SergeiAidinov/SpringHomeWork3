package ru.yandex.incoming34.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.yandex.incoming34.dao.ProductDao;
import ru.yandex.incoming34.dto.ProductDto;
import ru.yandex.incoming34.entities.Product;
import ru.yandex.incoming34.repo.ProductsRepo;

@Service
public class ProductService {
	
	private final ProductsRepo productRepo;
	private final Convertor convertor;
	//private final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	public ProductService(ProductsRepo productRepo, Convertor convertor) {
		this.productRepo = productRepo;
		this.convertor = convertor;
		
	}

	public List<ProductDto> showAllProducts(){
		//return (productRepo.findAllProducts());
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		productRepo.findAllProducts().stream().forEach
				(p -> {
					
					ProductDto productDto = convertor.convertToDto(p);
					productDtos.add(productDto);
				}
				);
				//.collect(Collectors.toList())
				;
		
		return productDtos;
		
	}
	

}
