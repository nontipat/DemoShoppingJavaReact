package com.example.shopping.repository;

import com.example.shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value = "select s.* from tbl_product s WHERE s.id = :product_id")
    Product findByProductId(@Param("product_id") String product_id);
}
