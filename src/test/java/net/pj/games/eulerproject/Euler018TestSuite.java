/**
 * 
 */
package net.pj.games.eulerproject;

import net.pj.games.eulerproject.elements.GraphNode;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <H1>Maximum path sum I</H1>
 * <H2>Problem 18</H2>
 * <p>
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:
 * 
 *               75
 *              95 64
 *             17 47 82
 *            18 35 87 10
 *           20 04 82 47 65
 *          19 01 23 75 03 34
 *         88 02 77 73 07 63 67
 *        99 65 04 28 06 16 70 92
 *       41 41 26 56 83 40 80 70 33
 *      41 48 72 33 47 32 37 16 94 29
 *     53 71 44 65 25 43 91 52 97 51 14
 *    70 11 33 28 77 73 17 78 39 68 17 57
 *   91 71 52 38 17 14 91 43 58 50 27 29 48
 *  63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * 
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. 
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows; 
 * it cannot be solved by brute force, and requires a clever method! ;o)
 * 
 * </p>
 * @author dauvertp
 */
public class Euler018TestSuite {

	private static final Logger log = LoggerFactory.getLogger(Euler018TestSuite.class);	

	private static final String input =  "75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34 88 02 77 73 07 63 67 99 65 04 28 06 16 70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 04 68 89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
	
	@Test
	public void solution() {
            
            log.info("----  Solution of problem 18   ----");
            
            GraphNode root = GraphUtils.getTriangleGraphFromString(input);
            //log.info("Graph of nexts is : {}" , GraphUtils.printGraph(root, true));
            
            GraphNode result = GraphUtils.getMaximumTopDownPath(root);
            
            log.info("result = {}", result.getPathValue());
        }

    @Test
    @Ignore
    public void testGraphPrint(){
        	
        	GraphNode root = new GraphNode(0,23);
        	for(int i=1; i<5; i++){
        		GraphNode n = new GraphNode(i,90+i);
        		n.addPrevious(root);
        	}  
        	
        	log.info("Graph of nexts is : {}" , GraphUtils.printGraph(root, true));
        	for(GraphNode node:root.getNext()){
        		log.info("Graph of prevs is : {}" , GraphUtils.printGraph(node, false));
        	}
        }
    
    @Test
    @Ignore
    public void testGraphAcquireWithInvalidInput(){
    	String inputTest =  "75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01";
    	GraphNode root = GraphUtils.getTriangleGraphFromString(inputTest);
    	log.info("Graph of nexts is : {}" , GraphUtils.printGraph(root, true));
    }
    
    @Test
    @Ignore
    public void testGraphAcquireWithValidInput(){
    	String inputTest =  "75 95 64 17 47 82 18 35 87 10 20 04 82 47 65";
    	GraphNode root = GraphUtils.getTriangleGraphFromString(inputTest);
    	log.info("Graph of nexts is : {}" , GraphUtils.printGraph(root, true));
    	
    }
}
