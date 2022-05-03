package ru.yandex.incoming34.dto;

import ru.yandex.incoming34.entities.category.CategoryBrief;

import java.util.List;

public class ProductFullDto extends ProductBriefDto{

    private List<CategoryBrief> categoryBriefList;

    public ProductFullDto() {
    }

    public ProductFullDto(List<CategoryBrief> categoryBriefList) {
        this.categoryBriefList = categoryBriefList;
    }

    public ProductFullDto(Long id, String name, Integer price, List<CategoryBrief> categoryBriefList) {
        super(id, name, price);
        this.categoryBriefList = categoryBriefList;
    }

    public List<CategoryBrief> getCategoryBriefList() {
        return categoryBriefList;
    }

    public void setCategoryBriefList(List<CategoryBrief> categoryBriefList) {
        this.categoryBriefList = categoryBriefList;
    }
}
