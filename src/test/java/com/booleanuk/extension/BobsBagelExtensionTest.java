package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.BasketCapacity;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.Item.Bagel.Bagel;
import com.booleanuk.core.Item.Coffee.Coffee;
import com.booleanuk.core.Item.Filling.Filling;
import com.booleanuk.core.Person.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.booleanuk.core.Item.Bagel.BagelType.EVERYTHING;
import static com.booleanuk.core.Item.Bagel.BagelType.ONION;
import static com.booleanuk.core.Item.Bagel.BagelType.PLAIN;
import static com.booleanuk.core.Item.Coffee.CoffeeType.*;
import static com.booleanuk.core.Item.Coffee.CoffeeType.WHITE;
import static com.booleanuk.core.Item.Filling.FillingType.*;

public class BobsBagelExtensionTest {
    @Test
    public void testDiscount(){

        HashMap<String, Integer> mapOfItems = new HashMap<>(){{
            put(PLAIN.toString(), 15);
            put(ONION.toString(), 20);
            put(EVERYTHING.toString(), 20);
            put(BACON.toString(), 20);
            put(HAM.toString(), 20);
            put(CHEESE.toString(), 20);
            put(BLACK.toString(), 20);
            put(WHITE.toString(), 20);
            put(LATTE.toString(), 20);
        }};

        Inventory inventory = new Inventory(mapOfItems);

        BasketCapacity basketCapacity = new BasketCapacity(15);
        Basket basket = new Basket(basketCapacity.getCapacity(), inventory);
        Customer customer = new Customer("Ray", 10, basket, 19);

        Bagel bagelPlain = new Bagel(PLAIN);
        Coffee coffeeBlack = new Coffee(BLACK);
        Filling filling = new Filling(HAM);

        for (int i=0; i < 12; i++){
            customer.addItemToBasket(bagelPlain);
        }

        double totalWithoutDiscount = bagelPlain.getPrice()*12;
        double totalWithDiscount = customer.totalCost();

        Basket basket2 = new Basket(5, inventory);

        Customer customer2 = new Customer("Bella", 11, basket2, 4);

        customer2.addItemToBasket(bagelPlain);
        customer2.addItemToBasket(filling);
        customer2.addItemToBasket(coffeeBlack);

        double totalWithoutDiscount2 = bagelPlain.getPrice() + filling.getPrice() + coffeeBlack.getPrice();
        double totalWithDiscount2 = customer2.totalCost();

        Basket basket3 = new Basket(9, inventory);
        Customer customer3 = new Customer("Sara", 24, basket3, 91);

        Bagel bagelOnion = new Bagel(ONION);

        for (int i=0;i<6;i++){
            customer3.addItemToBasket(bagelOnion);
        }
        customer3.addItemToBasket(bagelOnion);

        double totalWithoutDiscount3 = bagelOnion.getPrice()*7;
        double totalWithDiscount3 = customer3.totalCost();

        Assertions.assertNotEquals(totalWithDiscount, totalWithoutDiscount, 0.0);
        Assertions.assertEquals(0.39*12, totalWithoutDiscount);
        Assertions.assertEquals(Math.round(3.99), Math.round(totalWithDiscount));

        Assertions.assertNotEquals(totalWithDiscount2, totalWithoutDiscount2);
        Assertions.assertEquals(0.12+1.25, totalWithDiscount2);

        Assertions.assertNotEquals(totalWithDiscount3, totalWithoutDiscount3);
        Assertions.assertEquals(2.49+bagelOnion.getPrice(), totalWithDiscount3);
    }

    @Test
    public void testReceipt(){
        HashMap<String, Integer> mapOfItems = new HashMap<>(){{
            put(PLAIN.toString(), 15);
            put(ONION.toString(), 20);
            put(EVERYTHING.toString(), 20);
            put(BACON.toString(), 20);
            put(HAM.toString(), 20);
            put(CHEESE.toString(), 20);
            put(BLACK.toString(), 20);
            put(WHITE.toString(), 20);
            put(LATTE.toString(), 20);
        }};

        Inventory inventory = new Inventory(mapOfItems);

        BasketCapacity basketCapacity = new BasketCapacity(15);
        Basket basket = new Basket(basketCapacity.getCapacity(), inventory);
        Customer customer = new Customer("Ray", 10, basket, 19);

        Bagel bagel1 = new Bagel(ONION);
        Bagel bagel2 = new Bagel(PLAIN);
        Filling filling1 = new Filling(HAM);
        Filling filling2 = new Filling(CHEESE);
        Coffee coffee1 = new Coffee(BLACK);
        Coffee coffee2 = new Coffee(WHITE);

        customer.addItemToBasket(bagel1);
        customer.addItemToBasket(bagel2);
        customer.addItemToBasket(filling1);
        customer.addItemToBasket(filling2);
        customer.addItemToBasket(coffee1);
        customer.addItemToBasket(coffee2);
        customer.addItemToBasket(coffee2);
        customer.addItemToBasket(bagel1);

        customer.printReceiptFromBasket();
    }
}
