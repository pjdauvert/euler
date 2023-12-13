package net.pj.games.eulerproject;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Largest palindrome product</H1>
 * <H2>Problem 4</H2>
 * <p>A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 
 * 9009 = 91 × 99.
 * <br/>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * </p>
 * 
 * @author dauvertpj
 */
public class Euler004TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler004TestSuite.class);	

        @Test
	public void solution() {
            
            log.info("----  Solution of problem 4   ----");
            
            int palindrome=0, candidate, min = 99, max = 999;
            int current = max-1;
            while(max > min){
                candidate = max*current;
                String candidateString = String.valueOf(candidate);
                if( StringUtils.equals(candidateString, StringUtils.reverse(candidateString))){
                    if(log.isDebugEnabled()){
                        String[] args = new String[4];
                        args[0] = String.valueOf(max);
                        args[1] = String.valueOf(current);
                        args[2] = candidateString;
                        args[3] = String.valueOf(min);
                        log.debug("found candidate :{}*{}={}  (min={})", args);
                    }
                    if(palindrome < candidate) palindrome = candidate;
                    max -= 1;
                    if( min < current )min = current;
                    current = max;
                }
                current -=1 ;
                if(current == 0 || current < min){
                    max -= 1;
                    current = max-1;
                }
            }
            log.info("result = {}", palindrome);
        }

}
