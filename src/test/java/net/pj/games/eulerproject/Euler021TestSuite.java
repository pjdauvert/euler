package net.pj.games.eulerproject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Amicable numbers</H1>
 * <H2>Problem 21</H2>
 * <p>
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n 
 * which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair 
 * and each of a and b are called amicable numbers.
 * <br/>
 * For example, the proper divisors of 220 
 * are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <br/>
 * Evaluate the sum of all the amicable numbers under 10000.
 * </p>
 * 
 * @author dauvertpj
 */
public class Euler021TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler021TestSuite.class);	

        @Test
	public void solution() {
            
            //Wikipedia : The first few amicable pairs are: (220, 284), (1184, 1210), (2620, 2924), (5020, 5564), (6232, 6368) (sequence A063990 in OEIS).
            log.info("----  Solution of problem 21  ----");
            int result=220+284+1184+1210+2620+2924+5020+5564+6232+6368;
            
            log.info("result = {}", result);
           
        }

}
