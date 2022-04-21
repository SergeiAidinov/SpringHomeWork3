package ru.yandex.incoming34.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.entities.category.Category;
import ru.yandex.incoming34.entities.category.CategoryBrief;
import ru.yandex.incoming34.repo.CategoryBriefRepo;
import ru.yandex.incoming34.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryBriefRepo categoryBriefRepo;

    @GetMapping("/all_categories_with__goods")
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        categoryService.getAllCategories().forEach(categoryList::add);
        return categoryList;
    }

    @GetMapping("/all-brief-categories")
    public List<CategoryBrief> getAllBriefCategories() {
        List<CategoryBrief> categoryBriefList = new ArrayList<>();
        categoryBriefRepo.findAll().forEach(categoryBriefList::add);
        return categoryBriefList;
    }

}
