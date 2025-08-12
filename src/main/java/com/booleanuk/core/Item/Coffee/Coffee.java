package com.booleanuk.core.Item.Coffee;


import com.booleanuk.core.Item.Item;

public class Coffee implements Item {
    private final double price;
    private final String type;
    private final String sku;

    public Coffee(CoffeeType type){
        this.price = switch(type){
            case BLACK -> 0.99;
            case WHITE -> 1.19;
            default -> 1.29;
        };
        this.type = type.toString();
        this.sku = switch(type){
            case BLACK -> "COFB";
            case WHITE -> "COFW";
            case CAPPUCCINO -> "COFC";
            case LATTE -> "COFL";
        };
    }

    public String getSku(){
        return this.sku;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public String getType(){
        return this.type;
    }
}
