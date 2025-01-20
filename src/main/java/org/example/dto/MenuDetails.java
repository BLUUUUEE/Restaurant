package org.example.dto;

import org.example.model.FoodItem;
import utils.JSONfilehandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuDetails {

    private final static Map<String, FoodItem> menu = new HashMap<>();

    public static void addMenuDetails(String key, FoodItem foodItem) {
        menu.put(key, foodItem);
        JSONfilehandler.addTOJsonFile(key,foodItem);
    }

    public static FoodItem getMenuDetail(String key) {
        if (menu.containsKey(key)) {
            return menu.get(key);
        } else {
            throw new IllegalArgumentException("No such Menu Details");
        }

    }
    public static ArrayList<FoodItem> getCompleteMenu(){
        Map<String,FoodItem>foodMap = JSONfilehandler.readAllDataFromJsonFile();
            ArrayList<FoodItem>foodItems = new ArrayList<>();
            for(FoodItem foodItem:foodMap.values()){
                foodItems.add(foodItem);
            }
            return foodItems;
    }

}
