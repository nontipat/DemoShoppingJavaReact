package com.example.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "tbl_shopping_cart")
public class ShoppingCart extends BaseEntity {
    private int cart_amount;
    private String product_id;
}
