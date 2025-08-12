package com.booleanuk.core;

import com.booleanuk.core.Item.Item;

import java.util.ArrayList;
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
        if (inventory.exists(item) && !isFull()){
            items.add(item);
            inventory.reduceCount(item);
            return true;
        } else { return false; }
    }

    public boolean remove(Item item){
        if (items.contains(item)){
            items.remove(item);
            inventory.increaseCount(item);
            return true;
        } else { return false; }
    }

    public boolean isFull() {
        return items.size() == capacity;

    }

    public double total(){
        return items.stream().map(Item::getPrice).reduce(0.0, Double::sum);
    }
}
