package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.dao.CategoryDao;
import ru.yandex.incoming34.dto.CategoryBriefDto;
import ru.yandex.incoming34.entities.category.CategoryBrief;
import ru.yandex.incoming34.entities.category.CategoryFull;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryDao categoryDao;
    private final Convertor convertor;

    @Autowired
    public CategoryService(CategoryDao categoryDao, Convertor convertor) {
        this.categoryDao = categoryDao;
        this.convertor = convertor;
    }

    public Iterable<CategoryFull> getAllCategories() {

        return categoryDao.findAllCategories();
    }

    public Iterable<CategoryBrief> getAllBriefCategories() {

        return categoryDao.findAllBriefCategories();
    }

    public List<CategoryBrief> findAllCategoryBrief() {
        return categoryDao.findAllBriefCategories();
    }

    public void createCategory(CategoryBriefDto categoryBriefDto) {
        CategoryBrief categoryBrief = convertor.convertCategoryBriefDtoToCategoryBrief(categoryBriefDto);
        categoryDao.saveCategoryBrief(categoryBrief);

    }

    public void removeCategory(Long id) {
        categoryDao.removeCategory(id);
    }
}

