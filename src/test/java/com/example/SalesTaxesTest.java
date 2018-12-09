package com.example;

import org.junit.Assert;
import org.junit.Test;

public class SalesTaxesTest {

    Order order = new Order()
            .addTax(new BasicTax(BasicTax.DEFAULT_BASIC_TAX_RATE)
                    .addExemption(ItemType.FOOD)
                    .addExemption(ItemType.BOOK)
                    .addExemption(ItemType.MEDICAL))
            .addTax(new ImportTax(ImportTax.DEFAULT_IMPORT_TAX_RATE));

    @Test
    public void test1() {
        System.out.println("Test 1");

        Item book = new Item(ItemType.BOOK, "book", new Price(12.49));
        Item musicCD = new Item(ItemType.MUSIC_CD, "music CD", new Price(14.99));
        Item chocolateBar = new Item(ItemType.FOOD, "chocolate bar", new Price(0.85));

        Assert.assertEquals(new Price(12.49), order.calculateTotalPriceForItem(book));
        Assert.assertEquals(new Price(16.49), order.calculateTotalPriceForItem(musicCD));
        Assert.assertEquals(new Price(0.85), order.calculateTotalPriceForItem(chocolateBar));

        order.addItem(book);
        order.addItem(musicCD);
        order.addItem(chocolateBar);

        Assert.assertEquals(new Price(1.50), order.calculateTotalSalesTaxes());
        Assert.assertEquals(new Price(29.83), order.calculateTotalOrderPrice());

        order.printReceipt();
        System.out.println();
    }

    @Test
    public void test2() {
        System.out.println("Test 2");

        Item importedChocolatesBox = new Item(ItemType.FOOD, "imported box of chocolates", new Price(10.00)).setImported(true);
        Item importedPerfumeBottle = new Item(ItemType.COSMETICS, "imported bottle of perfume", new Price(47.50)).setImported(true);

        Assert.assertEquals(new Price(10.50), order.calculateTotalPriceForItem(importedChocolatesBox));
        Assert.assertEquals(new Price(54.65), order.calculateTotalPriceForItem(importedPerfumeBottle));

        order.addItem(importedChocolatesBox);
        order.addItem(importedPerfumeBottle);

        Assert.assertEquals(new Price(7.65), order.calculateTotalSalesTaxes());
        Assert.assertEquals(new Price(65.15), order.calculateTotalOrderPrice());

        order.printReceipt();
        System.out.println();
    }

    @Test
    public void test3() {
        System.out.println("Test 3");

        Item importedPerfumeBottle = new Item(ItemType.COSMETICS, "imported bottle of perfume", new Price(27.99)).setImported(true);
        Item perfumeBottle = new Item(ItemType.COSMETICS, "bottle of perfume", new Price(18.99));
        Item headachePills = new Item(ItemType.MEDICAL, "packet of headache pills", new Price(9.75));
        Item importedChocolatesBox = new Item(ItemType.FOOD, "imported box of chocolates", new Price(11.25)).setImported(true);

        Assert.assertEquals(new Price(32.19), order.calculateTotalPriceForItem(importedPerfumeBottle));
        Assert.assertEquals(new Price(20.89), order.calculateTotalPriceForItem(perfumeBottle));
        Assert.assertEquals(new Price(9.75), order.calculateTotalPriceForItem(headachePills));
        Assert.assertEquals(new Price(11.85), order.calculateTotalPriceForItem(importedChocolatesBox));

        order.addItem(importedPerfumeBottle);
        order.addItem(perfumeBottle);
        order.addItem(headachePills);
        order.addItem(importedChocolatesBox);

        Assert.assertEquals(new Price(6.70), order.calculateTotalSalesTaxes());
        Assert.assertEquals(new Price(74.68), order.calculateTotalOrderPrice());

        order.printReceipt();
        System.out.println();
    }

}
