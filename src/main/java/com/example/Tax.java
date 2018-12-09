package com.example;

import java.math.RoundingMode;

public abstract class Tax {

    protected int rate;

    public abstract Price apply(Item item);

    public Tax setRate(int rate) {
        this.rate = rate;
        return this;
    }

    public static Price round(Price p) {
        p = p.multiply(20)
             .round(RoundingMode.UP)
             .multiply(0.05);
        return p;
    }

}
