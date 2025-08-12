package com.booleanuk.core.Item.Bagel;
import com.booleanuk.core.Item.Filling.Filling;
import com.booleanuk.core.Item.Item;
import java.util.ArrayList;
import java.util.List;

public class Bagel implements Item {
    private final List<Filling> filling;
    private final double price;
    private final String type;
    private final String sku;

    public Bagel(BagelType type){
        this.price = type.equals(BagelType.PLAIN)? 0.39 : 0.49;
        filling = new ArrayList<>();
        this.type = type.toString();
        this.sku = switch(type){
            case PLAIN -> "BGLP";
            case ONION -> "BGLO";
            case EVERYTHING -> "BGLE";
            case SESAME -> "BGLS";
        };
    }

    public String getSku(){
        return this.sku;
    }

    public double getPrice(){
        return this.price;
    }

    public String getType(){
        return this.type;
    }

    public List<Filling> getFilling(){
        return this.filling;
    }

    public void addFilling(Filling filling){
        this.filling.add(filling);
    }
}
