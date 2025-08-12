package com.booleanuk.core;
import com.booleanuk.core.Item.Item;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {
    private final int capacity;
    private final List<Item> items;
    private final Inventory inventory;

    public Basket(int capacity, Inventory inventory){
        this.capacity = capacity;
        this.items = new ArrayList<>();
        this.inventory = inventory;
    }

    public boolean add(Item item){
        if (!inventory.exists(item)){
            System.out.println("The item is out of stock!");
            return false;
        } else if (isFull()){
            System.out.println("The basket is full!");
            return false;
        } else {
            items.add(item);
            inventory.reduceCount(item);
            return true;
        }
    }

    public boolean remove(Item item){
        if (items.contains(item)){
            items.remove(item);
            inventory.increaseCount(item);
            return true;
        } else {
            System.out.println("This item does not exist in your basket!");
            return false;
        }
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public double total(){
        return items.stream().map(Item::getPrice).reduce(0.0, Double::sum) - findDiscount();
    }

    public double findDiscount(){
        double totalDiscount = 0.0;

        int bagelsPlainCount = Math.toIntExact(items.stream().filter(item -> item.getSku().equals("BGLP")).count());
        int bagelsNotPlainCount = Math.toIntExact(items.stream().filter(item -> !item.getSku().equals("BGLP")).count());
        int coffeeBlackCoffeeCount = Math.toIntExact(items.stream().filter(item -> item.getSku().equals("COFB")).count());
        if (bagelsPlainCount >= 12) {
            // adding the difference between normal price of 6 plain bagels vs discounted price
            totalDiscount += 0.69;
        }
        if (bagelsNotPlainCount >= 6){
            totalDiscount += 0.45;
        }
        if (bagelsPlainCount > 0 && coffeeBlackCoffeeCount > 0){
            totalDiscount += 0.13;
        } else if (bagelsNotPlainCount > 0 && coffeeBlackCoffeeCount > 0){
            totalDiscount += 0.23;
        }
        return totalDiscount;
    }

    public void printReceipt(){
        // A little bit messy, but I didn't want to rewrite the other parts of the code
        // to be able to simplify this one, but it works.
        // There is definitely a better way to structure the print-statements,
        // but I figured that weren't the main objective of the task anyway.

        HashMap<String, Integer> res = new HashMap<>();
        for (Item item : items){
            res.put(item.getType(), res.getOrDefault(item.getType(), 0) + 1);
        }
        LocalDateTime currentDateTime = LocalDateTime.now();

        String firstPart =
                "\n\n       ~~~ Bob's Bagels ~~~\n\n   " + currentDateTime + "\n\n" +
                "-------------------------------------" + "\n";

        System.out.println(firstPart);
        res.forEach((key,val) -> {
            double price = items.stream().filter(itm -> itm.getType().equals(key)).toList().getFirst().getPrice()*val;
            System.out.println(key +  "               " +  "  " + val + "         £"  + price);
        });
        String lastPart =
                "-------------------------------------" + "\n" +
                "Sum                           £" + String.format("%.2f", total()+findDiscount()) + "\n" +
                "Discount                    (-£" + String.format("%.2f", findDiscount()) +  ")\n"  +
                "Total                         £" + String.format("%.2f", total()) +
                "\n\nYou saved a total of:          £" + String.format("%.2f", findDiscount()) +
                "\n\n            Thank you \n         for your order!\n\n";

        System.out.println(lastPart);
    }
}
