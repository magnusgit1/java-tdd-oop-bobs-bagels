package com.booleanuk.core.Bagel;

public class Bagel {
    BagelType type;
    double price;

    public Bagel(BagelType type){
        this.type = type;
        this.price = type.equals(BagelType.PLAIN)? 0.39 : 0.49;
    }

    public double getPrice(){
        return this.price;
    }
}
