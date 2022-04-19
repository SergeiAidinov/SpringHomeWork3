package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.dto.NewProductDto;
import ru.yandex.incoming34.dto.ProductBriefDto;
import ru.yandex.incoming34.dto.ProductFullDto;
import ru.yandex.incoming34.entities.category.CategoryBrief;
import ru.yandex.incoming34.entities.product.ProductFull;
import ru.yandex.incoming34.repo.CategoryRepo;
import ru.yandex.incoming34.repo.ProductsRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductsRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final Convertor convertor;

    @Autowired
    public ProductService(ProductsRepo productRepo, Convertor convertor, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.convertor = convertor;
        this.categoryRepo =  categoryRepo;
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
        return productRepo.findProductFullById(id).map(convertor::convertProductFullToDto);
    }

    public void putProduct(NewProductDto newProductDto) {
        ProductFull productFull = convertor.convertNewProductToProductFull(newProductDto);
        List<CategoryBrief> categoryBriefList = newProductDto.getCategoriesNumberList().stream()
                .map(id -> categoryRepo.findBriefCategoryById(id)).collect(Collectors.toList());
        productFull.setCategoryBrifList(categoryBriefList);
        productRepo.saveProductBrief(productFull.getName(), productFull.getPrice());
        //productRepo.saveProductBrief()
        //productRepo.save(productFull);
        System.out.println(categoryBriefList);
    }

    public void removeProductById(Long id) {
    }
}
