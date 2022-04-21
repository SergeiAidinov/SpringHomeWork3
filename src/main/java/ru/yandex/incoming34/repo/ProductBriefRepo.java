package ru.yandex.incoming34.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.incoming34.entities.product.ProductBrief;

@Repository
public interface ProductBriefRepo extends CrudRepository<ProductBrief, Long> {
}
