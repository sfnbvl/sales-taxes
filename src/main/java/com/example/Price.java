package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Price {

    private BigDecimal value;

    public Price(BigDecimal value) {
        this.value = value.setScale(2, RoundingMode.HALF_UP);
    }

    public Price(double value) {
        this.value = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
    }

    public Price add(Price price) {
        return new Price(price.value.add(value));
    }

    public Price multiply(double multiplier) {
        return new Price(value.multiply(new BigDecimal(multiplier)));
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Price) {
            Price price = (Price)obj;
            return price.value.compareTo(this.value) == 0;
        }
        return false;
    }

    public Price round(RoundingMode roundingMode) {
        return new Price(value.setScale(0, roundingMode));
    }
}
