package ru.yandex.incoming34.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.entities.category.CategoryBrief;
import ru.yandex.incoming34.entities.category.CategoryFull;
import ru.yandex.incoming34.repo.CategoryBriefRepo;
import ru.yandex.incoming34.repo.CategoryFullRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryDao {

    private final CategoryFullRepo categoryFullRepo;
    private final CategoryBriefRepo categoryBriefRepo;

    @Autowired
    public CategoryDao(CategoryFullRepo categoryFullRepo, CategoryBriefRepo categoryBriefRepo) {
        this.categoryFullRepo = categoryFullRepo;
        this.categoryBriefRepo = categoryBriefRepo;
    }

    public List<CategoryFull> findAllCategories() {

        return (List<CategoryFull>) categoryFullRepo.findAll();
    }

    public List<CategoryBrief> findAllBriefCategories() {

        return (List<CategoryBrief>) categoryBriefRepo.findAll();
    }

    public Optional<CategoryBrief> findCategoryBriefById(Long id) {

        return categoryBriefRepo.findById(id);
    }
}
