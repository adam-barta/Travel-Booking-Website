package com.example.d288.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseResponseData {
    private final String orderTrackingNumber;

    public PurchaseResponseData(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}