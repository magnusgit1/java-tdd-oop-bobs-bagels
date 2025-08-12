package com.booleanuk.core;
import com.booleanuk.core.Item.Item;
import java.util.HashMap;

public class Inventory {
    HashMap<String, Integer> mapOfItems;

    public Inventory(HashMap<String, Integer> mapOfItems){
        this.mapOfItems = mapOfItems;
    }

    public void increaseCount(Item item){
        mapOfItems.put(item.getType(), mapOfItems.getOrDefault(item.getType(), 0) + 1);
    }

    public boolean reduceCount(Item item){
        if (!mapOfItems.containsKey(item.getType())){
            return false;
        } else {
            if (mapOfItems.get(item.getType()) < 1) {
                return false;
            }
            else {
                mapOfItems.put(item.getType(), mapOfItems.getOrDefault(item.getType(), 0) - 1);
                return true;
            }
        }
    }

    public boolean exists(Item item){
        return mapOfItems.containsKey(item.getType()) && mapOfItems.get(item.getType()) > 0;
    }
}
