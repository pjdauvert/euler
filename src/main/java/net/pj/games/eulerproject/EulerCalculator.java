package net.pj.games.eulerproject;

import java.math.BigInteger;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EulerCalculator {

    private static final Logger log = LoggerFactory.getLogger(EulerCalculator.class);

    public static BigInteger calculateTriangleOfSize(int size) {

        BigInteger result = BigInteger.ZERO;
        for (int i = 1; i <= size; i++) {
            result = result.add(new BigInteger(String.valueOf(i)));
        }
        log.debug("Triangle number n°" + size + " : " + result);
        return result;
    }

    public static boolean isTriangleNumber(int number) {
        int step = 1;
        while (number > 0) {
            number -= step;
            step++;
        }
        return number == 0;
    }

    public static BigInteger getFactorial(int number) {

        BigInteger factorial = new BigInteger(String.valueOf(number));

        for (int i = number - 1; i > 0; i--) {
            factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }
        return factorial;
    }

    static boolean isAbundant(int x) {

        final List<Integer> divisers = Prime.getDividersOf(x);
        final Integer sum = divisers.stream()
                .filter(a -> a != x)
                .reduce(0, Math::addExact);
        if (sum > x) {
            log.trace("{}->{}", x, sum);
            return true;
        } else {
            return false;
        }

    }

}
