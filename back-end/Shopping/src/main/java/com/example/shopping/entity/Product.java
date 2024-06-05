package com.example.shopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_product")
public class Product extends BaseEntity {

    private String product_code;
    private String product_name;
    private int product_price;
    private int product_amount;
}
