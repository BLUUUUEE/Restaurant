package org.example.service;

import org.example.dto.MenuDetails;
import org.example.model.FoodItem;
import org.example.model.Order;

import java.util.List;

public class OrderService {
    public Order createOrder(String customerName, String orderId, List<String> itemNames) {
        Order order = new Order(customerName, orderId);

        for (String itemName : itemNames) {
            try {
                FoodItem foodItem = MenuDetails.getMenuDetail(itemName);
                order.addItem(foodItem);
            } catch (IllegalArgumentException e) {
                System.out.println("Item " + itemName + " is not available in the menu.");
            }
        }

        return order;
    }
}
