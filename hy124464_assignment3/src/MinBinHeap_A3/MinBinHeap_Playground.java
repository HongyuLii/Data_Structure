package MinBinHeap_A3;

import DiGraph_A5.MinBinHeap;

public class MinBinHeap_Playground {
	public static void main(String[] args){   
	    //Add more tests as methods and call them here!!
		TestBuild();
		TestBuild1();
		TestBuild2();

	  }
	  
	  public static void TestBuild(){ 
	    // constructs a new minbinheap, constructs an array of EntryPair, 
	    // passes it into build function. Then print collection and heap.
	    MinBinHeap mbh= new MinBinHeap();
	    EntryPair[] collection= new EntryPair[6];
	    collection[0]=new EntryPair("i",16);
	    collection[1]=new EntryPair("b",12);
	    collection[2]=new EntryPair("c",9);
	    collection[3]=new EntryPair("d",4);
	    collection[4]=new EntryPair("e",5);
	    collection[5]=new EntryPair("f",3);
	  
	    mbh.build(collection);
	    printHeapCollection(collection);
	    printHeap(mbh.getHeap(), mbh.size());

	  }
	  
	  public static void TestBuild1(){ 
		    // constructs a new minbinheap, constructs an array of EntryPair, 
		    // passes it into build function. Then print collection and heap.
		    MinBinHeap mbh= new MinBinHeap();
		    EntryPair[] collection= new EntryPair[2];
		    collection[0]=new EntryPair("i",3);
		    collection[1]=new EntryPair("b",5); 
		    mbh.build(collection);
		    mbh.delMin();
		   // printHeapCollection(collection);
		    printHeap(mbh.getHeap(), mbh.size());

		  }
	  
	  public static void TestBuild2(){ 
		    // constructs a new minbinheap, constructs an array of EntryPair, 
		    // passes it into build function. Then print collection and heap.
		    MinBinHeap mbh= new MinBinHeap();
		    EntryPair[] collection= new EntryPair[8];
		    collection[0]=new EntryPair("i",9);
		    collection[1]=new EntryPair("b",8);
		    collection[2]=new EntryPair("c",7);
		    collection[3]=new EntryPair("d",6);
		    collection[4]=new EntryPair("e",5);
		    collection[5]=new EntryPair("f",4);
		    collection[6]=new EntryPair("g",4);
		    collection[7]=new EntryPair("h",1);
		    mbh.build(collection);
		    mbh.delMin();
		    mbh.delMin();
		    //printHeapCollection(collection);
		    printHeap(mbh.getHeap(), mbh.size());

		  }
//	  public static void TestBuild3(){ 
//		    // constructs a new minbinheap, constructs an array of EntryPair, 
//		    // passes it into build function. Then print collection and heap.
//		    MinBinHeap mbh= new MinBinHeap();
//		    EntryPair[] collection= new EntryPair[8];
//		    collection[0]=new EntryPair("i",3);
//		    collection[1]=new EntryPair("b",5);
//		    collection[2]=new EntryPair("c",1);
//		    collection[3]=new EntryPair("d",0);
//		    collection[4]=new EntryPair("e",46);
//		    collection[5]=new EntryPair("f",5);
//		    collection[6]=new EntryPair("g",6);
//		    collection[7]=new EntryPair("h",17);
//		    mbh.build(collection);
//		    mbh.delMin();
//		    mbh.delMin();
//		    mbh.delMin();
//		    
//		    //printHeapCollection(collection);
//		    printHeap(mbh.getHeap(), mbh.size());
//
//		  }
//	  public static void TestBuild4(){ 
//		    // constructs a new minbinheap, constructs an array of EntryPair, 
//		    // passes it into build function. Then print collection and heap.
//		    MinBinHeap mbh= new MinBinHeap();
//		    EntryPair[] collection= new EntryPair[8];
//		    collection[0]=new EntryPair("i",3);
//		    collection[1]=new EntryPair("b",5);
//		    collection[2]=new EntryPair("c",1);
//		    collection[3]=new EntryPair("d",0);
//		    collection[4]=new EntryPair("e",46);
//		    collection[5]=new EntryPair("f",5);
//		    collection[6]=new EntryPair("g",6);
//		    collection[7]=new EntryPair("h",17);
//		    mbh.build(collection);
//		    mbh.delMin();
//		    mbh.delMin();
//		    mbh.delMin();
//		    mbh.delMin();
//		    //printHeapCollection(collection);
//		    printHeap(mbh.getHeap(), mbh.size());
//
//		  }
//	  
	  
		  
	  
	  public static void printHeapCollection(EntryPair[] e) { 
	    //this will print the entirety of an array of entry pairs you will pass 
	    //to your build function.
	    System.out.println("Printing Collection to pass in to build function:");
	    for(int i=0;i < e.length;i++){
	      System.out.print("("+e[i].value+","+e[i].priority+")\t");
	    }
	    System.out.print("\n");
	  }
	  
	  public static void printHeap(EntryPair[] e,int len) { 
	    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
	    System.out.println("Printing Heap");
	    for(int i=1;i < len+1;i++){
	      System.out.print("("+e[i].value+","+e[i].priority+")\t");
	    }
	    System.out.print("\n");
	  }

}
