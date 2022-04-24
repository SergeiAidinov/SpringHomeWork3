package ru.yandex.incoming34.service;

import org.springframework.stereotype.Service;
import ru.yandex.incoming34.components.Cart;
import ru.yandex.incoming34.dto.CartDto;

@Service
public class CartSevice {

    private final Cart cart;
    private final Convertor convertor;

    public CartSevice(Cart cart, Convertor convertor) {
        this.cart = cart;
        this.convertor = convertor;
    }

    public void addProduct(Integer id) {
        cart.addProduct(id);
        System.out.println(cart);
    }

    public CartDto getContent() {
        CartDto cartDto = convertor.convertcartToCartDto(cart);
        return cartDto;
    }


    public void removeProduct(Long id) {
        cart.removeProduct(id);
    }

}
