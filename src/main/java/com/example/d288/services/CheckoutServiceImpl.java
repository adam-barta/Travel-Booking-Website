package com.example.d288.services;

import com.example.d288.dao.CartItemRepository;
import com.example.d288.dao.CartRepository;
import com.example.d288.entities.Cart;
import com.example.d288.entities.CartItem;
import com.example.d288.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponseData placeOrder(PurchaseData purchaseData) {
        Cart cart = purchaseData.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();

        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);

        cart = cartRepository.save(cart);

        Set<CartItem> cartItems = purchaseData.getCartItems();
        for (CartItem cartItem : cartItems) {
            cartItem.setCart(cart);
        }

        cartItemRepository.saveAll(cartItems);

        if (cartItems.isEmpty()) {
            return new PurchaseResponseData("Cart is empty");
        }

        return new PurchaseResponseData(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
