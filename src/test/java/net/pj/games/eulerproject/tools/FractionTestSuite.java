package net.pj.games.eulerproject.tools;

import net.pj.games.eulerproject.elements.Fraction;
import org.junit.Assert;
import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class FractionTestSuite {
    //private static final Logger log = LoggerFactory.getLogger(PrimeTestSuite.class);

    @Test
    public void testFractionOneSeventh() {
        Fraction f = new Fraction(1, 7);
        Assert.assertEquals("0.(142857)", f.getStringValueWithRecurrence());
        Assert.assertEquals(6, f.getRecurrenceLength());
    }

    @Test
    public void testFractionOneThird() {
        Fraction f = new Fraction(1, 3);
        Assert.assertEquals("0.(3)", f.getStringValueWithRecurrence());
        Assert.assertEquals(1, f.getRecurrenceLength());
    }

    @Test
    public void testFractionOneSixth() {
        Fraction f = new Fraction(1, 6);
        Assert.assertEquals("0.1(6)", f.getStringValueWithRecurrence());
        Assert.assertEquals(1, f.getRecurrenceLength());
    }

    @Test
    public void testFractionOneFourth() {
        Fraction f = new Fraction(1, 4);
        Assert.assertEquals("0.25", f.getStringValueWithRecurrence());
        Assert.assertEquals(0, f.getRecurrenceLength());
    }

    @Test
    public void testZeroNumerator() {
        Fraction f = new Fraction(0, 4);
        Assert.assertEquals("0", f.getStringValueWithRecurrence());
        Assert.assertEquals(0, f.getRecurrenceLength());
    }

    @Test
    public void testZeroDenominator() {
        try {
            new Fraction(4, 0);
            Assert.fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

}
