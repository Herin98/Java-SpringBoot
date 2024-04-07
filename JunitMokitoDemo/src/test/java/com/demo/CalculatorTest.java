package com.demo;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator cal = new Calculator();

    @Test
    public void testAddUsingAssertEqual(){
        assertEquals(4,cal.add(2,2));
    }

    @Test
    public void testMultiplyUsingAssertEqual(){
        assertEquals(9,cal.multi(3,3));
    }

    @Test
    public void testAddUsingAssertTrue(){
        assertTrue("asserttrue", 6==cal.add(3,3));
    }

    @Test
    public void testMultiplyUsingAssertfail(){
        assertFalse("assertFalse",10==cal.multi(3,3));
    }

    @Test(expected = ArithmeticException.class)
    public void testException(){
        assertEquals(6,cal.div(2, 0));
    }

}
