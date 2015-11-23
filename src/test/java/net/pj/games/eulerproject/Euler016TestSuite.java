/**
 * 
 */
package net.pj.games.eulerproject;

import java.math.BigInteger;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Power digit sum</H1>
 * <H2>Problem 16</H2>
 * <p>
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * </p>
 * 
 * @author dauvertp
 */
public class Euler016TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler016TestSuite.class);

	@Test
	public void solution() {

		log.info("----  Solution of problem 16   ----");
		BigInteger value = new BigInteger("1");
		for (int i = 0; i < 1000; i++) {
			value = value.multiply(new BigInteger("2"));
		}

		String sequence = String.valueOf(value);
		int sum = 0;

		for (int i = 0; i < sequence.length(); i++) {
			sum += Integer.parseInt(StringUtils.substring(sequence, i, i + 1));
		}

		log.info("result = {}", sum);
	}

}
