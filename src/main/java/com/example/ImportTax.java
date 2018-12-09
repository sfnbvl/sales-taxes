package com.example;

public class ImportTax extends Tax {

    public static int DEFAULT_IMPORT_TAX_RATE = 5;

    public ImportTax() {
        this.rate = DEFAULT_IMPORT_TAX_RATE;
    }

    public ImportTax(int rate) {
        this.rate = rate;
    }

    public Price apply(Item item) {
        if(item.isImported()) {
            return Tax.round(item.getPrice().multiply(rate * 0.01));
        } else {
            return new Price(0);
        }
    }
}
