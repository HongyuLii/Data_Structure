
package SPLT_A4;


public class BST_Node {
	  String data;
	  BST_Node left;
	  BST_Node right;
	  BST_Node par; //parent...not necessarily required, but can be useful in splay tree
	  boolean justMade; //could be helpful if you change some of the return types on your BST_Node insert.
	            //I personally use it to indicate to my SPLT insert whether or not we increment size.
	  
	  BST_Node(String data){ 
	    this.data=data;
	    this.justMade=true;
	  }
	  
	  BST_Node(String data, BST_Node left,BST_Node right,BST_Node par){ //feel free to modify this constructor to suit your needs
	    this.data=data;
	    this.left=left;
	    this.right=right;
	    this.par=par;
	    this.justMade=true;
	  }

	  // --- used for testing  ----------------------------------------------
	  //
	  // leave these 3 methods in, as is (meaning also make sure they do in fact return data,left,right respectively)

	  public String getData(){ return data; }
	  public BST_Node getLeft(){ return left; }
	  public BST_Node getRight(){ return right; }

	  // --- end used for testing -------------------------------------------

	  
	  // --- Some example methods that could be helpful ------------------------------------------
	  //
	  // add the meat of correct implementation logic to them if you wish

	  // you MAY change the signatures if you wish...names too (we will not grade on delegation for this assignment)
	  // make them take more or different parameters
	  // have them return different types
	  //
	  // you may use recursive or iterative implementations
	  
	  public boolean containsNode_boolean(String s){ 
		  
		  BST_Node help1=this;
		  BST_Node parent=null;
		  
		  while(help1!=null) {
			  parent=help1;
			  if(s.compareTo(help1.data)>0) {
				  help1=help1.right;
			  } else if(s.compareTo(help1.data)<0){
				  help1=help1.left;
			  } else if(s.compareTo(help1.data)==0){
				  splay(help1);
				  return true;
			  }
			  
		  }
		  if(parent!=null) {
			  splay(parent);
			  return false;
		  }

		  return false;
		  
	  }

	  
	  public BST_Node containsNode(String s){ 
		  
		  
		  BST_Node help1=this;
		  BST_Node parent=null;
		  
		  while(help1!=null) {
			  parent=help1;
			  if(s.compareTo(help1.data)>0) {
				  help1=help1.right;
			  } else if(s.compareTo(help1.data)<0){
				  help1=help1.left;
			  } else if(s.compareTo(help1.data)==0){
				  splay(help1);
				  return help1;
			  }
			  
		  }
		  if(parent!=null) {
			  splay(parent);
			  return parent;
		  }
		  return parent;
		  
	  } //note: I personally find it easiest to make this return a Node,(that being the node splayed to root), you are however free to do what you wish.
	 
	  
	  
	  public BST_Node insertNode(String s){ 
		  
		  BST_Node inserted_node=new BST_Node(s);

		  if(s.compareTo(this.data)<0){
			  if(this.left==null) {
					this.left= inserted_node;
					inserted_node.par=this;
				} else { 
					this.left.insertNode(s);
				}
		  } else if(s.compareTo(this.data)>0) {
			  if(this.right==null) {
					this.right=inserted_node;
					inserted_node.par=this;
				} else {
					this.right.insertNode(s);
				}
		  } else if(s.compareTo(this.data)==0) {
			  this.justMade=false;
			  splay(this);
			  return this;
		  }
		  
		  splay(inserted_node);
		  
		  return this.par;
	  } //Really same logic as above note
	  
	  
	  
	  public boolean removeNode(String s){ 
		  
		  
		  return false; 
		  
	  } //I personal do not use the removeNode internal method in my impl since it is rather easily done in SPLT, feel free to try to delegate this out, however we do not "remove" like we do in BST
	 
	  
	  
	  public BST_Node findMin(){ 
		 
		  if(this.left!=null) {
			 return this.left.findMin();
		  } 
		  	 splay(this);
		  	 return this;
	  } 
	 
	  
	  
	  public BST_Node findMax(){ 
		 
		  if(this.right!=null) {
			  return this.right.findMin();
		  } 
		  splay(this);
		  return this; 
	  }
	  
	  
	  
	  public int getHeight(){ 
		  int lheight = 0; 
          int rheight = 0;
          
          if(this.left!=null) {
          	lheight=this.left.getHeight();
          } 
          if(this.right!=null) {
          	rheight=this.right.getHeight();
          }
          if (lheight > rheight) 
              return (lheight +1); 
           else 
              return (rheight +1); 
	  
	  
	  }
	  
	  
	  public void LeftChildRotate(BST_Node c, BST_Node p) {
		  
		  if(p.par!=null) {
			  if(p==p.par.left) {
				  p.par.left=c;
			  } else {
				  p.par.right=c;
			  }
			  
			  c.par=p.par;
		  } else {
			  c.par=null;
		  }
		  p.par=c;
		  
		  
		  if(c.right!=null) {
			  
			  c.right.par=p;
		  }
		  p.left=c.right;
		  c.right=p;
	  }

	  public void RightChildRotate(BST_Node c, BST_Node p) {
		  
		  if(p.par!=null) {
			  if(p==p.par.left) {
				  p.par.left=c;
			  } else {
				  p.par.right=c;
			  }
			  c.par=p.par;
		  }else {
			  c.par=null;
		  }
		  
		  if(c.left!=null) {
			  
			  c.left.par=p;
		  }
		  p.par=c;
		  p.right=c.left;
		  c.left=p;
	  }
	  
	  
	  private void splay(BST_Node toSplay) { 
		  while(toSplay.par!=null) {
			  BST_Node Parent = toSplay.par;
			  BST_Node GrandParent = Parent.par;
			  
			  if(GrandParent==null) {
				  if(toSplay==Parent.left) {
					  LeftChildRotate(toSplay, Parent);
				  } else {
					  RightChildRotate(toSplay, Parent);
				  }
			  } else {
				  if(Parent.left==toSplay) {
					  if(GrandParent.left==Parent) {
						  LeftChildRotate(toSplay, Parent);
						  LeftChildRotate(toSplay, GrandParent);
					  } else {
						  LeftChildRotate(toSplay, Parent);
						  RightChildRotate(toSplay, GrandParent);
					  }
				  } else { 
					  if(GrandParent.left==Parent) {
						  RightChildRotate(toSplay, Parent);
						  LeftChildRotate(toSplay, GrandParent);
					  } else {
						  RightChildRotate(toSplay, Parent);
						  RightChildRotate(toSplay, GrandParent);
					  }
				  }
			  }
			  
		  }
	  } 
	  //you could have this return or take in whatever you want..
	  						//so long as it will do the job internally. As a caller of SPLT functions, 
	  						//I should really have no idea if you are "splaying or not"
	                        //I of course, will be checking with tests and by eye to make sure you are indeed splaying
	                        //Pro tip: Making individual methods for rotateLeft and rotateRight might be a good idea!
	  

	  // --- end example methods --------------------------------------

	  
	  

	  // --------------------------------------------------------------------
	  // you may add any other methods you want to get the job done
	  // --------------------------------------------------------------------
	  
}
