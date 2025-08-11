package com.booleanuk.core;

public class BasketCapacity {
    public int basketCapacity;

    public BasketCapacity(int capacity){
        this.basketCapacity = capacity;
    }

    public int getCapacity(){
        return this.basketCapacity;
    }

    public boolean setCapacity(int capacity){
        if (capacity != this.basketCapacity){
            this.basketCapacity = capacity;
            return true;
        } else {
            return false;
        }
    }
}
