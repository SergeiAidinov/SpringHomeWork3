package ru.yandex.incoming34.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.incoming34.components.Cart;
import ru.yandex.incoming34.dto.CartDto;
import ru.yandex.incoming34.service.CartSevice;
import springfox.documentation.spring.web.json.Json;

import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartSevice cartSevice;
    private final JsonNodeFactory factory = JsonNodeFactory.instance;

    public CartController(CartSevice cartSevice) {
        this.cartSevice = cartSevice;
    }

    @PutMapping("/add_product")
    public void addProduct(Integer id){
        cartSevice.addProduct(id);

    }

    @GetMapping("/content")
    public ResponseEntity<CartDto> getContent(){
        CartDto cartDto = cartSevice.getContent();
        JsonNode json = factory.pojoNode(cartDto);
        return new ResponseEntity(json, HttpStatus.OK);
    }

    @PutMapping("/remove_product")
    public void removeProduct(Long id){
        cartSevice.removeProduct(id);
    }


}
