package com.example;

public class Item {

    private ItemType type;

    private String description;

    private Price price;

    private boolean imported = false;

    public Item(ItemType type, Price price) {
        this.type = type;
        this.price = price;
    }

    public Item(ItemType type, String description, Price price) {
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public ItemType getType() {
        return this.type;
    }

    public Item setType(ItemType type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public Price getPrice() {
        return this.price;
    }

    public Item setPrice(Price price) {
        this.price = price;
        return this;
    }

    public boolean isImported() {
        return imported;
    }

    public Item setImported(boolean imported) {
        this.imported = imported;
        return this;
    }
}
