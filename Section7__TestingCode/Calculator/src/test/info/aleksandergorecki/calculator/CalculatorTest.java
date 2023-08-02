package info.aleksandergorecki.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void canAddZeroPlusZero(){
        int sum = calculator.add(0, 0);
        assertEquals(0, sum, "Was expected sum of zero.");
    }

    @Test
    public void canAddOnePlusOne(){
        int sum = calculator.add(1, 1);
        assertEquals(2, sum, "Was expected sum of two.");
    }

    @Test
    public void canAddOnePlusNegativeTwo(){
        int sum = calculator.add(1, -2);
        assertEquals(-1, sum, "Was expected sum of negative one.");
    }

    @Test
    public void canAddNegativeTwoToNegativeThree(){
        int sum = calculator.add(-2, -3);
        assertEquals(-5, sum, "Was expected sum of negative five.");
    }

    @Test()
    @Disabled
    public void canAddMaxIntPlusOne(){
        int sum = calculator.add(Integer.MAX_VALUE, 1);
        System.out.println(sum);
        System.out.println(Integer.MAX_VALUE);
        assertEquals(2147483647 + 1L, sum);
    }

    @Test
    public void annuityExample(){
        String answer = calculator.calcAnnuity("22000", 7, "0.06", 1);
        assertEquals("$184,664.43", answer);
    }
}
