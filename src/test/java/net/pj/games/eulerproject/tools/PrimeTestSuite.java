/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package net.pj.games.eulerproject.tools;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import net.pj.games.eulerproject.Prime;
import net.pj.games.eulerproject.elements.BigIntegerPrimeComponent;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author pjdauvert
 */
public class PrimeTestSuite {

	private static Logger log = LoggerFactory.getLogger(PrimeTestSuite.class);


	@Test
	public void primeNumbersTest() {

            final List<BigInteger> lower = Prime.getPrimesLowerThan(new BigInteger("20"));
            // 1, 2, 3, 5, 7, 11, 13, 17, 19
            log.info(lower.toString());
            
            final BigInteger next = Prime.getNextPrimeAfter(new BigInteger("60"));

            log.info(next.toString());

	}

        @Test
	public void compositionTest() {
            final List<BigIntegerPrimeComponent> compo = Prime.getPrimeNumbersCompositionOf(new BigInteger("56"));
            // 2, 3, 3, 3
            log.info(compo.toString());
        }
	@Test
	public void dividersTest() {

		BigInteger test = new BigInteger("56");
		List<BigInteger> dividers = Prime.getDividersOf(test);
		Assert.assertEquals(dividers.size(), Prime.countDividersOf(test));
                
            
            List<Integer> expected = Arrays.asList(1, 2, 3, 4, 6, 12);
            Assert.assertTrue(Prime.getDividersOf(12).containsAll(expected));
            
        }

}
