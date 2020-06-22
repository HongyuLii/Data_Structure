package DiGraph_A5;

import java.util.HashMap;

public class Node {
	
	long idNum;
	String label;
	
	HashMap<String, Edge> edge_in=new HashMap<String, Edge>();
	HashMap<String, Edge> edge_out=new HashMap<String, Edge>();
	
	boolean known_to_path=false;
	
	public Node (long idNum, String label) {
		this.idNum=idNum;
		this.label=label;
	}
	
	public void Add_edge_in(Edge e) {
		this.edge_in.put(e.source.label, e);
	}
	
	
	public void Add_edge_out(Edge e) {
		this.edge_out.put(e.destination.label, e);
	}
}

