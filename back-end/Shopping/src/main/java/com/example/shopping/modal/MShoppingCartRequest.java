package com.example.shopping.modal;

import lombok.Data;

@Data
public class MShoppingCartRequest {
    private String product_id;
    private int product_amount;

}
