package com.example.shopping.exception;

public class ShoppingCartException extends BaseException{
    public ShoppingCartException(String code) {
        super("ShoppingCart " + code);
    }
    public static ShoppingCartException requestNull(){
        return new ShoppingCartException(" request.null");
    }
    public static ShoppingCartException productIdNull(){
        return new ShoppingCartException(" productId.null");
    }
}
