package org.example.utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.FoodItem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class JSONfilehandler {
    private static final String fileName = "/Users/vibhork/Desktop/Restaurant/src/main/resources/data.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void addTOJsonFile(String key,FoodItem foodItem){
        Map<String,FoodItem>allData = readAllDataFromJsonFile();
        allData.put(key,foodItem);

        try(FileWriter writer = new FileWriter(fileName)){
            gson.toJson(allData,writer);
            System.out.println(key+" saved to the Menu");
        }catch(IOException e){
            System.err.println("Error saving Item to Menu: "+e.getMessage());
        }
    }

    public static Map<String, FoodItem> readAllDataFromJsonFile() {
        try (FileReader reader = new FileReader(fileName)) {

            Type type = new TypeToken<Map<String, FoodItem>>() {}.getType();


            return gson.fromJson(reader, type);
        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
            return new HashMap<>();
        }
    }





}
