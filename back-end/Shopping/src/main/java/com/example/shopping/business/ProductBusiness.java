package com.example.shopping.business;

import com.example.shopping.entity.Product;
import com.example.shopping.exception.ProductException;
import com.example.shopping.modal.MProductRequest;
import com.example.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBusiness {
    @Autowired
    ProductRepository productRepository;
    public Product addProduct(MProductRequest request) throws ProductException {
        Product entity = new Product();
        entity.setProduct_code(request.getProduct_code());
        entity.setProduct_name(request.getProduct_name());
        entity.setProduct_price(request.getProduct_price());
        entity.setProduct_amount(request.getProduct_amount());
        productRepository.save(entity);
        return entity;
    }

    public List<Product> getAll(){
        List<Product> response = productRepository.findAll();
        return response;
    }

    public Product getById(String product_id){
        Product response = productRepository.findByProductId(product_id);
        return response;
    }
}
