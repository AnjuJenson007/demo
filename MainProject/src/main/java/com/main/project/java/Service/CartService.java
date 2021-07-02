package com.main.project.java.Service;

import com.main.project.java.Entity.Cart;
import com.main.project.java.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();

    }
    public void saveCart(Cart cart){
        this.cartRepository.save(cart);

    }
    public Cart getCartById(int cartId){
        Optional<Cart> optional = cartRepository.findById(cartId);
        Cart cart = null;
        if (optional.isPresent()) {
            cart = optional.get();
        } else {
            throw new RuntimeException("---------- cart not found----- " + cartId);
        }
        return cart;
    }

    public void deleteCartById(int cartId){
        this.cartRepository.deleteById(cartId);

    }


}
