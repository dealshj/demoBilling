package com.example.demo.enums;

public enum ItemDiscounts {
    CUSTOMER(0.05),
    AFFILIATE(0.1),
    EMPLOYEE(0.3);

    private final double discount;

    ItemDiscounts(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
