package org.example.model;

import org.example.abstractModel.FoodCategory;
import org.example.abstractModel.FoodType;
import org.example.abstractModel.Size;
import org.example.interfaces.MenuItem;

import java.util.List;

public class FoodItem implements MenuItem {
    private String name;
    private float price;
    private String description;
    private Size size;
    private List<String> toppings;
    private FoodCategory category;
    private FoodType foodType;

    public FoodItem(String name, float price, String description, Size size, List<String> toppings, FoodCategory category, FoodType foodType) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.size = size;
        this.toppings = toppings;
        this.category = category;
        this.foodType = foodType;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Float getPrice() {
        return this.price ;
    }




    public Size getSize() {
        return size;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public FoodCategory getCategory() {
        return category;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public FoodType getFoodType() {
        return foodType;
    }
}
