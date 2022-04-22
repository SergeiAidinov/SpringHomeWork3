package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.dao.CategoryDao;
import ru.yandex.incoming34.entities.category.CategoryBrief;
import ru.yandex.incoming34.entities.category.CategoryFull;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Iterable<CategoryFull> getAllCategories() {

        return categoryDao.findAllCategories();
    }

    public Iterable<CategoryBrief> getAllBriefCategories() {

        return categoryDao.findAllBriefCategories();
    }

    public List<CategoryBrief> findAllCategoryBrief() {
        return (List<CategoryBrief>) categoryDao.findAllBriefCategories();
    }
}

