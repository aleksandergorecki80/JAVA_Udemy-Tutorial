package com.ag.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    public void canAddZeroPlusZero(){
        int sum = calc.add(0, 0);
        assertEquals(0, sum, "It expects the sum to be zero");
    }

    @Test
    public void canAddOnePlusOne(){
        int sum = calc.add(1, 1);
        assertEquals(2, sum, "It expects the sum to be two");
    }

    @Test
    public void canAddNegativeNumberToPositive(){
        int sum = calc.add(-4, 1);
        assertEquals(-3, sum, "It expects the sum to be minus three");
    }

    @Test
    public void canAddTwoNegativesNumbers(){
        int sum = calc.add(-3, -2);
        assertEquals(-5, sum, "It expects the sum to be minus five");
    }

    @Test
    public void canAddMaxIntPlusOne(){
        int sum = calc.add(Integer.MAX_VALUE, 1);
        System.out.println(sum);
//        assertEquals(2147483648, sum, "It expects the sum to be 2147483648");
    }
}
