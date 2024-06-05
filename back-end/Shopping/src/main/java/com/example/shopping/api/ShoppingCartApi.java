package com.example.shopping.api;

import com.example.shopping.business.ShoppingCartBusiness;
import com.example.shopping.entity.ShoppingCart;
import com.example.shopping.exception.BaseException;
import com.example.shopping.modal.MShoppingCartRequest;
import com.example.shopping.modal.MShoppingCartResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/ShoppingCart")
public class ShoppingCartApi {

    private final ShoppingCartBusiness business;

    public ShoppingCartApi(ShoppingCartBusiness business) {
        this.business = business;
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCart>> shoppingcart() {
        List<ShoppingCart> shoppingCarts = business.getAll();
        return ResponseEntity.ok(shoppingCarts);
    }

//    @GetMapping("/id")
//    public ResponseEntity<String> add(@PathVariable("id") String id) {
//        String response = business.getShoppingCartById(id);
//        return ResponseEntity.ok(response);
//    }

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<MShoppingCartResponse> add(@RequestBody MShoppingCartRequest request) throws BaseException {
        MShoppingCartResponse response = business.addtocart(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.ok("");
    }

    @DeleteMapping
    @RequestMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody MShoppingCartRequest request) {
        String response = business.deleteById(request);
        return ResponseEntity.ok(response);
    }
}
