package com.example.shopping.api;

import com.example.shopping.business.ProductBusiness;
import com.example.shopping.entity.Product;
import com.example.shopping.exception.ProductException;
import com.example.shopping.modal.MProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/product")
public class ProductApi {
    private final ProductBusiness business;

    public ProductApi(ProductBusiness business) {
        this.business = business;
    }
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Product>> product() {
        List<Product> product = business.getAll();
        return ResponseEntity.ok(product);
    }

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<Product> add(@RequestBody MProductRequest request) throws ProductException {
        Product response = business.addProduct(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.ok("");
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("");
    }
}
