package ru.yandex.incoming34.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.incoming34.service.CartSevice;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartSevice cartSevice;

    public CartController(CartSevice cartSevice) {
        this.cartSevice = cartSevice;
    }

    @PutMapping("/add_product")
    public void addProduct(Long id){
        cartSevice.addProduct(id);

    }
}
