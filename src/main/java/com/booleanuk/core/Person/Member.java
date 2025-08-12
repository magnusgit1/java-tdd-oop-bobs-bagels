package com.booleanuk.core.Person;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Item.Bagel.Bagel;
import com.booleanuk.core.Item.Filling.Filling;
import com.booleanuk.core.Item.Item;

public class Member extends Person{
    private final int id;
    private final Basket basket;

    public Member(String name, int id, Basket basket) {
        super(name);
        this.id = id;
        this.basket = basket;
    }

    public int getMemberId(){
        return this.id;
    }

    public boolean addItemToBasket(Item item){
        return basket.add(item);
    }

    public boolean removeItemFromBasket(Item item){
        return basket.remove(item);
    }

    public double totalCost(){
        return basket.total();
    }

    public double getPriceOfItem(Item item){
        return item.getPrice();
    }

    public void chooseFillingForBagel(Bagel bagel, Filling filling){
        bagel.addFilling(filling);
    }

    public void printReceiptFromBasket(){
        basket.printReceipt();
    }
}
