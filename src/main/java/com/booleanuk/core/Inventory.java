package com.booleanuk.core;

import com.booleanuk.core.Item.Bagel.BagelType;
import com.booleanuk.core.Item.Coffee.CoffeeType;
import com.booleanuk.core.Item.Filling.FillingType;
import com.booleanuk.core.Item.Item;

import java.util.List;

public class Inventory {
    List<BagelType> listOfBagels;
    List<FillingType> listOfFillings;
    List<CoffeeType> listOfCoffees;

    public Inventory(List<BagelType> bagels, List<FillingType> fillings, List<CoffeeType> coffees){
        this.listOfBagels = bagels;
        this.listOfFillings = fillings;
        this.listOfCoffees = coffees;
    }

    public boolean exists(Item item){
        return listOfBagels.contains(item.getType()) || listOfFillings.contains(item.getType()) || listOfCoffees.contains(item.getType());
    }
}
