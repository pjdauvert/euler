package net.pj.games.eulerproject;

import java.math.BigInteger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>	Summation of primes</H1>
 * <H2>Problem 10</H2> * <p>
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <br/>
 * Find the sum of all the primes below two million.
 *</p>
 * 
 * @author dauvertpj
 */
public class Euler010TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler010TestSuite.class);	

    @Test
	public void solution() {
            
            log.info("----  Solution of problem 10   ----");
            BigInteger result= BigInteger.ZERO;
            BigInteger upto= new BigInteger("2000000");
            BigInteger prime = new BigInteger("2");
            while( prime.compareTo(upto) < 0){
            	
            	result = result.add(prime);
            	prime = Prime.getNextPrimeAfter(prime);
            	
            	
            }        
            
            log.info("result = {}", result);
        }

}
