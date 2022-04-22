package ru.yandex.incoming34.entities.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryBrief {

    @Id
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String catergoryName;



    public String getCatergoryName() {
        return catergoryName;
    }

    public void setCatergoryName(String catergoryName) {
        this.catergoryName = catergoryName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
