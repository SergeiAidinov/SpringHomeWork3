package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.dao.CategoryDao;
import ru.yandex.incoming34.entities.category.Category;
import ru.yandex.incoming34.entities.category.CategoryBrief;

@Service
public class CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Iterable<Category> getAllCategories() {

        return categoryDao.findAllCategories();
    }

    public Iterable<CategoryBrief> getAllBriefCategories() {

        return categoryDao.findAllBriefCategories();
    }
}

