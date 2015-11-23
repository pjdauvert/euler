package net.pj.games.eulerproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Non-abundant sums</H1>
 * <H2>Problem 23</H2>
 * <p>
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 * </p>
 *
 * @author dauvertp
 */
public class Euler023TestSuite {

    private static final Logger log = LoggerFactory.getLogger(Euler023TestSuite.class);

    @Test
    @Ignore
    public void listAbundantNumbers() {
        log.info("----  Test for problem 23 : list Abundant Numbers ----");

        log.debug(
                String.valueOf(
                        IntStream
                        .iterate(12, x -> x + 1)
                        .limit(28111)
                        .filter(x -> EulerCalculator.isAbundant(x))
                        .count()
                )
        );

    }

    @Test
    public void solution() {

        log.info("----  Solution of problem 23   ----");
        final int[] abundants = IntStream
                .iterate(12, x -> x + 1)
                .limit(28111)
                .filter(x -> EulerCalculator.isAbundant(x))
                .toArray();

        final ArrayList<Object> abundantSums = Arrays
                .stream(abundants)
                .parallel()
                .mapToObj(x -> Arrays
                        .stream(abundants)
                        .parallel()
                        .filter(i -> i + x < 28123)
                        .map(i -> Math.addExact(x, i))
                        .collect(
                                ArrayList::new,
                                ArrayList::add,
                                ArrayList::addAll
                        )
                )
                .collect(ArrayList::new,
                        ArrayList::addAll,
                        ArrayList::addAll);

        int result = IntStream.range(1, 28123)
                .filter(n -> !abundantSums.contains(n))
                .sum();

        log.info("result = {}", result);
        Assert.assertEquals(4179871, result);
    }

}
