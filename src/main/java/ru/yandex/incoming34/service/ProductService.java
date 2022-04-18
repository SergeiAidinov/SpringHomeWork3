package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.entities.product.ProductFull;
import ru.yandex.incoming34.repo.ProductsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	
	private final ProductsRepo productRepo;
	private final Convertor convertor;

	@Autowired
	public ProductService(ProductsRepo productRepo, Convertor convertor) {
		this.productRepo = productRepo;
		this.convertor = convertor;
		
	}

	public List<ProductBriefDto> showAllProducts(){
		//return (productRepo.findAllProducts());
		List<ProductBriefDto> productBriefDtos = new ArrayList<ProductBriefDto>();
		productRepo.findAllBriefProducts().stream().forEach
				(p -> {
					
					ProductBriefDto productBriefDto = convertor.convertProductBriefToDto(p);
					productBriefDtos.add(productBriefDto);
				}
				);
				//.collect(Collectors.toList())
				;
		
		return productBriefDtos;
		
	}


    public <ProductFull> List<ProductFull> showAllProductsWithCategories() {
		return (List<ProductFull>) productRepo.findAllProductsWithCategories();

    }

	public Optional<ProductFull> getProductFullById(Long id) {

		return productRepo.findProductFullById(id);
	}
}
