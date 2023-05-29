package com.example.demo.beans;


import com.example.demo.enums.ProductTypes;

public  class Product  {
    private final String name;
    private int quantity;
    private final ProductTypes type;
    private final double unitPrice;



    public Product( String name, int quantity, ProductTypes type, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductTypes getType() {
        return type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", type=" + type +
                ", unitPrice=" + unitPrice +
                '}';
    }

}
