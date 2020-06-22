package DiGraph_A5;

public class DiGraphPlayground {
	public static void main (String[] args) {
		  
	      // thorough testing is your responsibility
	      //
	      // you may wish to create methods like 
	      //    -- print
	      //    -- sort
	      //    -- random fill
	      //    -- etc.
	      // in order to convince yourself your code is producing
	      // the correct behavior
	      exTest();
	    }
	  
	    public static void exTest(){
	      DiGraph d = new DiGraph();
//	      d.addNode(1, "f");
//	      d.addNode(3, "s");
//	      d.addNode(7, "t");
//	      d.addNode(0, "fo");
//	      d.addNode(4, "fi");
//	      d.addNode(6, "si");
//	      d.addEdge(0, "f", "s", 2, null);
//	      d.addEdge(1, "f", "si", 2, null);
//	      d.addEdge(2, "s", "t", 2, null);
//	      d.addEdge(3, "fo", "fi", 2, null);
//	      d.addEdge(4, "fi", "si", 2, null);
//	      d.delNode("si");
	    	for(long i=0;i<1; i++) {
	    		d.addNode(i, "f"+i);
	    		d.addNode(i+1, "f"+i+1);
	    		d.addEdge(i, "f"+i, "f"+i+1, 2, null);
	    	}
	      System.out.println("numEdges: "+d.numEdges());
	      System.out.println("numNodes: "+d.numNodes());
//	      System.out.println( d.delEdge("f","s"));
//	      System.out.println( d.addNode(1,"f"));
//	      System.out.println( d.addNode(3,"s"));
//	      System.out.println( d.addEdge(0,"f","s", 2, null));
//	      System.out.println( d.delEdge("f","s"));
//	      System.out.println( d.delEdge("f","s"));
//	      System.out.println( d.addEdge(0,"f","s", 2, null));
//	      System.out.println( d.delEdge("f","s"));
	

	    }
}
