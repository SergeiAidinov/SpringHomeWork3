package ru.yandex.incoming34.repo;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.entities.category.CategoryBrief;

@PropertySource("classpath:SpringHomeWork3.properties")
@Repository
public interface CategoryBriefRepo extends CrudRepository<CategoryBrief, Long> {

}
