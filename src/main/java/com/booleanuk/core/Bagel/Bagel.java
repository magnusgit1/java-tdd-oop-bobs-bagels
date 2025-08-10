package com.booleanuk.core.Bagel;

import com.booleanuk.core.Filling.Filling;

import java.util.ArrayList;
import java.util.List;

public class Bagel {
    List<Filling> filling;
    BagelType type;
    double price;

    public Bagel(BagelType type){
        this.type = type;
        this.price = type.equals(BagelType.PLAIN)? 0.39 : 0.49;
        filling = new ArrayList<>();
    }

    public double getPrice(){
        return this.price;
    }

    public List<Filling> getFilling(){
        return this.filling;
    }

    public void addFilling(Filling filling){
        this.filling.add(filling);
    }

}
