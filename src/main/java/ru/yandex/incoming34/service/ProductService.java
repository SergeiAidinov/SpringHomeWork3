package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.dto.ProductFullDto;
import ru.yandex.incoming34.entities.product.ProductFull;
import ru.yandex.incoming34.repo.ProductsRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductsRepo productRepo;
    private final Convertor convertor;

    @Autowired
    public ProductService(ProductsRepo productRepo, Convertor convertor) {
        this.productRepo = productRepo;
        this.convertor = convertor;

    }

    public List<ProductBriefDto> showAllBriefProducts() {
        return productRepo.findAllBriefProducts().stream()
                .map(productBrief -> convertor.convertProductBriefToDto(productBrief))
                .collect(Collectors.toList());

    }

    public List<ProductFullDto> showAllProductsWithCategories() {
        List<ProductFull> productFullList = productRepo.findAllFullProducts();

        return

                productFullList.stream()
                .map(productFull -> convertor.convertProductFullToDto(productFull))
                .collect(Collectors.toList());
    }

    public Optional<ProductFullDto> getProductFullById(Long id) {
        //Optional<ProductFull> optionalProductFull = productRepo.findProductFullById(id);
        return productRepo.findProductFullById(id).map(convertor::convertProductFullToDto);
    }
}
