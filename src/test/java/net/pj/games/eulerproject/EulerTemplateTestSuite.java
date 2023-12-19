package net.pj.games.eulerproject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Title</H1>
 * <H2><a href="https://projecteuler.net/problem=X">Problem X</a></H2>
 * <p>
 * </p>
 * 
 * @author dauvertpj
 */
public class EulerTemplateTestSuite {

	private static final Logger log = LoggerFactory.getLogger(EulerTemplateTestSuite.class);	

    @Test
    @Ignore
	public void testStatement() {
		log.info("----  Test for problem X  ----");
    }

    @Test
	public void solution() {
        log.info("----  Solution of problem X   ----");
        int result=0;

        log.info("result = {}", result);
        Assert.assertEquals(0, result);
    }

}
