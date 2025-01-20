package org.example.model;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private final String customerName;
    private final String orderId;
    private final List<FoodItem> items;
    private float totalPrice;

    public Order(String customerName, String orderId) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0f;
    }

    public void addItem(FoodItem item) {
        this.items.add(item);
        this.totalPrice += item.getPrice();
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Details:");
        for (FoodItem item : items) {
            System.out.println("- " + item.getName() + " (" + item.getCategory() + ", " + item.getFoodType() + ") - Price: " + item.getPrice());
        }
        System.out.println("Total Price: " + totalPrice);
    }


}



