package ru.yandex.incoming34.entities.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryBrief extends AbstractCategory {

    @Column(name = "category_name")
    private String catergoryName;

    public String getCatergoryName() {
        return catergoryName;
    }

    public void setCatergoryName(String catergoryName) {
        this.catergoryName = catergoryName;
    }
}
