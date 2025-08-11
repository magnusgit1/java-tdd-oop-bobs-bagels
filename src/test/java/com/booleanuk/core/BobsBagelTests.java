package com.booleanuk.core;

import com.booleanuk.core.Item.Bagel.*;
import com.booleanuk.core.Item.Filling.*;
import com.booleanuk.core.Item.Coffee.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        List<BagelType> listOfBagels = new ArrayList<>(Arrays.asList(PLAIN, ONION, EVERYTHING, SESAME));
        List<FillingType> listOfFillings = new ArrayList<>(Arrays.asList(BACON, EGG, CHEESE, CREAM_CHEESE, SMOKED_SALMON, HAM));
        List<CoffeeType> listOfCoffees = new ArrayList<>(Arrays.asList(BLACK, WHITE, CAPPUCCINO, LATTE));

        Inventory inventory = new Inventory(listOfBagels, listOfFillings, listOfCoffees);

        Bagel bagel = new Bagel(PLAIN);
        Filling filling = new Filling(HAM);
        Coffee coffee = new Coffee(WHITE);

        Assertions.assertTrue(inventory.exists(bagel));
        Assertions.assertTrue(inventory.exists(filling));
        Assertions.assertTrue(inventory.exists(coffee));
    }

    @Test
    public void testBasket(){

        List<BagelType> listOfBagels = new ArrayList<>(Arrays.asList(PLAIN, ONION, EVERYTHING, SESAME));
        List<FillingType> listOfFillings = new ArrayList<>(Arrays.asList(BACON, EGG, CHEESE, CREAM_CHEESE, SMOKED_SALMON, HAM));
        List<CoffeeType> listOfCoffees = new ArrayList<>(Arrays.asList(BLACK, WHITE, CAPPUCCINO, LATTE));

        Inventory inventory = new Inventory(listOfBagels, listOfFillings, listOfCoffees);

        Basket basket = new Basket(10, inventory);

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

        basket.remove(bagelPlain);

        Assertions.assertFalse(basket.remove(bagelPlain));

    }

    @Test
    public void testPerson(){

    }

    @Test
    public void testMember(){

    }

    @Test
    public void testCustomer(){

    }

    @Test
    public void testManager(){

    }
}
