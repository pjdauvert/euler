/**
 * 
 */
package net.pj.games.eulerproject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Longest Collatz sequence</H1>
 * <H2>Problem 14</H2>
 * <p>
 * The following iterative sequence is defined for the set of positive integers:
 *  n → n/2 (n is even)
 *  n → 3n + 1 (n is odd)
 *  
 *  Using the rule above and starting with 13, we generate the following sequence:
 *  
 *  13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *  
 *  It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 *  Although it has not been proved yet (Collatz Problem),
 *  it is thought that all starting numbers finish at 1.
 *  
 *  Which starting number, under one million, produces the longest chain?
 *  
 *  NOTE: Once the chain starts the terms are allowed to go above one million.
 * </p>
 * 
 * @author dauvertp
 */
public class Euler014TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler014TestSuite.class);

	@Test
	public void solution() {

		log.info("----  Solution of problem 14   ----");
				
		long maxElement= -1;
		long currentMaxElement= 1;
		long element=0;
		
		for(int i=1; i<=1000000;i++){
		
			boolean hasNext = hasNext(i);
			long next = i;
			while(hasNext){
				next = nextChain(next);
				hasNext = hasNext(next);
				currentMaxElement++;
			}
			if(currentMaxElement>maxElement){
				maxElement=currentMaxElement;
				element=i;
			}
			currentMaxElement=1;
		}

		log.info("for element = {}", element);
	
	}
	
	private boolean hasNext(long number){
		return number!=1;
	}
	
	private long nextChain(long number){
		if(number%2==0){
			return number/2;
		}
		else{
			return 3*number+1;
		}
	}

}
