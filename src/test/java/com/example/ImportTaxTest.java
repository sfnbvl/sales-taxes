package com.example;

import org.junit.Assert;
import org.junit.Test;

public class ImportTaxTest {

    Tax tax = new ImportTax(5);

    @Test
    public void test() {
        Price p;
        p = tax.apply(new Item(ItemType.MUSIC_CD, new Price(15)).setImported(true));
        Assert.assertEquals(new Price(0.75), p);

        p = tax.apply(new Item(ItemType.FOOD, new Price(5)).setImported(false));
        Assert.assertEquals(new Price(0), p);

        p = tax.apply(new Item(ItemType.MEDICAL, new Price(10)).setImported(true));
        Assert.assertEquals(new Price(0.5), p);
    }

}
