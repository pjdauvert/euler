package net.pj.games.eulerproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.pj.games.eulerproject.elements.GraphNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Classe utilitaire pour le traitement des graphes
 * <br>
 * </p>
 * @author dauvertpj
 */
public class GraphUtils {
	
	private static final Logger log = LoggerFactory.getLogger(GraphUtils.class);
		
	public static GraphNode getTriangleGraphFromString(String input){
		
		GraphNode topNode = null;
		String[] inputSplit = input.split("\\s");
		if( !EulerCalculator.isTriangleNumber(inputSplit.length) )
			log.error("Input data is not triangle");
		else{
			topNode = new GraphNode(0, Integer.parseInt(inputSplit[0]));
			GraphNode[] previousRow = new GraphNode[1];
			previousRow[0]=topNode;
			for(int row=2, i = 1; i< inputSplit.length ; row++){
				GraphNode[] actualRow = new GraphNode[row];
				for(int a=0; a<row; i++, a++){
					GraphNode node = new GraphNode(i, Integer.parseInt(inputSplit[i]));
					actualRow[a] = node;
					if(a!=0)
						previousRow[a-1].addNext(node);
					if(a < row-1)
						previousRow[a].addNext(node);
				}
				previousRow = actualRow;
			}
		}
		return topNode;
	}
	
	public static GraphNode getMaximumTopDownPath( GraphNode root) {
		// Set root node
		root.setPathValue(root.getInnerValue());
		// initialize first row to evaluate
		Set<GraphNode> row = new HashSet<>(root.getNext());
		boolean finished = false;
		while (!finished) {
			Set<GraphNode> nextRow = new HashSet<>(row.size() + 1);
			// Iterate on each node of the row
			for (GraphNode node : row) {
				// get max Previous path
				List<GraphNode> previousPath = node.getPrevious();
				for (GraphNode previousNode : previousPath) {
					if (previousNode.getPathValue() > node.getPathValue()) {
						node.setPathValue(previousNode.getPathValue());
						node.setOptimal(previousNode);
					}
				}
				// add innerValue to max pathValue
				node.setPathValue(node.getPathValue() + node.getInnerValue());
				nextRow.addAll(node.getNext());
			}
			// set next Row
			if (nextRow.isEmpty()) {
				finished = true;
			}
			else {
				row = nextRow;
			}
		}
		int max = 0;
		GraphNode result = root;
		for (GraphNode node : row) {
			if (node.getPathValue() > max){
				max = node.getPathValue();
				result = node;
			}
		}
		//affichage du chemin optimal
		if(log.isDebugEnabled()){
			
			GraphNode current = result;
			List<GraphNode> path = new ArrayList<>(row.size());
			while(current != null){
				path.add(current);
				current = current.getOptimal();
			}
			Collections.reverse(path);
			StringBuffer out = new StringBuffer();
			Iterator<GraphNode> nodeList = path.iterator();
			if(nodeList.hasNext()){
				out.append(nodeList.next());
				while(nodeList.hasNext()){
					out.append("->");
					out.append(nodeList.next());
				}
			}
			log.debug("Chemin : {}", out);
		}
		return result;
	}
	
	public static String printGraph(GraphNode rootNode, boolean topdown){
		
		if(rootNode == null) return "root node is null";
		final StringBuffer out = new StringBuffer("\n");
		List<GraphNode> treatedNodes = new LinkedList<>();
		treatedNodes.add(rootNode);
		goThroughNodes(treatedNodes, rootNode, topdown);
		for(GraphNode node : treatedNodes){
			printNode(out, node, topdown);
		}
		return out.toString();
	}
	
	private static void printNode(StringBuffer buffer, GraphNode node, boolean topdown){
		
		
		Iterator<GraphNode> nodeList;
		String indicator;
		if(topdown){
			nodeList = node.getNext().iterator();
			indicator = ">>";
		}
		else{
			nodeList = node.getPrevious().iterator();
			indicator = "<<";
		}
		if(nodeList.hasNext()){
			buffer.append("[").append(node).append("]").append(indicator).append("{");
			buffer.append(nodeList.next());
			while(nodeList.hasNext()){
				buffer.append(",");
				buffer.append(nodeList.next());
			}
		buffer.append("}\n");
		}
		
	}
	
	private static void goThroughNodes(List<GraphNode> foundNodes, GraphNode node, boolean topdown){
		
		List<GraphNode> searchList;
		if(topdown){
			searchList = node.getNext();
		}else{
			searchList = node.getPrevious();
		}
		for(GraphNode nextNode : searchList){
			if(!foundNodes.contains(nextNode)){
				foundNodes.add(nextNode);
				goThroughNodes(foundNodes, nextNode, topdown);
			}
		}
	}
	

}
