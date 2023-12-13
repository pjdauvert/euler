package net.pj.games.eulerproject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Special Pythagorean triplet</H1>
 * <H2>Problem 9</H2>
 * <p>A Pythagorean triplet is a set of three natural numbers, a  < b  < c, for which,
 * 			a^2 + b^2 = c^2
 * <br/>
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <br/>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * <br/>
 * Find the product abc.
 *</p>
 * 
 * @author dauvertpj
 */
public class Euler009TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler009TestSuite.class);	

	@Test
	public void solution() {
            
            log.info("----  Solution of problem 9   ----");
            int result;
            
            int a=2, b=3, c=0;
            while(a+b<1000){
            	c = 1000 - (a+b);
            	if( Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow(b, 2))){
            		Integer[] abc = {a,b,c};
            		log.info("found a={} b={} c={}", abc);
            		break;
            	}else{
            		b+=1;
            		if(a+b == 1000){
            			a+=1;
            			b=a+1;
            		}
            	}
            }
            result = (a*b)*c;
            
            log.info("result = {}", result);
        }

}
