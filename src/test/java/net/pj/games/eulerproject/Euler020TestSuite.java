/**
 * 
 */
package net.pj.games.eulerproject;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Factorial digit sum</H1>
 * <H2>Problem 20</H2>
 * <p>
 * 
 * n! means n × (n  − 1) × ... × 3 × 2 × 1
 * <br/>
 * Find the sum of the digits in the number 100!
 * </p>
 * 
 * @author dauvertpj
 */
public class Euler020TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler020TestSuite.class);

	@Test
	public void solution() {

		log.info("----  Solution of problem 20   ----");
		String resultAsString = EulerCalculator.getFactorial(100).toString();
		int result = 0;

		for (int i = 0; i < resultAsString.length(); i++) {
			result += Integer.parseInt(StringUtils.substring(resultAsString, i, i + 1));
		}

		log.info("result = {}", result);
	}

}
