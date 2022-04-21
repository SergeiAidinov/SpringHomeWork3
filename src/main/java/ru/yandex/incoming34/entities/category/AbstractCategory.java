package ru.yandex.incoming34.entities.category;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class AbstractCategory {

    @Id
    @Column(name = "category_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
