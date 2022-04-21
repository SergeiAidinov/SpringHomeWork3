package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.dto.NewProductDto;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.dto.ProductFullDto;
import ru.yandex.incoming34.entities.category.CategoryBrief;
import ru.yandex.incoming34.entities.product.ProductFull;
import ru.yandex.incoming34.repo.CategoryBriefRepo;
import ru.yandex.incoming34.repo.CategoryRepo;
import ru.yandex.incoming34.repo.ProductBriefRepo;
import ru.yandex.incoming34.repo.ProductsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductsRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final CategoryBriefRepo categoryBriefRepo;
    private final ProductBriefRepo productBriefRepo;
    private final Convertor convertor;

    @Autowired
    public ProductService(ProductsRepo productRepo, Convertor convertor, CategoryRepo categoryRepo, CategoryBriefRepo categoryBriefRepo, ProductBriefRepo productBriefRepo) {
        this.productRepo = productRepo;
        this.convertor = convertor;
        this.categoryRepo = categoryRepo;
        this.categoryBriefRepo = categoryBriefRepo;
        this.productBriefRepo = productBriefRepo;
    }

    public List<ProductBriefDto> showAllBriefProducts() {
        List<ProductBriefDto> productBriefDtoList = new ArrayList<>();
        productBriefRepo.findAll().forEach(productBrief -> {
            ProductBriefDto productBriefDto =
                    convertor.convertProductBriefToDto(productBrief);
            productBriefDtoList.add(productBriefDto);
        });
        return productBriefDtoList;

    }

    public List<ProductFullDto> showAllProductsWithCategories() {
        List<ProductFull> productFullList = productRepo.findAllFullProducts();

        return

                productFullList.stream()
                        .map(productFull -> convertor.convertProductFullToDto(productFull))
                        .collect(Collectors.toList());
    }

    public Optional<ProductFullDto> getProductFullById(Long id) {
        return productRepo.findProductFullById(id).map(convertor::convertProductFullToDto);
    }

    public void putProduct(NewProductDto newProductDto) {
        ProductFull productFull = convertor.convertNewProductToProductFull(newProductDto);
        List<CategoryBrief> categoryBriefList = new ArrayList<>();
        newProductDto.getCategoriesNumberList().stream()
                .forEach(id -> {
                    Optional<CategoryBrief> categoryBriefOptional = categoryBriefRepo.findById(id);
                    if (categoryBriefOptional.isPresent()) {
                        categoryBriefList.add(categoryBriefOptional.get());
                    }
                });

        productFull.setCategoryBriefList(categoryBriefList);
        //productRepo.saveProductBrief(productFull.getName(), productFull.getPrice());
        //productRepo.saveProductBrief(productFull.getName(), productFull.getPrice());
        productRepo.save(productFull);
        System.out.println(categoryBriefList);
    }

    public void removeProductById(Long id) {
    }
}
