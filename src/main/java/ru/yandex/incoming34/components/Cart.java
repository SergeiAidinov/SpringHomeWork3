package ru.yandex.incoming34.components;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cart {

    private final Map<Long, Integer> productIdQuantityMap = new HashMap<>();

    public void addProduct(Long id){

        if (productIdQuantityMap.containsKey(id)){
            Integer newQuantity = productIdQuantityMap.get(id) + 1;
            productIdQuantityMap.put(id, newQuantity);
        } else {
            productIdQuantityMap.put(id, 1);
        }

    }
}
