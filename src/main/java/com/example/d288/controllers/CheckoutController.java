package com.example.d288.controllers;

import com.example.d288.services.CheckoutService;
import com.example.d288.services.PurchaseData;
import com.example.d288.services.PurchaseResponseData;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponseData placeOrder(@RequestBody PurchaseData purchaseData) {
        PurchaseResponseData purchaseResponse = checkoutService.placeOrder(purchaseData);

        return purchaseResponse;
    }
}