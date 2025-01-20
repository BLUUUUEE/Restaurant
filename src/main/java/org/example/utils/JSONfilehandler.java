package org.example.utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.FoodItem;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class JSONfilehandler {
    private static String fileName = "data.json";
    private static Type type = new TypeToken<Map<String, FoodItem>>() {}.getType();
    private static Map<String,FoodItem> allData;

    static {
        loadJsonFile();
    }

    private static void loadJsonFile() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream(fileName);
        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        allData = new Gson().fromJson(reader, type);
    }

    public static void addToJsonFile(String key, FoodItem foodItem){
        allData.put(key,foodItem);

        try(FileWriter writer = new FileWriter(fileName)){
            new Gson().toJson(allData,writer);
            System.out.println(key+" saved to the Menu");
        }catch(IOException e){
            System.err.println("Error saving Item to Menu: "+e.getMessage());
        }
    }

    public static Map<String, FoodItem> readAllDataFromJsonFile() {
        return allData;
    }


}
