package com.example.shopping.modal;

import lombok.Data;

@Data
public class MProductRequest {
    private String product_code;
    private String product_name;
    private int product_price;
    private int product_amount;
}
