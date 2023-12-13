package net.pj.games.eulerproject;

import java.math.BigInteger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Lattice paths</H1>
 * <H2>Problem 27</H2>
 * <p>
 * Starting in the top left corner of a 2×2 grid, 
 * there are 6 routes (without backtracking) to the bottom right corner.
 * <br/>
 * How many routes are there through a 20×20 grid?
 * </p>
 * 
 * @author dauvertpj
 */
public class Euler015TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler015TestSuite.class);

	@Test
	public void solution() {

		log.info("----  Solution of problem 15   ----");
		int upto = 20;

		final BigInteger TWO = new BigInteger("2");
		BigInteger[][] grid = new BigInteger[upto + 1][upto + 1];
		grid[0][0] = BigInteger.ZERO;
		for (int i = 0; i <= upto; i++) {
			for (int j = 1; j <= upto; j++) {
				if (i == 0) {
					grid[i][j] = BigInteger.ONE;
				}
				else if (j == i) {
					grid[i][j] = grid[i - 1][j].multiply(TWO);
				}
				else {
					grid[i][j] = grid[i - 1][j].add(grid[i][j - 1]);
				}
				grid[j][i]=grid[i][j];
			}
		}
		log.info("result = {}\n{}", grid[upto][upto], MatrixUtils.printMatrix(grid));
	}

	

}
