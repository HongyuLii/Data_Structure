package DiGraph_A5;
import java.io.*; 
import java.util.*;


public class DiGraph implements DiGraphInterface {
	
	 // in here go all your data and methods for the graph
	HashMap<String, Node> node_hash=new HashMap<String, Node>();
	HashSet<Long> nodeId = new HashSet<Long>();//store all nodes' id
	HashSet<Long> edgeId = new HashSet<Long>();//store all edges' id
	int numEdges=0;
	int numNodes=0;
	
	
	public DiGraph ( ) { // default constructor
	    // explicitly include this
	    // we need to have the default constructor
	    // if you then write others, this one will still be there
	  }

	@Override
	public boolean addNode(long idNum, String label) {
		// TODO Auto-generated method stub
		if(idNum<0||label==null) {
			return false;
		}else {
			Node node_added=new Node(idNum, label);
			if(node_hash==null) {
				node_hash.put(label, node_added);
				nodeId.add(idNum);
				numNodes++;
				return true;
			} else if (node_hash.containsKey(label)||nodeId.contains(idNum)) {
				return false;
			} else {
				node_hash.put(label, node_added);
				nodeId.add(idNum);
				numNodes++;
				return true;
			}
		}
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		// TODO Auto-generated method stub
		if(idNum<0||edgeId.contains(idNum)) {
			return false;
		} else if(!node_hash.containsKey(sLabel)||sLabel==null||!node_hash.containsKey(dLabel)||dLabel==null) {
			return false;
		} else {
			
			Node sourceNode=node_hash.get(sLabel);
			Node destinationNode=node_hash.get(dLabel);
			
			if(sourceNode.edge_out.containsKey(dLabel)&&destinationNode.edge_in.containsKey(sLabel)) {
				return false;
			}
			
			numEdges++;
			edgeId.add(idNum);
			Edge edge_added=new Edge(idNum, sourceNode, destinationNode, weight, eLabel);
			sourceNode.Add_edge_out(edge_added);
			destinationNode.Add_edge_in(edge_added);
			return true;
		}
		
	}

	@Override
	public boolean delNode(String label) {
		// TODO Auto-generated method stub
	
		if(!node_hash.containsKey(label)) {
			return false;
		} else {
			Node node_deleted=node_hash.get(label);
			Iterator<Map.Entry<String, Edge>> iterator_in=node_deleted.edge_in.entrySet().iterator();
			Iterator<Map.Entry<String, Edge>> iterator_out=node_deleted.edge_out.entrySet().iterator();
				
			while(iterator_in.hasNext()) {
				Edge removed_in=iterator_in.next().getValue();
				node_hash.get(removed_in.source.label).edge_out.remove(label);
				edgeId.remove(removed_in.idNum);
				//delEdge(removed_in.source.label, label);
			} 
			while(iterator_out.hasNext()) {
				Edge removed_out=iterator_out.next().getValue();
				node_hash.get(removed_out.destination.label).edge_out.remove(label);
				edgeId.remove(removed_out.idNum);
				//delEdge(label, removed_out.destination.label);
			}
			//this is a bit broken
			
			nodeId.remove(node_deleted.idNum);
			node_hash.remove(label); 
		}
		return true;
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		// TODO Auto-generated method stub
		if(!node_hash.containsKey(sLabel)||!node_hash.containsKey(dLabel)) {
			return false;
		} 
		Node source=node_hash.get(sLabel);
		Node destination_node=node_hash.get(dLabel);
		if (!source.edge_out.containsKey(dLabel)){
			return false;
		} else {
			Node sourceNode=node_hash.get(sLabel);
			Node destinationNode=node_hash.get(dLabel);
			Edge edge_remove=sourceNode.edge_out.get(dLabel);
			destinationNode.edge_in.remove(sLabel);
			sourceNode.edge_out.remove(dLabel);
			edgeId.remove(edge_remove.idNum);
			return true;
		}
		

	}
	@Override
	public long numNodes() {
		// TODO Auto-generated method stub
		return nodeId.size();
	}

	@Override
	public long numEdges() {
		// TODO Auto-generated method stub
		return edgeId.size();
	}

	@Override
	public ShortestPathInfo[] shortestPath(String label) {
		// TODO Auto-generated method stub
		if(label==null) {
			throw new RuntimeException("label is null");
		} 
		
		if(!node_hash.containsKey(label)) {
			throw new RuntimeException("label is not in the hash");
		} 
		
		EntryPair entry=new EntryPair(label, 0);
		MinBinHeap pQueue = new MinBinHeap();
		pQueue.insert(entry);
		
		ShortestPathInfo[] sp =new ShortestPathInfo[nodeId.size()];
		
		int i=0;
		while(pQueue.size()!=0) {
			
			EntryPair current_entry=pQueue.getMin();
			Node node_current = node_hash.get(current_entry.value);
			long weight_current=pQueue.getMin().priority;
			pQueue.delMin();
			if(node_current.known_to_path==false) {
				sp[i]=new ShortestPathInfo(current_entry.value, weight_current);
				node_current.known_to_path=true;
				i++;
			} 
			Iterator<Edge> edges_adj=node_current.edge_out.values().iterator();
			while(edges_adj.hasNext()) {
				Node node_next=edges_adj.next().destination;
				if(node_next.known_to_path==false) {
				long weight_next=node_next.edge_in.get(node_current.label).weight+weight_current;
				
				EntryPair next_entry=new EntryPair(node_next.label, weight_next);
				
				pQueue.insert(next_entry);
				}
			}
			
		}
		
			for(Node e : node_hash.values()) {
				if(e.known_to_path==false) {
					sp[i] = new ShortestPathInfo(e.label,-1);
					i++;
				}
			}

		
		return sp;
	}

}
