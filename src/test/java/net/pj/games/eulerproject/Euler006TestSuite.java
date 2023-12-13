package net.pj.games.eulerproject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Sum square difference</H1>
 * <H2>Problem 6</H2>
 * <p>The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * <br/>
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * <br/>
 * Hence the difference between the sum of the squares of 
 * the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * <br/>
 * Find the difference between the sum of the squares of 
 * the first one hundred natural numbers and the square of the sum.
 * </p>
 * 
 * @author dauvertpj
 */
public class Euler006TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler006TestSuite.class);	

        @Test
	public void solution() {
            
            log.info("----  Solution of problem 6   ----");
            int result;
            int max = 100;
            
            int sumOfSquares = 0;
            int squareOfSum= 0;
            
            for(int i=1; i<=max; i++ ){
            	sumOfSquares += (int) Math.pow(i,2);
            	squareOfSum += i;
            }
            squareOfSum = (int) Math.pow(squareOfSum,2);
            
            log.info("Square Of Sum = {}", squareOfSum);
            log.info("Sum Of Squares = {}", sumOfSquares);
            
            result = squareOfSum - sumOfSquares;
            log.info("result = {}", result);
        }

}
