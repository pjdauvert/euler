package net.pj.games.eulerproject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>	Multiples of 3 and 5</H1>
 * <H2>Problem 1</H2>
 * <p>
 * If we list all the natural numbers below 10 that are 
 * multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * <br/>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * </p>
 * 
 * @author dauvertpj
 */
public class Euler001TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler001TestSuite.class);	

        @Test
	public void solution() {
            
            log.info("----  Solution of problem 1   ----");
            int result=0;
            for(int i=3; i<1000; i++){
                if(i%3==0 || i%5==0)
                    result+=i;
            }
            log.info("result = {}", result);
        }

}
