package net.pj.games.eulerproject;

import net.pj.games.eulerproject.elements.StringPermutator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Lexicographic permutations</H1>
 * <H2>Problem 24</H2>
 * <p>
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are
 * listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * <br>
 * 012 021 102 120 201 210
 * <br> * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * </p>
 *
 * @author dauvertpj
 */
public class Euler024TestSuite {

    private static final Logger log = LoggerFactory.getLogger(Euler024TestSuite.class);

    @Test
    @Ignore
    public void testStringPermutator() {

        log.info("----  Test for problem 24  ----");
        
        String number = "01234";
        Assert.assertEquals("01243", StringPermutator.getNextPermutationOf(number));
        
        int count=0;
        while( number != null){
            log.info(number);
            count+= 1;
            number = StringPermutator.getNextPermutationOf(number);
        
        }
        log.info("Total permutations is {}", count);
                
        
        
    }

    @Test

    public void solution() {

        log.info("----  Solution of problem 24   ----");
        String number = "0123456789";
        int count=1;
        while( count < 1000000){
            number = StringPermutator.getNextPermutationOf(number);
            count++;
            
        }

        log.info("result = {}", number);
        Assert.assertEquals("2783915460", number);
    }

}
