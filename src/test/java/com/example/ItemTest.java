package com.example;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void test() {

        Item book = new Item(ItemType.BOOK, new Price(10));

        Assert.assertNotNull(book);
        Assert.assertEquals(ItemType.BOOK, book.getType());
        Assert.assertNotEquals(ItemType.FOOD, book.getType());
        Assert.assertEquals(new Price(10), book.getPrice());
        Assert.assertNotEquals(new Price(10.00999), book.getPrice());
        Assert.assertFalse(book.isImported());

        book.setImported(true);
        Assert.assertTrue(book.isImported());

    }
}
