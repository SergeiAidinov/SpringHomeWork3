package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.dto.ProductDto;
import ru.yandex.incoming34.repo.ProductsRepo;

import java.util.ArrayList;
import java.util.List;

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


    public <ProductFull> List<ProductFull> showAllProductsWithCategories() {
		return (List<ProductFull>) productRepo.findAllProductsWithCategories();

    }
}
