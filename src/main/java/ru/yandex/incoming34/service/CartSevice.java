package ru.yandex.incoming34.service;

import org.springframework.stereotype.Service;
import ru.yandex.incoming34.components.Cart;

@Service
public class CartSevice {

    private final Cart cart;

    public CartSevice(Cart cart) {
        this.cart = cart;
    }

    public void addProduct(Long id) {
        cart.addProduct(id);
        System.out.println(cart);
    }
}
