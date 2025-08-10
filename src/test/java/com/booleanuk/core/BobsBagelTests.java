package com.booleanuk.core;

import com.booleanuk.core.Bagel.Bagel;
import com.booleanuk.core.Coffee.Coffee;
import com.booleanuk.core.Filling.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.booleanuk.core.Bagel.BagelType.*;
import static com.booleanuk.core.Coffee.CoffeeType.*;
import static com.booleanuk.core.Filling.FillingType.*;

public class BobsBagelTests {

    @Test
    public void testBagel(){
        Bagel bagelOnion = new Bagel(ONION);
        Bagel bagelPlain = new Bagel(PLAIN);
        Bagel bagelEverything = new Bagel(EVERYTHING);
        Bagel bagelSesame = new Bagel(SESAME);

        // test getPrice methods

        double onionPrice = bagelOnion.getPrice();
        double plainPrice = bagelPlain.getPrice();
        double everythingPrice = bagelEverything.getPrice();
        double sesamePrice = bagelSesame.getPrice();

        Assertions.assertEquals(0.49, onionPrice);
        Assertions.assertEquals(0.39, plainPrice);
        Assertions.assertEquals(0.49, everythingPrice);
        Assertions.assertEquals(0.49, sesamePrice);
    }

    @Test
    public void testFilling(){

        Filling fillingBacon = new Filling(BACON);
        Filling fillingEgg = new Filling(EGG);
        Filling fillingCheese = new Filling(CHEESE);
        Filling fillingCreamCheese = new Filling(CREAM_CHEESE);
        Filling fillingSmokedSalmon = new Filling(SMOKED_SALMON);
        Filling fillingHam = new Filling(HAM);

        // test getPrice methods

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

        // test getPrice methods

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

    }

    @Test
    public void testBasket(){

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

    @Test
    public void testInventory(){

    }
}
