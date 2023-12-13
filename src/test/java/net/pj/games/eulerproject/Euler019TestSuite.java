package net.pj.games.eulerproject;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Counting Sundays</H1>
 * <H2>Problem 19</H2>
 * <p>
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * <br/>
 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight,
 * rain or shine. And on leap years, twenty-nine. A leap year occurs on any year
 * evenly divisible by 4, but not on a century unless it is divisible by 400.
 * <br/>
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * </p>
 *
 * @author dauvertpj
 */
public class Euler019TestSuite {

    private static final Logger log = LoggerFactory.getLogger(EulerCalculator.class);

    @Test
    public void solution() {

        log.info("----  Solution of problem 19   ----");
        LocalDate firstDayOfXXCentuary = new LocalDate(1901, 1, 1);
        LocalDate lastDayOfXXCentuary = new LocalDate(2000, 12, 31);

        int nbOfSundays = 0;
        for (LocalDate actual = firstDayOfXXCentuary; actual.isBefore(lastDayOfXXCentuary);) {

            if (actual.getDayOfWeek() == 7) {
                nbOfSundays++;
                log.info(actual.toString("EEEE dd MMMM yyyy"));
            }
            actual = actual.plusMonths(1);
        }

        log.info("result = {}", nbOfSundays);
    }

}
