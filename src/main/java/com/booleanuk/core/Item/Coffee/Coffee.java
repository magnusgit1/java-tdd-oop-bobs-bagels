package com.booleanuk.core.Item.Coffee;


import com.booleanuk.core.Item.Item;

public class Coffee implements Item<CoffeeType> {
    private final double price;
    private final CoffeeType type;

    public Coffee(CoffeeType type){
        this.price = switch(type){
            case BLACK -> 0.99;
            case WHITE -> 1.19;
            default -> 1.29;
        };
        this.type = type;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public CoffeeType getType(){
        return this.type;
    }
}
