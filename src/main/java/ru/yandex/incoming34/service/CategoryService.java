package ru.yandex.incoming34.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.entities.Category;
import ru.yandex.incoming34.entities.CategoryBrief;
import ru.yandex.incoming34.repo.CategoryRepo;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public Iterable<Category> getAllCategories() {

        return categoryRepo.findAllCategories();
    }

    public Iterable<CategoryBrief> getAllBriefCategories() {

        return categoryRepo.findAllBriefCategories();
    }
}

