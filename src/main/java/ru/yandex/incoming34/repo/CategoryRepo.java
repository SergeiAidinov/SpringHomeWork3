package ru.yandex.incoming34.repo;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.entities.category.AbstractCategory;
import ru.yandex.incoming34.entities.category.Category;
import ru.yandex.incoming34.entities.category.CategoryBrief;

@PropertySource("classpath:SpringHomeWork3.properties")
@Repository
public interface CategoryRepo extends CrudRepository <AbstractCategory, Long>{

    @Query(nativeQuery = true, value = "SELECT category_id, category_name FROM category")
    Iterable<Category> findAllCategories();

    @Query(nativeQuery = true, value = "SELECT category_id, category_name FROM category")
    Iterable<CategoryBrief> findAllBriefCategories();

    @Query(nativeQuery = true, value = "SELECT category_id, category_name FROM category WHERE category_id = ?1")
    CategoryBrief findBriefCategoryById(Long id);

}
