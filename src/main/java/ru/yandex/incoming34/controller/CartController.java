package ru.yandex.incoming34.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.incoming34.dto.CartDto;
import ru.yandex.incoming34.service.CartService;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    private final CartService cartService;
    private final JsonNodeFactory factory = JsonNodeFactory.instance;



    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping("/product")
    public void addProduct(Integer id){
        cartService.addProduct(id);

    }

    @GetMapping("/content")
    public ResponseEntity getContent(){
        CartDto cartDto = cartService.getContent();
        JsonNode json = factory.pojoNode(cartDto);
        return new ResponseEntity(json, HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public void removeProduct(Long id){
        cartService.removeProduct(id);
    }

    @DeleteMapping("/all")
    public void clearCart(){
        cartService.clearCart();
    }


}
