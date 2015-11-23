package net.pj.games.eulerproject;

import java.math.BigInteger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>10001st prime</H1>
 * <H2>Problem 7</H2>
 * <p>
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * 
 * What is the 10001st prime number?
 * </p>
 * 
 * @author dauvertp
 */
public class Euler007TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler007TestSuite.class);	

        @Test
	public void solution() {
            
            log.info("----  Solution of problem 7   ----");
            
            int primeNumber = 1;
            BigInteger prime = BigInteger.ONE;
            int nieme = 10001;
            while (primeNumber <= nieme){            	
            	prime = Prime.getNextPrimeAfter(prime);
            	primeNumber +=1;
            }
            
            log.info("prime N°{} = {}", nieme, prime.toString());
        }

}
