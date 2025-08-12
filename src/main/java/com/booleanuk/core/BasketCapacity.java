package com.booleanuk.core;

// Basically the class I used as a "global" variable to be used as the capacity
// values of baskets once they're created. The logic is that every basket that is already
// in use by the time this value changes, will remain at the previous capacity-value,
// while new baskets will receive the updated capacity-value, which made sense to me.

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
