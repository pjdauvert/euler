package net.pj.games.eulerproject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Title</H1>
 * <H2>Problem 27</H2>
 * <p>
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5
 * <br/>
 * spiral is formed as follows:
 * <br/>
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * <br/>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <br/>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * </p>
 * 
 * @author dauvertpj
 */
public class Euler028TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler028TestSuite.class);

    private int sumDiagonals(int size) {
        int result = 0;
        int n = 1;
        int index = 1;
        int max = size*size;
        while(n < max + 1) {
            result += n;
            int delta = (((index-1)/4) + 1) * 2;
            n+=delta;
            index++;
        }
        return result;
    }
    @Test
    @Ignore
	public void testWhatever() {
		log.info("----  Test for problem 28  ----");
        int result = sumDiagonals(5);
        Assert.assertEquals(101, result);
    }

    @Test
	public void solution() {
        log.info("----  Solution of problem 28   ----");
        int result = sumDiagonals(1001);
        log.info("result = {}", result);
        Assert.assertEquals(669171001, result);
    }
}
