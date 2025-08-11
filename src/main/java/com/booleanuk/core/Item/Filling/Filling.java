package com.booleanuk.core.Item.Filling;

import com.booleanuk.core.Item.Item;

public class Filling implements Item<FillingType> {
    private final double price;
    private final FillingType type;

    public Filling(FillingType type){
        this.price = 0.12;
        this.type = type;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public FillingType getType(){
        return this.type;
    }
}
