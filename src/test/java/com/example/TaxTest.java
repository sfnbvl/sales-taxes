package com.example;

import org.junit.Assert;
import org.junit.Test;

public class TaxTest {

    @Test
    public void test() {
        Price p;

        p = Tax.round(new Price(2.40));
        Assert.assertEquals(new Price(2.40), p);
        p = Tax.round(new Price(2.41));
        Assert.assertEquals(new Price(2.45), p);
        p = Tax.round(new Price(2.42));
        Assert.assertEquals(new Price(2.45), p);
        p = Tax.round(new Price(2.43));
        Assert.assertEquals(new Price(2.45), p);
        p = Tax.round(new Price(2.44));
        Assert.assertEquals(new Price(2.45), p);
        p = Tax.round(new Price(2.45));
        Assert.assertEquals(new Price(2.45), p);
        p = Tax.round(new Price(2.46));
        Assert.assertEquals(new Price(2.50), p);
        p = Tax.round(new Price(2.47));
        Assert.assertEquals(new Price(2.50), p);
        p = Tax.round(new Price(2.48));
        Assert.assertEquals(new Price(2.50), p);
        p = Tax.round(new Price(2.49));
        Assert.assertEquals(new Price(2.50), p);
    }


}
