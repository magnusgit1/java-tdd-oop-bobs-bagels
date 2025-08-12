package com.booleanuk.core;

import com.booleanuk.core.Item.Bagel.*;
import com.booleanuk.core.Item.Filling.*;
import com.booleanuk.core.Item.Coffee.*;
import com.booleanuk.core.Person.Customer;
import com.booleanuk.core.Person.Manager;
import com.booleanuk.core.Person.Member;
import com.booleanuk.core.Person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.booleanuk.core.Item.Bagel.BagelType.*;
import static com.booleanuk.core.Item.Filling.FillingType.*;
import static com.booleanuk.core.Item.Coffee.CoffeeType.*;

public class BobsBagelTests {

    @Test
    public void testBagel(){
        Bagel bagelOnion = new Bagel(ONION);
        Bagel bagelPlain = new Bagel(PLAIN);
        Bagel bagelEverything = new Bagel(EVERYTHING);
        Bagel bagelSesame = new Bagel(SESAME);

        Filling hamFilling = new Filling(HAM);

        // test getPrice method and addFilling

        double onionPrice = bagelOnion.getPrice();
        double plainPrice = bagelPlain.getPrice();
        double everythingPrice = bagelEverything.getPrice();
        double sesamePrice = bagelSesame.getPrice();

        bagelOnion.addFilling(hamFilling);

        Assertions.assertEquals(0.49, onionPrice);
        Assertions.assertEquals(0.39, plainPrice);
        Assertions.assertEquals(0.49, everythingPrice);
        Assertions.assertEquals(0.49, sesamePrice);


        Assertions.assertEquals(hamFilling, bagelOnion.getFilling().getFirst());
    }

    @Test
    public void testFilling(){

        Filling fillingBacon = new Filling(BACON);
        Filling fillingEgg = new Filling(EGG);
        Filling fillingCheese = new Filling(CHEESE);
        Filling fillingCreamCheese = new Filling(CREAM_CHEESE);
        Filling fillingSmokedSalmon = new Filling(SMOKED_SALMON);
        Filling fillingHam = new Filling(HAM);

        // test getPrice method

        double baconPrice = fillingBacon.getPrice();
        double eggPrice = fillingEgg.getPrice();
        double cheesePrice = fillingCheese.getPrice();
        double creamCheesePrice = fillingCreamCheese.getPrice();
        double smokedSalmonPrice = fillingSmokedSalmon.getPrice();
        double hamPrice = fillingHam.getPrice();


        Assertions.assertEquals(0.12, baconPrice);
        Assertions.assertEquals(0.12, eggPrice);
        Assertions.assertEquals(0.12, cheesePrice);
        Assertions.assertEquals(0.12, creamCheesePrice);
        Assertions.assertEquals(0.12, smokedSalmonPrice);
        Assertions.assertEquals(0.12, hamPrice);
    }

    @Test
    public void testCoffee(){

        Coffee coffeeBlack = new Coffee(BLACK);
        Coffee coffeeWhite = new Coffee(WHITE);
        Coffee coffeeCappuccino = new Coffee(CAPPUCCINO);
        Coffee coffeeLatte = new Coffee(LATTE);

        // test getPrice method

        double blackPrice = coffeeBlack.getPrice();
        double whitePrice = coffeeWhite.getPrice();
        double cappuccinoPrice = coffeeCappuccino.getPrice();
        double lattePrice = coffeeLatte.getPrice();


        Assertions.assertEquals(0.99, blackPrice);
        Assertions.assertEquals(1.19, whitePrice);
        Assertions.assertEquals(1.29, cappuccinoPrice);
        Assertions.assertEquals(1.29, lattePrice);

    }

    @Test
    public void testItem(){

        // Testing the Item interface

        Bagel itemBagel = new Bagel(ONION);
        Filling itemFilling = new Filling(HAM);

        itemBagel.addFilling(itemFilling);

        Assertions.assertEquals(0.49, itemBagel.getPrice());
        Assertions.assertEquals(itemFilling, itemBagel.getFilling().getFirst());

    }

    @Test
    public void testInventory(){

        HashMap<String, Integer> mapOfItems = new HashMap<>(){{
            put(PLAIN.toString(), 5);
            put(ONION.toString(), 5);
            put(EVERYTHING.toString(), 4);
            put(BACON.toString(), 7);
            put(CHEESE.toString(), 1);
            put(WHITE.toString(), 3);
            put(LATTE.toString(), 2);
            put(HAM.toString(), 4);
        }};

        Bagel bagel1 = new Bagel(SESAME);

        Inventory inventory = new Inventory(mapOfItems);

        Bagel bagel2 = new Bagel(PLAIN);
        Filling filling = new Filling(HAM);
        Coffee coffee = new Coffee(WHITE);

        Assertions.assertTrue(inventory.exists(bagel2));
        Assertions.assertFalse(inventory.reduceCount(bagel1));
        Assertions.assertEquals(5, inventory.mapOfItems.get(PLAIN.toString()));
        Assertions.assertTrue(inventory.exists(filling));
        Assertions.assertTrue(inventory.exists(coffee));
    }

    @Test
    public void testBasket(){

        HashMap<String, Integer> mapOfItems = new HashMap<>(){{
            put(PLAIN.toString(), 5);
            put(ONION.toString(), 5);
            put(EVERYTHING.toString(), 4);
            put(BACON.toString(), 7);
            put(HAM.toString(), 3);
            put(CHEESE.toString(), 1);
            put(WHITE.toString(), 3);
            put(LATTE.toString(), 2);
        }};

        Inventory inventory = new Inventory(mapOfItems);

        BasketCapacity basketCapacity = new BasketCapacity(10);

        Basket basket = new Basket(basketCapacity.getCapacity(), inventory);

        Bagel bagelOnion = new Bagel(ONION);
        Bagel bagelPlain = new Bagel(PLAIN);
        Filling fillingCheese = new Filling(CHEESE);
        Filling fillingHam = new Filling(HAM);

        basket.add(bagelPlain);
        basket.add(bagelOnion);
        basket.add(fillingCheese);
        basket.add(fillingHam);

        double expectedSum = bagelPlain.getPrice() + bagelOnion.getPrice() + fillingCheese.getPrice() + fillingHam.getPrice();

        Assertions.assertFalse(basket.isFull());
        Assertions.assertEquals(expectedSum, basket.total());
        Assertions.assertTrue(basket.add(bagelOnion));
        Assertions.assertEquals(4, inventory.mapOfItems.get(PLAIN.toString()));

        basket.remove(bagelPlain);

        Assertions.assertEquals(5, inventory.mapOfItems.get(PLAIN.toString()));
        Assertions.assertFalse(basket.remove(bagelPlain));

    }

    @Test
    public void testPerson(){

        Person person1 = new Person("Odd");
        Person person2 = new Person("Jimmy");

        Assertions.assertEquals("Odd", person1.getName());
        Assertions.assertNotEquals("jim", person2.getName());
    }

    @Test
    public void testMember(){

        HashMap<String, Integer> mapOfItems = new HashMap<>(){{
            put(PLAIN.toString(), 5);
            put(ONION.toString(), 5);
            put(EVERYTHING.toString(), 4);
            put(BACON.toString(), 7);
            put(HAM.toString(), 3);
            put(CHEESE.toString(), 1);
            put(WHITE.toString(), 3);
            put(LATTE.toString(), 2);
        }};

        Inventory inventory = new Inventory(mapOfItems);

        BasketCapacity basketCapacity = new BasketCapacity(1);

        Basket basket = new Basket(basketCapacity.getCapacity(), inventory);
        Basket basket2 = new Basket(basketCapacity.getCapacity(), inventory);

        Member member1 = new Member("Cody", 5, basket);
        Member member2 = new Member("Bob", 6, basket2);

        Bagel bagel = new Bagel(ONION);

        Assertions.assertTrue(member1.addItemToBasket(bagel));
        Assertions.assertFalse(member1.addItemToBasket(bagel));
        Assertions.assertTrue(member2.addItemToBasket(bagel));
        Assertions.assertTrue(member2.removeItemFromBasket(bagel));
        Assertions.assertEquals("Cody", member1.getName());
        Assertions.assertEquals(5, member1.getMemberId());
    }

    @Test
    public void testCustomer(){

        HashMap<String, Integer> mapOfItems = new HashMap<>(){{
            put(PLAIN.toString(), 5);
            put(ONION.toString(), 5);
            put(EVERYTHING.toString(), 4);
            put(BACON.toString(), 7);
            put(HAM.toString(), 3);
            put(CHEESE.toString(), 1);
            put(WHITE.toString(), 3);
            put(LATTE.toString(), 2);
        }};

        Inventory inventory = new Inventory(mapOfItems);

        BasketCapacity basketCapacity = new BasketCapacity(1);

        Basket basket = new Basket(basketCapacity.getCapacity(), inventory);
        Basket basket2 = new Basket(basketCapacity.getCapacity(), inventory);

        Customer customer1 = new Customer("Ray", 10, basket, 19);
        Customer customer2 = new Customer("Bob", 5, basket2, 21);

        Bagel bagel = new Bagel(ONION);
        Filling filling = new Filling(HAM);

        customer1.chooseFillingForBagel(bagel, filling);

        Assertions.assertEquals(1, bagel.getFilling().size());

        Assertions.assertTrue(customer1.addItemToBasket(bagel));
        Assertions.assertEquals(0.49, customer1.getPriceOfItem(bagel));
        Assertions.assertEquals(0.49, customer1.totalCost());
        Assertions.assertFalse(customer1.addItemToBasket(bagel));
        Assertions.assertTrue(customer2.addItemToBasket(bagel));
        Assertions.assertTrue(customer2.removeItemFromBasket(bagel));
        Assertions.assertEquals("Ray", customer1.getName());
        Assertions.assertEquals(10, customer1.getMemberId());
        Assertions.assertEquals(21, customer2.getCustomerId());
    }

    @Test
    public void testManager(){

        Manager manager = new Manager("Johnny");
        BasketCapacity basketCapacity = new BasketCapacity(10);

        manager.changeBasketCapacity(basketCapacity, 12);

        Assertions.assertEquals(12, basketCapacity.basketCapacity);
        Assertions.assertFalse(manager.changeBasketCapacity(basketCapacity, 12));

    }
}
