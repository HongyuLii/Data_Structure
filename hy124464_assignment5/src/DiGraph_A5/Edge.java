package DiGraph_A5;

public class Edge {
	long idNum;
	String label;
	long weight=1;
	Node source;
	Node destination;
	
	
	public Edge (long idNum,  Node source, Node destination, long weight, String label) {
		this.idNum=idNum;
		this.label=label;
		this.weight=weight;
		this.source=source;
		this.destination=destination;
	}
	
	public boolean isSource(Node n) {
		if(n==this.source) {
			return true;
		} 
		return false;
	}
	
	public boolean isDestination(Node n) {
		if(n==this.destination) {
			return true;
		} 
		return false;
	}
	
	public String getValue() {
		return destination.label;
	}
	
}
