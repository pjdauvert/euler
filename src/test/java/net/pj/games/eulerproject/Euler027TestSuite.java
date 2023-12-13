package net.pj.games.eulerproject;

import net.pj.games.eulerproject.elements.QuadraticPrime;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Quadratic primes</H1>
 * <H2>Problem 27</H2>
 * <p>
 * Euler discovered the remarkable quadratic formula: n² + n + 41
 * <br> * It turns out that the formula will produce 40 primes for the consecutive
 * values n = 0 to 39.
 * <br> * However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and
 * certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
 * <br> * The incredible formula n² − 79n + 1601 was discovered, which produces 80
 * primes for the consecutive values n = 0 to 79. The product of the
 * coefficients, −79 and 1601, is −126479.
 * <br> * Considering quadratics of the form:
 * <br> * n² + an + b, where |a| < 1000 and |b| < 1000
 * <br> * where |n| is the modulus/absolute value of n e.g. |11| = 11 and |−4| = 4
 * <br> * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0. </p>
 * @author dauvertpj
 */
public class Euler027TestSuite {

    private static final Logger log = LoggerFactory.getLogger(Euler027TestSuite.class);

    @Test
    //@Ignore
    public void testQuadraticPrimeSequence() {

        log.info("----  Test for problem 27  ----");

        QuadraticPrime qp = new QuadraticPrime(1, 41);
        Assert.assertEquals(40, qp.countPrimeSequenceVerbose());
        
        log.info(String.valueOf(qp.value(39)));
        
        qp = new QuadraticPrime(-79, 1601);
        Assert.assertEquals(80, qp.countPrimeSequenceVerbose());
        
        log.info(String.valueOf(qp.value(79)));
        
    }

    @Test
    //@Ignore
    public void solution() {

        log.info("----  Solution of problem 27   ----");
        QuadraticPrime max = new QuadraticPrime(0, 0);
        int count = 0;
        //iterate over a 
        for (int a = 1; a < 1000; a=Prime.getNextPrimeAfter(a, 1000)) {
            for (int b = 1; b < 1000; b=Prime.getNextPrimeAfter(b, 1000)) {
                QuadraticPrime qp = new QuadraticPrime(a, b);
                if (qp.getCount() > count) {
                    max = qp;
                    count = max.getCount();
                }
                qp = new QuadraticPrime(a, -b);
                if (qp.getCount() > count) {
                    max = qp;
                    count = max.getCount();
                }
                qp = new QuadraticPrime(-a, b);
                if (qp.getCount() > count) {
                    max = qp;
                    count = max.getCount();
                }
                qp = new QuadraticPrime(-a, -b);
                if (qp.getCount() > count) {
                    max = qp;
                    count = max.getCount();
                }
            }
        }
        log.info("Count = {}", max.countPrimeSequenceVerbose());

        int result = max.getA()*max.getB();
        log.info("result = {}", result);
        Assert.assertEquals(-59231, result);
    }

}
