package com.example.shopping.repository;

import com.example.shopping.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query(nativeQuery = true, value = "SELECT s.* FROM tbl_shopping_cart s WHERE s.id = ':id'")
    ShoppingCart findByCartId(@Param("id") String id);
    @Query(nativeQuery = true, value = "select s.* from tbl_shopping_cart s WHERE s.product_id = :product_id")
    ShoppingCart findByProductId(@Param("product_id") String product_id);

    @Query(nativeQuery = true, value = "DELETE FROM tbl_shopping_cart WHERE id = :shopping_cart_id RETURNING *")
    ShoppingCart deleteByCartId(@Param("shopping_cart_id") String shopping_cart_id);
}
