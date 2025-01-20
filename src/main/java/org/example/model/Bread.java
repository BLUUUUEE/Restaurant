package org.example.model;

public class Bread {
    private final String type;
    private final float price;

    public Bread(float price, String type) {
        this.price = price;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }
}
