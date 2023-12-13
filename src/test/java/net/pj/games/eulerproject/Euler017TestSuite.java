package net.pj.games.eulerproject;

import java.math.BigInteger;
import net.pj.games.eulerproject.elements.StringNumbers;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Number letter counts</H1>
 * <H2>Problem 17</H2>
 * <p>If the numbers 1 to 5 are written out in words: 
 * one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <br/>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
 * how many letters would be used?
 * <br/>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 * </p>
 * 
 * @author dauvertpj
 */
public class Euler017TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler017TestSuite.class);	

	@Test
	public void numbersTest(){
		if(log.isDebugEnabled()){
			BigInteger prime = BigInteger.ONE;
			for(int i=0; i<20; i++){
				prime = Prime.getNextPrimeAfter(prime.multiply(new BigInteger("2")));
				log.debug("{} = {}",prime, StringNumbers.getAsString(prime.intValue()));
				log.debug("Number of letters = {}", StringNumbers.countLettersOfNumber(prime.intValue()));
			}
		}
		log.debug("{} = {}",342, StringNumbers.getAsString(342));
		Assert.assertEquals(23, StringNumbers.countLettersOfNumber(342));
		log.debug("{} = {}",115, StringNumbers.getAsString(115));
		Assert.assertEquals(20, StringNumbers.countLettersOfNumber(115));
	}
    
	@Test
	public void solution() {
            
            log.info("----  Solution of problem 17   ----");
            int result=0;
            int upto = 1000;
            for(int i = 1; i<=upto; i++){
            	result += StringNumbers.countLettersOfNumber(i);
            }
            log.info("result = {}", result);
        }

}
