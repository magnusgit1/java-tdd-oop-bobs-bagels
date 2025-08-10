package com.booleanuk.core;

import com.booleanuk.core.Bagel.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.booleanuk.core.Bagel.BagelType.*;

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

    }

    @Test
    public void testCoffee(){

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
