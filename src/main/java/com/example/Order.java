package com.example;

import java.util.LinkedList;
import java.util.List;

public class Order {

    private List<Item> items = new LinkedList<Item>();

    private List<Tax> taxes = new LinkedList<Tax>();

    public Order addItem(Item item) {
        items.add(item);
        return this;
    }

    public Order addTax(Tax tax) {
        taxes.add(tax);
        return this;
    }

    public int size() {
        return items.size();
    }

    public Price calculateTaxForItem(Item item) {
        Price price = new Price(0);
        for(Tax tax : taxes) {
            price = price.add(tax.apply(item));
        }
        return price;
    }

    public Price calculateTotalPriceForItem(Item item) {
        return item.getPrice().add(calculateTaxForItem(item));
    }

    public Price calculateTotalSalesTaxes() {
        Price tax = new Price(0);
        for(Item item : items) {
            tax = tax.add(calculateTaxForItem(item));
        }
        return tax;
    }

    public Price calculateTotalOrderPrice() {
        Price price = new Price(0);
        for(Item item : items) {
            price = price.add(calculateTotalPriceForItem(item));
        }
        return price;
    }

    public void printReceipt() {
        for(Item item : items) {
            System.out.println("1 " + item.getDescription() + ": " + calculateTotalPriceForItem(item));
        }
        System.out.println("Sales Taxes: " + calculateTotalSalesTaxes());
        System.out.println("Total: " + calculateTotalOrderPrice());
    }
}