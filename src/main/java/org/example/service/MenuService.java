package org.example.service;

import org.example.abstractModel.FoodCategory;
import org.example.abstractModel.FoodType;
import org.example.abstractModel.Metadata;
import org.example.abstractModel.Size;
import org.example.dto.MenuDetails;
import org.example.dto.MetadataDTO;
import org.example.model.Bread;
import org.example.model.FoodItem;

import java.util.List;

public class MenuService {

    public void upsertMenuItem(FoodItem foodItem) {
        Metadata metadata = new Metadata(foodItem.getName(), foodItem.getDescription(), foodItem.getPrice());
        MetadataDTO.addMetadata(foodItem.getName(), metadata);
        MenuDetails.addMenuDetails(foodItem.getName(), foodItem);
    }

    public FoodItem createFoodItem(String name,
                                   float price,
                                   String description,
                                   Size size,
                                   List<String> toppings,
                                   FoodCategory category,
                                   FoodType foodType) {

        return new FoodItem(name, price, description, size, toppings, category, foodType);
    }


}
