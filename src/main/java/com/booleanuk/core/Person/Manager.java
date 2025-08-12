package com.booleanuk.core.Person;
import com.booleanuk.core.BasketCapacity;

public class Manager extends Person{

    public Manager(String name) {
        super(name);
    }

    public boolean changeBasketCapacity(BasketCapacity basketCapacity, int capacity){
        return basketCapacity.setCapacity(capacity);
    }
}
