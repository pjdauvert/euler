package net.pj.games.eulerproject;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.pj.games.eulerproject.elements.Fraction;

/**
 * <H1>Reciprocal Cycles</H1>
 * <H2>Problem 26</H2>
 * <p>A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:</p>
 * <blockquote>
 *     <table border="0" cellpadding="0" cellspacing="0" align="center" style="margin: 0 auto;">
 *         <tbody>
 *             <tr><td><sup>1</sup>/<sub>2</sub></td><td>=&nbsp;</td><td>0.5</td></tr>
 *             <tr><td><sup>1</sup>/<sub>3</sub></td><td>=&nbsp;</td><td>0.(3)</td></tr>
 *             <tr><td><sup>1</sup>/<sub>4</sub></td><td>=&nbsp;</td><td>0.25</td></tr>
 *             <tr><td><sup>1</sup>/<sub>5</sub></td><td>=&nbsp;</td><td>0.2</td></tr>
 *             <tr><td><sup>1</sup>/<sub>6</sub></td><td>=&nbsp;</td><td>0.1(6)</td></tr>
 *             <tr><td><sup>1</sup>/<sub>7</sub></td><td>=&nbsp;</td><td>0.(142857)</td></tr>
 *             <tr><td><sup>1</sup>/<sub>8</sub></td><td>=&nbsp;</td><td>0.125</td></tr>
 *             <tr><td><sup>1</sup>/<sub>9</sub></td><td>=&nbsp;</td><td>0.(1)</td></tr>
 *             <tr><td><sup>1</sup>/<sub>10</sub></td><td>=&nbsp;</td><td>0.1</td></tr>
 *         </tbody>
 *     </table>
 * </blockquote>
 * <p>Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that <sup>1</sup>/<sub>7</sub> has a 6-digit recurring cycle.</p>
 * <p>Find the value of d &lt; 1000 for which <sup>1</sup>/<sub>d</sub> contains the longest recurring cycle in its decimal fraction part.</p>
 * 
 * @author dauvertpj
 */
public class Euler026TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler026TestSuite.class);

    @Test
	public void solution() {
            
        log.info("----  Solution of problem 26   ----");
        // Create a fraction with numerator = 1 for each denominator from 2 to 1000 as prime numbers
        // are not recurring
        int candidate = 7;
        int MAX_DENOMINATOR = 1000;
        int maxRecurrenceLength = 6;
        int result = candidate;

        Fraction f = new Fraction(1, candidate);
        while (candidate > 0 && candidate < MAX_DENOMINATOR) {
            candidate = Prime.getNextPrimeAfter(candidate, MAX_DENOMINATOR);
            f = new Fraction(1, candidate);
            int recurrenceLength = f.getRecurrenceLength();
            //log.debug("\n\ndenominator = {}\nfraction value: {}\nrecurrence length = {}\n\ncurrent best: {}/{}\n", candidate, f.getStringValueWithRecurrence(), f.getRecurrenceLength(), result, maxRecurrenceLength);
            if(recurrenceLength > maxRecurrenceLength) {
                maxRecurrenceLength = recurrenceLength;
                result = candidate;
            }
        }

        log.info("denominator = {}\nvalue: {}\nrecurrence length = {}", result, f.getStringValueWithRecurrence(), f.getRecurrenceLength());
        Assert.assertEquals(983, result);
    }

}
