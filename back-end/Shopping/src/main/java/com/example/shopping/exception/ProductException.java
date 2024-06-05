package com.example.shopping.exception;

public class ProductException extends BaseException{
    public ProductException(String code) {
        super("Product " + code);
    }
}
