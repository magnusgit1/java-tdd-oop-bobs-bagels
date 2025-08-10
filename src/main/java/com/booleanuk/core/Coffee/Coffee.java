package com.booleanuk.core.Coffee;


public class Coffee {
    CoffeeType type;
    double price;

    public Coffee(CoffeeType type){
        this.type = type;
        this.price = switch(type){
            case BLACK -> 0.99;
            case WHITE -> 1.19;
            default -> 1.29;
        };
    }

    public double getPrice(){
        return this.price;
    }
}
