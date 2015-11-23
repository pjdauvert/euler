/**
 *
 */
package net.pj.games.eulerproject;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Names scores</H1>
 * <H2>Problem 22</H2>
 * <p>
 * Using 'names.txt' (@see project resources), 
 * a 46K text file containing over five-thousand first names, 
 * begin by sorting it into alphabetical order. Then working out the 
 * alphabetical value for each name, multiply this value by its alphabetical 
 * position in the list to obtain a name score.
 * For example, when the list is sorted into alphabetical order, COLIN, 
 * which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 *</p>
 * @author dauvertp
 */
public class Euler022TestSuite {

    private static final Logger log = LoggerFactory.getLogger(Euler022TestSuite.class);

    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Test
    public void solution() throws IOException, URISyntaxException {

        log.info("----  Solution of problem 22  ----");
        //file Parsing
        URL resourceUrl = getClass().getResource("/names-022.txt");
        Path resourcePath = Paths.get(resourceUrl.toURI());
        final String allNames = Files.lines(resourcePath).findFirst().get();
        
        final List<String> sortedNames = Arrays.stream(allNames.split(","))
                .map(n -> StringUtils.mid(n, 1, n.length() - 2))
                .sorted()
                .collect(Collectors.toList());
        log.info("Size of names list: {}", sortedNames.size());
        
        final int[] values = sortedNames.stream()
                .mapToInt(n -> n.chars().map(c -> alphabet.indexOf(c) + 1).sum())
                .toArray();
        log.info("Size of values list: {}", values.length);
        
        final int[] scores = IntStream.range(1, values.length+1).map(i-> values[i-1]*i).toArray();
        
        log.info("Size of scores list: {}", scores.length);
        
        final Optional<BigInteger> sum = Arrays.stream(scores)
                .mapToObj(
                        s-> new BigInteger(String.valueOf(s))
                ).reduce( (x,y) -> x.add(y));
                        
        
        IntStream.range(0, values.length)
                .forEachOrdered(
                    i->log.info(
                            String.valueOf(i+1) 
                                    + " - " 
                                    + sortedNames.get(i)
                                    +'('
                                    +String.valueOf(values[i])
                                    +") : "
                                    + String.valueOf(scores[i])
                    ));
        
        log.info("result = {}", sum.get());
            
    }

}
