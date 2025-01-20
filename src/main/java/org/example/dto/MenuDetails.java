package org.example.dto;

import org.example.abstractModel.FoodType;
import org.example.model.FoodItem;
import org.example.utils.JSONfilehandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuDetails {

    private final static Map<String, FoodItem> menu = new HashMap<>();

    private  static Map<String,FoodItem> staticFoodItemList = new HashMap<>();

    public static void fetchAllDataPriorToObjectDeclaration (){
        staticFoodItemList =JSONfilehandler.readAllDataFromJsonFile();

    }


    public static void addMenuDetails(String key, FoodItem foodItem) {
        menu.put(key, foodItem);
        staticFoodItemList.put(key,foodItem);
        JSONfilehandler.addToJsonFile(key,foodItem);
    }

    public static FoodItem getMenuDetail(String key) {
        if (menu.containsKey(key)) {

            return menu.get(key);
        } else {
            throw new IllegalArgumentException("No such Menu Details");
        }

    }
    public static ArrayList<FoodItem> fetchDatawithFoodType(FoodType foodType){

            ArrayList<FoodItem>foodItems = new ArrayList<>();

        if(foodType==FoodType.BURGER){
            for(FoodItem foodItem:staticFoodItemList.values()){
                    if(foodItem.getFoodType()==foodType)foodItems.add(foodItem);
                }
            return foodItems;
        }else{
            for(FoodItem foodItem:staticFoodItemList.values()){
                if(foodItem.getFoodType()==foodType)foodItems.add(foodItem);
            }
            return foodItems;
        }
    }

}
