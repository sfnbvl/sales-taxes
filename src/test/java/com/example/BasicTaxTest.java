package com.example;

import org.junit.Assert;
import org.junit.Test;

public class BasicTaxTest {

    Tax tax = new BasicTax()
        .addExemption(ItemType.FOOD)
        .addExemption(ItemType.BOOK)
        .addExemption(ItemType.MEDICAL);

    @Test
    public void test() {
        Price p;
        p = tax.apply(new Item(ItemType.MUSIC_CD, new Price(15)));
        Assert.assertEquals(new Price(1.50), p);

        p = tax.apply(new Item(ItemType.FOOD, new Price(5)));
        Assert.assertEquals(new Price(0), p);

        p = tax.apply(new Item(ItemType.MEDICAL, new Price(10)));
        Assert.assertEquals(new Price(0), p);
    }

}
