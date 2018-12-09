package com.example;

import org.junit.Assert;
import org.junit.Test;

public class PriceTest {

    @Test
    public void rounding() {
        Assert.assertEquals(new Price(4.54), new Price(4.541456576));
        Assert.assertEquals(new Price(2.33), new Price(2.3333333));
    }

    @Test
    public void adding() {
        Assert.assertEquals(new Price(6.87), new Price(2.33).add(new Price(4.541456576)));
        Assert.assertEquals(new Price(6.90), new Price(4.5678).add(new Price(2.3333333)));
    }

    @Test
    public void multiplying() {
        Assert.assertEquals(new Price(9), new Price(4.5).multiply(2));
        Assert.assertEquals(new Price(10.59), new Price(4.541).multiply(2.333333333));
    }

}
