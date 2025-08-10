package com.booleanuk.core.Filling;

public class Filling {
    FillingType type;
    double price;

    public Filling(FillingType type){
        this.type = type;
        this.price = 0.12;
    }

    public double getPrice(){
        return this.price;
    }

}
