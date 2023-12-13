/**
 * 
 */
package net.pj.games.eulerproject.elements;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 * @author dauvertpj
 */
public class GraphNode {
	
	private int innerValue;
	private int pathValue;
	private GraphNode optimal;
	private final int name;
	private final List<GraphNode> previous;
	private final List<GraphNode> next;
	
	public GraphNode(int name){
		this.name = name;
		this.previous = new LinkedList<>();
		this.next = new LinkedList<>();
	}
	
	public GraphNode(int name, int innerValue ){
		this( name );
		this.innerValue = innerValue;
	}

	public int getName() {
		return name;
	}

	public int getInnerValue() {
		return innerValue;
	}
	public int getPathValue() {
		return pathValue;
	}
	public void setPathValue(int pathValue) {
		this.pathValue = pathValue;
	}
	public List<GraphNode> getNext() {
		return next;
	}
	public List<GraphNode> getPrevious() {
		return previous;
	}
	public void addNext(GraphNode node){
		this.next.add(node);
		if(!node.getPrevious().contains(this)){
			node.addPrevious(this);
		}
		
	}
	public void addPrevious(GraphNode node){
		this.previous.add(node);
		if(!node.getNext().contains(this)){
			node.addNext(this);
		}
		
	}

	public void setOptimal(GraphNode optimal) {
		this.optimal = optimal;
	}

	public GraphNode getOptimal() {
		return optimal;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
        return name == other.name;
    }
	
	public String toString(){
		return name +"("+ innerValue +")";
	}	

}
