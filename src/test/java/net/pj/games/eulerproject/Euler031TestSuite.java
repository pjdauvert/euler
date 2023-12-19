package net.pj.games.eulerproject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Sum Coins</H1>
 * <H2><a href="https://projecteuler.net/problem=31">Problem 31</a></H2>
 * <p>
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * <br/>
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * <br/>
 * It is possible to make £2 in the following way:
 * <br/>
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * <br/>
 * How many different ways can £2 be made using any number of coins?
 * </p>
 *
 * @author dauvertpj
 */
public class Euler031TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler031TestSuite.class);

	private int changeCoins(int amount, int[] coins) {
		int[] ways = new int[amount + 1];
		ways[0] = 1;

		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				ways[i] += ways[i - coin];
			}
		}

		return ways[amount];
	}

	@Test
	@Ignore
	public void testStatement() {
		log.info("----  Test for problem 31  ----");
		int result = changeCoins(100, new int[]{100, 50});
		Assert.assertEquals(2, result);
	}

	@Test
	public void solution() {
		log.info("----  Solution of problem 31   ----");
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		int result = changeCoins(200, coins);
		log.info("result = {}", result);
		Assert.assertEquals(73682, result);
	}

}
