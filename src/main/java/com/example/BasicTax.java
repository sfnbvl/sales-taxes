package com.example;

import java.util.HashSet;
import java.util.Set;

public class BasicTax extends Tax {

    public static int DEFAULT_BASIC_TAX_RATE = 10;

    private Set<ItemType> exemptions;

    public BasicTax() {
        exemptions = new HashSet<ItemType>();
        rate = DEFAULT_BASIC_TAX_RATE;
    }

    public BasicTax(int rate) {
        exemptions = new HashSet<ItemType>();
        this.rate = rate;
    }

    public BasicTax addExemption(ItemType type) {
        this.exemptions.add(type);
        return this;
    }

    public Price apply(Item item) {
        if(exemptions.contains(item.getType())) {
            return new Price(0);
        } else {
            return Tax.round(item.getPrice().multiply(rate * 0.01));
        }
    }

}
