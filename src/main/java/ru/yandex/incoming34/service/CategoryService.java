package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.entities.category.Category;
import ru.yandex.incoming34.entities.category.CategoryBrief;
import ru.yandex.incoming34.repo.CategoryRepo;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;


    public Iterable<Category> getAllCategories() {

        return categoryRepo.findAllCategories();
    }

    public Iterable<Category> getAllBriefCategories() {

        return categoryRepo.findAllBriefCategories();
    }
}

