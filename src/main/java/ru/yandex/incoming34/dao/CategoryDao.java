package ru.yandex.incoming34.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.entities.category.Category;
import ru.yandex.incoming34.entities.category.CategoryBrief;
import ru.yandex.incoming34.repo.CategoryBriefRepo;
import ru.yandex.incoming34.repo.CategoryFullRepo;

import java.util.Optional;

@Service
public class CategoryDao {

    @Autowired
    CategoryFullRepo categoryFullRepo;

    @Autowired
    CategoryBriefRepo categoryBriefRepo;


    public Iterable<Category> findAllCategories() {
        return categoryFullRepo.findAll();
    }

    public Iterable<CategoryBrief> findAllBriefCategories() {

        return categoryBriefRepo.findAll();
    }

    public Optional<CategoryBrief> findCategoryBriefById(Long id) {
        return categoryBriefRepo.findById(id);
    }
}
