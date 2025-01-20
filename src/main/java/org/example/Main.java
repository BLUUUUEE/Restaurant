package org.example;

import org.example.abstractModel.FoodCategory;
import org.example.abstractModel.FoodType;
import org.example.abstractModel.Metadata;
import org.example.abstractModel.Size;
import com.sun.security.jgss.GSSUtil;
import org.example.dto.MenuDetails;
import org.example.dto.MetadataDTO;
import org.example.model.Bread;
import org.example.model.FoodItem;
import org.example.service.MenuService;
import org.example.service.OrderService;
import org.example.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();

        ArrayList<String>names = new ArrayList<>();

        Map<Integer, Bread> breadMap = new HashMap<>();
        breadMap.put(1, new Bread(70f, "Garlic"));
        breadMap.put(2, new Bread(60f, "Low fat"));
        breadMap.put(3, new Bread(90f, "Dry fruit added"));

        do {
            System.out.println("Choose Operation: " + "\n" + "1. Create Menu Item " + "2. List Menu " + "3. Exit");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                String foodItemName;
                Size selectedSize;
                ArrayList<String> toppings = new ArrayList<>();
                FoodType foodType;
                FoodCategory selectCategory;
                Float price;

                System.out.println("Enter the food item details:");
                System.out.println("Enter the food type: \n" + "1. Pizza\n" + "2. Burger");
                int inputFoodType = Integer.parseInt(sc.nextLine());

                if (inputFoodType == 1) {
                    System.out.println("Enter the name of you Pizza");
                    foodItemName = sc.nextLine();
                    foodType = FoodType.PIZZA;
                } else {
                    System.out.println("Enter the name of you Burger");
                    foodItemName = sc.nextLine();
                    foodType = FoodType.BURGER;
                }

                System.out.println("Enter description: ");
                String desc = sc.nextLine();
                System.out.println("Enter the size: " + "\n" + "1. Small" + "\n" + "2. Medium" + "\n" + "3. Large");
                int inputSize = Integer.parseInt(sc.nextLine());

                if (inputSize == 1) {
                    selectedSize = Size.SMALL;
                } else if (inputSize == 2) {
                    selectedSize = Size.MEDIUM;
                } else {
                    selectedSize = Size.LARGE;
                }

                System.out.println("Enter the number of toppings you want to have: ");
                int n = Integer.parseInt(sc.nextLine());

                toppings.clear();
                while (n-- > 0) {
                    System.out.println("Enter the topping name: ");
                    String str = sc.nextLine();
                    toppings.add(str);
                }
                System.out.println("Enter the type of Category: \n" + "1. Veg \n" + "2. Non-veg");
                int w = Integer.parseInt(sc.nextLine());
                if (w == 1) {
                    selectCategory = FoodCategory.VEG;
                } else {
                    selectCategory = FoodCategory.NON_VEG;
                }

                System.out.println("Specify the price of your Product");
                price = Float.parseFloat(sc.nextLine());

                menuService.upsertMenuItem(menuService.createFoodItem(foodItemName, price, desc, selectedSize,
                        toppings, selectCategory, foodType));

                names.add(foodItemName);
//                System.out.println(MetadataDTO.getMetadata());

                System.out.println("Your Food Item has been added to the menu List!!");
            } else if (choice == 2) {

                Float payableAmount=0f;

                while(true)  {
                    System.out.println("This is the menu please select your preferences: ");
                    int counter = 1;
                    ArrayList<FoodItem>foodList = MenuDetails.getCompleteMenu();

                    for(int i=1;i<= foodList.size();i++){
                        System.out.println(i+". "+foodList.get(i-1).getName()+" "+foodList.get(i-1).getPrice()+" "+foodList.get(i-1).getDescription());
                    }
//                    for (String s : names) {
//                        System.out.println(s);
//                        Metadata metaInfo = MetadataDTO.getMetadata(s);
//                        System.out.println(counter + ". " + metaInfo.toString()+" "+metaInfo.getPrice());
//
//                        counter++;
//                    }

                    ArrayList<Integer> orderIndices = new ArrayList<>();

                    System.out.println("Enter the number of dishes you want to select: ");
                    int dishedCount = Integer.parseInt(sc.nextLine());

                    for(int i=0;i<dishedCount;i++) {
                        System.out.println("Enter you dish number: ");

                        int order = Integer.parseInt(sc.nextLine());
                        orderIndices.add(order);
                        payableAmount += foodList.get(i).getPrice();
                        // bread selection
                        System.out.println("Select your bread preference:");
                        for (Integer bread : breadMap.keySet()) {
                            System.out.println(bread + ". " + breadMap.get(bread).getType()
                                    + "-" + breadMap.get(bread).getPrice());
                        }
                        int breadPref = Integer.parseInt(sc.nextLine());
                        payableAmount += breadMap.get(breadPref).getPrice();
                    }


                    int sizeTillNow = 0;
                    System.out.println("These are your order Details: ");
                    for (int i = sizeTillNow; i < orderIndices.size(); i++) {
                            FoodItem item = foodList.get(orderIndices.get(i)-1);
                        System.out.println(i+1 + ". "+ item.getName() + " "+ item.getPrice() + " "+item.getDescription());
                    }
                    sizeTillNow = orderIndices.size();

                    System.out.println("Do you want to order something else:    1. Yes     2.No");
                    int wantToOrder = Integer.parseInt(sc.nextLine());
                    if(wantToOrder==2){
                        System.out.println("This is your total bill:"+payableAmount);

                        System.out.println("These are your order Details : ");
                        for (int i = 0; i < orderIndices.size(); i++) {
                        FoodItem item = foodList.get(orderIndices.get(i)-1);
                        System.out.println(i+1 + ". "+ item.getName() + " "+ item.getPrice() + " "+item.getDescription());
                        }
                        System.out.println("Thank You");
                        break;

                    }
                }

            } else {
                System.out.println("Thank you!!");
                break;
            }
        } while (true);


    }
}