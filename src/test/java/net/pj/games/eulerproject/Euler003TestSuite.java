package net.pj.games.eulerproject;

import java.math.BigInteger;
import java.util.List;
import net.pj.games.eulerproject.elements.BigIntegerPrimeComponent;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Largest prime factor</H1>
 * <H2>Problem 3</H2>
 * <p>
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * </p>
 * 
 * @author dauvertp
 */
public class Euler003TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler003TestSuite.class);	

        @Test
	public void solution() {
            
            log.info("----  Solution of problem 3   ----");
            BigInteger pbNumber = new BigInteger("600851475143");
            final List<BigIntegerPrimeComponent> primeNumbersComposition = Prime.getPrimeNumbersCompositionOf(pbNumber);
            BigInteger result=primeNumbersComposition.get(primeNumbersComposition.size()-1).getPrime();
            log.info("result = {}", result);
        }

}
