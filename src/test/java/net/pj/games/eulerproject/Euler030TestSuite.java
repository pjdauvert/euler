package net.pj.games.eulerproject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Digit Fifth Powers</H1>
 * <H2><a href="https://projecteuler.net/problem=30">Problem 30</a></H2>
 * <p>
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * <br/>
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * <br/>
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * <br/>
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * <br/>
 * As 1 = 1^4 is not a sum it is not included.
 * <br/>
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * <br/>
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * <br/>
 * <br/>
 * </p>
 *
 * @author dauvertpj
 */
public class Euler030TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler030TestSuite.class);

	private int sumOfDigitPowers(int i) {
		int result = 0;
		int max = (int) Math.pow(9, i) * i;
		for (int n = 2; n < max; n++) {
			int sum = 0;
			int tmp = n;
			while (tmp > 0) {
				int digit = tmp % 10;
				tmp /= 10;
				sum += (int) Math.pow(digit, i);
			}
			if (sum == n) {
				result += n;
			}
		}
		return result;
	}

	@Test
	@Ignore
	public void testStatement() {
		log.info("----  Test for problem 30  ----");
		int result = sumOfDigitPowers(4);
		log.info("result = {}", result);
		Assert.assertEquals(19316, result);
	}

	@Test
	public void solution() {
		log.info("----  Solution of problem 30   ----");
		int result = sumOfDigitPowers(5);

		log.info("result = {}", result);
		Assert.assertEquals(443839, result);
	}

}
