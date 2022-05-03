package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.dao.CategoryDao;
import ru.yandex.incoming34.dao.ProductDao;
import ru.yandex.incoming34.dto.NewProductDto;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.dto.ProductFullDto;
import ru.yandex.incoming34.entities.category.CategoryBrief;
import ru.yandex.incoming34.entities.product.ProductFull;
import ru.yandex.incoming34.repo.ProductBriefRepo;
import ru.yandex.incoming34.repo.ProductFullRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductBriefRepo productBriefRepo;
    private final ProductFullRepo productFullRepo;
    private final Convertor convertor;

    @Autowired
    public ProductService(ProductBriefRepo productBriefRepo, ProductFullRepo productFullRepo, Convertor convertor) {
        this.productBriefRepo = productBriefRepo;
        this.productFullRepo = productFullRepo;
        this.convertor = convertor;

    }

    public List<ProductBriefDto> showAllBriefProducts() {
        return productBriefRepo.findAllBriefProducts()
                .stream()
                .map(productBrief -> convertor.convertProductBriefToDto(productBrief))
                .collect(Collectors.toList());
    }

    public List<ProductFullDto> showAllProductsWithCategories() {
        return productFullRepo.findAllFullProducts()
                .stream().map(productFull -> convertor.convertProductFullToDto(productFull))
                .collect(Collectors.toList());
    }

    public Optional<ProductFullDto> getProductFullById(Long id) {
        return productFullRepo.findProductFullById(id).map(convertor::convertProductFullToDto);
    }

    public void putProduct(NewProductDto newProductDto) {
        productFullRepo.save(convertor.convertNewProductToProductFull(newProductDto));
    }

    public void removeProductById(Long id) {
        productFullRepo.deleteById(id);
    }
}
