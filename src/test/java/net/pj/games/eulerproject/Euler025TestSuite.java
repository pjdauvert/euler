/**
 *
 */
package net.pj.games.eulerproject;

import net.pj.games.eulerproject.elements.StringPermutator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

/**
 * <H1>1000-digit Fibonacci number</H1>
 * <H2>Problem 25</H2>
 * <p>
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 *
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 * </p>
 *
 * @author dauvertp
 */
public class Euler025TestSuite {

    private static final Logger log = LoggerFactory.getLogger(Euler025TestSuite.class);

    @Test
    public void solution() {

        log.info("----  Solution of problem 25   ----");
        BigInteger fmin1 = BigInteger.ONE;
        BigInteger fmin2 = BigInteger.ONE;
        int fiboSize = 1;
        int fibo = 2;
        while( fiboSize < 1000 ){
            BigInteger fnext = fmin1.add(fmin2);
            fmin2 = fmin1;
            fmin1 = fnext;
            fibo += 1;
            fiboSize = fnext.toString().length();
            log.info("F"+fibo+": ["+fiboSize+"]: "+fnext.toString());
        }

        log.info("result = {}", fibo);
        //Assert.assertEquals("2783915460", fibo);


    }

}
