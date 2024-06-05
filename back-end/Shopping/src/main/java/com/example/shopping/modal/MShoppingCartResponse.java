package com.example.shopping.modal;

import com.example.shopping.entity.Product;
import lombok.Data;

@Data
public class MShoppingCartResponse {
    private String shopping_cart_id;
    private int shopping_cart_amount;
    private String status;
    private Product data;

}
