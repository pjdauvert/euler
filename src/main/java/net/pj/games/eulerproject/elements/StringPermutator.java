package net.pj.games.eulerproject.elements;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.mutable.MutableInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pjdauvert
 */
public class StringPermutator {

    private static final Logger log = LoggerFactory.getLogger(StringPermutator.class);

    public static String getNextPermutationOf(String s) {

        String next;
        //log.debug("next of {}", s);
        if (isReverseOrdered(s)) {
            //log.debug("Reverse ordered. End of Chain", s);
            return null;
        } else if (s.length() == 2) {
            next = StringUtils.reverse(s);
        } else {
            int max = getIndexOfMax(s);
            if (max > 0 && isReverseOrdered(s.substring(max))) {
                final String suffix = s.substring(max - 1);
                next = s.replace(suffix, incrementWithNextAvailableValue(suffix));
            } else {
                final String suffix = s.substring(max + 1);
                final String nextSuffix = getNextPermutationOf(suffix);
                if (nextSuffix != null) {
                    next = s.replace(suffix, nextSuffix);
                } else {
                    //log.debug("suffix {} has no next permutation", suffix);
                    next = null;
                }
            }
        }
        //log.debug("next is {}", next);
        return next;

    }

    private static int getIndexOfMax(String s) {

        final MutableInt maxIndex = new MutableInt(-1);
        s.chars().max().ifPresent(m -> maxIndex.setValue(s.indexOf(m)));
        return maxIndex.intValue();
    }

    private static boolean isReverseOrdered(String s) {

        if (s.length() == 1) {
            return true;
        }
        char prev = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c > prev) {
                //log.debug("{} is not reverse ordered", s);
                return false;
            }
            prev = c;
        }
        //log.debug("{} is reverse ordered", s);
        return true;

    }

    public static String incrementWithNextAvailableValue(String s) {

        char[] nextValue = new char[s.length()];
        final char actual = s.charAt(0);
        nextValue[0] = (char) s.substring(1)
                .chars()
                .filter(c -> c > actual)
                .min().orElse(-1);
        final int[] orderedSuffix = s.chars().filter(c -> c != nextValue[0]).sorted().toArray();
        for (int i = 0; i < orderedSuffix.length; i++) {
            nextValue[i + 1] = (char) orderedSuffix[i];
        }
        log.debug("incremented value of {} is {}", s, nextValue);
        return new String(nextValue);
    }

}
