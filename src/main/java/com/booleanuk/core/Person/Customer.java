package com.booleanuk.core.Person;

import com.booleanuk.core.Basket;

public class Customer extends Member{
    private final int customerId;
    public Customer(String name, int id, Basket basket, int customerId) {
        super(name, id, basket);
        this.customerId = customerId;
    }

    public int getCustomerId(){
        return this.customerId;
    }
}
