package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

    Item imported_book = new Item(ItemType.BOOK, new Price(8.79)).setImported(true);
    Item chocolate = new Item(ItemType.FOOD, new Price(1.99));
    Item cd = new Item(ItemType.MUSIC_CD, new Price(13.49)).setImported(true);

    Order order = new Order();

    BasicTax basicTax = new BasicTax(BasicTax.DEFAULT_BASIC_TAX_RATE)
                    .addExemption(ItemType.FOOD)
                    .addExemption(ItemType.BOOK)
                    .addExemption(ItemType.MEDICAL);
    ImportTax importTax = new ImportTax(ImportTax.DEFAULT_IMPORT_TAX_RATE);

    @Before
    public void before() {
        order.addItem(imported_book);
        order.addItem(chocolate);
        order.addItem(cd);

        order.addTax(basicTax);
        order.addTax(importTax);
    }

    @Test
    public void orderSize() {
        Assert.assertEquals(3, order.size());
    }

    @Test
    public void calculateTaxForSingleItem() {
        Price tax;

        tax = order.calculateTaxForItem(imported_book);
        Assert.assertEquals(new Price(0.45), tax);

        tax = order.calculateTaxForItem(chocolate);
        Assert.assertEquals(new Price(0), tax);

        tax = order.calculateTaxForItem(cd);
        Assert.assertEquals(new Price(2.05), tax);
    }

    @Test
    public void calculateTotalPriceForSingleItem() {
        Price price;

        price = order.calculateTotalPriceForItem(imported_book);
        Assert.assertEquals(new Price(9.24), price);

        price = order.calculateTotalPriceForItem(chocolate);
        Assert.assertEquals(new Price(1.99), price);

        price = order.calculateTotalPriceForItem(cd);
        Assert.assertEquals(new Price(15.54), price);
    }

    @Test
    public void calculateTotalSalesTaxes() {
        Price tax = order.calculateTotalSalesTaxes();
        Assert.assertEquals(new Price(2.50), tax);
    }

    @Test
    public void calculateTotalOrderPrice() {
        Price price = order.calculateTotalOrderPrice();
        Assert.assertEquals(new Price(26.77), price);
    }
}
