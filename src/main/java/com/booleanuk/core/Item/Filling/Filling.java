package com.booleanuk.core.Item.Filling;

import com.booleanuk.core.Item.Item;

public class Filling implements Item {
    private final double price;
    private final String type;

    public Filling(FillingType type){
        this.price = 0.12;
        this.type = type.toString();
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public String getType(){
        return this.type;
    }
}
