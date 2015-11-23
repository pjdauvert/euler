package net.pj.games.eulerproject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Smallest multiple</H1>
 * <H2>Problem 5</H2>
 * <p>2520 is the smallest number that can be divided by each of the numbers 
 * from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible 
 * by all of the numbers from 1 to 20?
 * </p>
 * 
 * @author dauvertp
 */
public class Euler005TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler005TestSuite.class);	

        @Test
	public void solution() {
            
            log.info("----  Solution of problem 5   ----");

            int max = 20;
            List<Integer> listNumber = new ArrayList<>(max);
            for(int i = 1; i <= max; i++){
                listNumber.add(i);
            }
            BigInteger ppcm = Prime.getSmallestCommonMultipleOf(listNumber);
            
            log.info("result = {}", ppcm.intValue());
        }

}
