package com.visa.ncg.canteen;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class CalculateorTest {
    private Calculator calc;

    @Before
    public void setup() {
        calc = new Calculator();
    }

    @Test
    public void testCalc(){
        int result = calc.add(5, 3);
        Assert.assertEquals(result, 8);
    }
}
