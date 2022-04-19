package ru.yandex.incoming34.entities.product;

import ru.yandex.incoming34.entities.category.CategoryBrief;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class ProductFull extends AbstractProduct {

    @Column(name = "product_name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @ManyToMany
    @JoinTable(
            name = "link_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryBrief> categoryBriefList;

    public ProductFull() {

    }

    public ProductFull(List<CategoryBrief> categoryBriefList) {
        this.categoryBriefList = categoryBriefList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<CategoryBrief> getCategoryBriefList() {
        return categoryBriefList;
    }

    public void setCategoryBrifList(List<CategoryBrief> categoryBriefList) {
        this.categoryBriefList = categoryBriefList;
    }
}
