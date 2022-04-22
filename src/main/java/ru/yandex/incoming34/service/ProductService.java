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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductDao productDao;
    private final Convertor convertor;
    private final CategoryDao categoryDao;

    @Autowired
    public ProductService(ProductDao productDao, CategoryDao categoryDao, Convertor convertor) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.convertor = convertor;

    }

    public List<ProductBriefDto> showAllBriefProducts() {
        List<ProductBriefDto> productBriefDtoList = new ArrayList<>();
        productDao.findAllProductBrief().forEach(productBrief -> {
            ProductBriefDto productBriefDto =
                    convertor.convertProductBriefToDto(productBrief);
            productBriefDtoList.add(productBriefDto);
        });
        return productBriefDtoList;

    }

    public List<ProductFullDto> showAllProductsWithCategories() {
        List<ProductFull> productFullList = productDao.findAllProductsFull();
        return productFullList.stream()
                .map(productFull -> convertor.convertProductFullToDto(productFull))
                .collect(Collectors.toList());
    }

    public Optional<ProductFullDto> getProductFullById(Long id) {
        return productDao.findProductFullById(id).map(convertor::convertProductFullToDto);
    }

    public void putProduct(NewProductDto newProductDto) {
        ProductFull productFull = convertor.convertNewProductToProductFull(newProductDto);
        List<CategoryBrief> categoryBriefList = new ArrayList<>();
        newProductDto.getCategoriesNumberList().stream()
                .forEach(id -> {
                    Optional<CategoryBrief> categoryBriefOptional = categoryDao.findCategoryBriefById(id);
                    if (categoryBriefOptional.isPresent()) {
                        categoryBriefList.add(categoryBriefOptional.get());
                    }
                });

        productFull.setCategoryBriefList(categoryBriefList);
        productDao.saveProductFull(productFull);
    }

    public void removeProductById(Long id) {
        productDao.removeProductById(id);
    }
}
