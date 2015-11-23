/**
 * 
 */
package net.pj.games.eulerproject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.pj.games.eulerproject.elements.GraphNode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Maximum path sum II</H1>
 * <H2>Problem 67</H2>
 * <p>
 * By starting at the top of the triangle below and moving to adjacent numbers 
 * on the row below, the maximum total from top to bottom is 23.
 * 
 *        3
 *       7 4
 *      2 4 6
 *     8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom in 'triangle.txt' (see resources), 
 * a 15K text file containing a triangle with one-hundred rows.
 * 
 * NOTE: This is a much more difficult version of Problem 18. It is not possible 
 * to try every route to solve this problem, as there are 299 altogether! 
 * If you could check one trillion (1012) routes every second it would take over 
 * twenty billion years to check them all. 
 * There is an efficient algorithm to solve it. ;o)
 * </p>
 * 
 * @author dauvertp
 */
public class Euler067TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler067TestSuite.class);	

	private String getFile(){

		String chain="";
		
		try{
			
			InputStream ips= ClassLoader.getSystemResourceAsStream("triangle-067.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				chain+=ligne+" ";
			}
			br.close(); 
		}		
		catch (Exception e){
			log.error(e.toString());
		}
		log.debug("Input chain : {}", chain);
		return chain;

	}
	
	@Test
	public void solution() {
		
            log.info("----  Solution of problem 67   ----");
            
            GraphNode root = GraphUtils.getTriangleGraphFromString(getFile());
            //log.info("Graph of nexts is : {}" , GraphUtils.printGraph(root, true));
            GraphNode result = GraphUtils.getMaximumTopDownPath(root);
            
            log.info("result = {}", result.getPathValue());
            
        }

}
