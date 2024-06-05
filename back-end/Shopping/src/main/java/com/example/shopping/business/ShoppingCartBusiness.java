package com.example.shopping.business;

import com.example.shopping.entity.Product;
import com.example.shopping.entity.ShoppingCart;
import com.example.shopping.exception.ShoppingCartException;
import com.example.shopping.modal.MShoppingCartRequest;
import com.example.shopping.modal.MShoppingCartResponse;
import com.example.shopping.repository.ProductRepository;
import com.example.shopping.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShoppingCartBusiness {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ProductRepository productRepository;

    public MShoppingCartResponse addtocart(MShoppingCartRequest request) throws ShoppingCartException {
        if (request == null) {
            throw ShoppingCartException.productIdNull();
        }
        if (Objects.isNull(request.getProduct_id())) {
            throw ShoppingCartException.productIdNull();
        }
        MShoppingCartResponse response = new MShoppingCartResponse();

        ShoppingCart product_cart = getShoppingCartByProductId(request.getProduct_id());
        System.out.println(product_cart);
        ShoppingCart entity = new ShoppingCart();
        ShoppingCart shoppingCart;
        if (product_cart != null) {
            entity.setId(product_cart.getId());
            entity.setCart_amount(product_cart.getCart_amount() + request.getProduct_amount());
            entity.setProduct_id(request.getProduct_id());
            shoppingCart = shoppingCartRepository.save(entity);
        } else {
            entity.setCart_amount(request.getProduct_amount());
            entity.setProduct_id(request.getProduct_id());
            shoppingCart = shoppingCartRepository.save(entity);
        }

        Product res_product = new Product();

        if (shoppingCart != null) {
            Product product_stack = productRepository.findByProductId(shoppingCart.getProduct_id());
            Product product = new Product();
            product.setId(shoppingCart.getProduct_id());
            product.setProduct_code(product_stack.getProduct_code());
            product.setProduct_name(product_stack.getProduct_name());
            product.setProduct_price(product_stack.getProduct_price());
            product.setProduct_amount(product_stack.getProduct_amount() - request.getProduct_amount());
            res_product = productRepository.save(product);

        }

        response.setShopping_cart_id(shoppingCart.getId());
        response.setShopping_cart_amount(shoppingCart.getCart_amount());
        response.setStatus("insert success");
        response.setData(res_product);

        return response;
    }

    public List<ShoppingCart> getAll() {
        List<ShoppingCart> response = shoppingCartRepository.findAll();
        return response;
    }

    public ShoppingCart getShoppingCartByProductId(String product_id) {
        ShoppingCart response = shoppingCartRepository.findByProductId(product_id);
        return response;
    }
    public ShoppingCart deleteShoppingCartByShoppingCartId(String shopping_cart_id) {
        ShoppingCart response = shoppingCartRepository.deleteByCartId(shopping_cart_id);
        return response;
    }

    public String deleteById(MShoppingCartRequest request){
        ShoppingCart shoppingCart = getShoppingCartByProductId(request.getProduct_id());
        if (shoppingCart != null) {
            Product product_stack = productRepository.findByProductId(shoppingCart.getProduct_id());
            Product product = new Product();
            product.setId(shoppingCart.getProduct_id());
            product.setProduct_code(product_stack.getProduct_code());
            product.setProduct_name(product_stack.getProduct_name());
            product.setProduct_price(product_stack.getProduct_price());
            product.setProduct_amount(product_stack.getProduct_amount() + shoppingCart.getCart_amount());
            productRepository.save(product);
            deleteShoppingCartByShoppingCartId(shoppingCart.getId());
            return "Delete Success";
        }
        return "Data Not Found";

    }

}
