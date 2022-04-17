package ru.yandex.incoming34.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends AbstractCategory{

    @Id
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String catergoryName;

    @ManyToMany
    @JoinTable(name = "link_product_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCatergoryName() {
        return catergoryName;
    }

    public void setCatergoryName(String catergoryName) {
        this.catergoryName = catergoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
