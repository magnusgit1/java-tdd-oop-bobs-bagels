package com.booleanuk.core.Item.Filling;
import com.booleanuk.core.Item.Item;

public class Filling implements Item {
    private final double price;
    private final String type;
    private final String sku;

    public Filling(FillingType type){
        this.price = 0.12;
        this.type = type.toString();
        this.sku = switch(type){
            case BACON -> "FILB";
            case EGG -> "FILE";
            case CHEESE -> "FILC";
            case CREAM_CHEESE -> "FILX";
            case SMOKED_SALMON -> "FILS";
            case HAM -> "FILH";
        };
    }

    public String getSku(){
        return this.sku;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public String getType(){
        return this.type;
    }
}
