package ru.yandex.incoming34.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class ProductFull extends AbstractProduct{

    @Column(name = "product_name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @ManyToMany
    @JoinTable(
            name = "link_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryBrief> categoryList;

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

    public ProductFull() {

    }

    public ProductFull(List<CategoryBrief> categoryList) {
        this.categoryList = categoryList;
    }

    public List<CategoryBrief> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryBrief> categoryList) {
        this.categoryList = categoryList;
    }
}
