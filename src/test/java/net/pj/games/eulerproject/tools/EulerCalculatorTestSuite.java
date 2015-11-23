/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package net.pj.games.eulerproject.tools;

import java.math.BigInteger;
import net.pj.games.eulerproject.EulerCalculator;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author pjdauvert
 */
public class EulerCalculatorTestSuite {

	private static Logger log = LoggerFactory.getLogger(EulerCalculatorTestSuite.class);

	@Test
	public void triangleNumbersTest() {

		EulerCalculator.calculateTriangleOfSize(10);
		EulerCalculator.calculateTriangleOfSize(100);
		EulerCalculator.calculateTriangleOfSize(10000);
		EulerCalculator.calculateTriangleOfSize(10000000);
	}

	@Test
	public void testFactorial() {
		Assert.assertEquals(new BigInteger("3628800"), EulerCalculator.getFactorial(10));
	}

}
