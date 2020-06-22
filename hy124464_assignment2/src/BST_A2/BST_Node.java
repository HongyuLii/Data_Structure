package BST_A2;

public class BST_Node {
	
	  String data;
	  BST_Node left;
	  BST_Node right;
	  
	  
	  BST_Node(String data){ this.data=data; }

	  // --- used for testing  ----------------------------------------------
	  //
	  // leave these 3 methods in, as is

	  public String getData(){ return data; }
	  public BST_Node getLeft(){ return left; }
	  public BST_Node getRight(){ return right; }

	  // --- end used for testing -------------------------------------------

	  
	  // --- fill in these methods ------------------------------------------
	  //
	  // at the moment, they are stubs returning false 
	  // or some appropriate "fake" value
	  //
	  // you make them work properly
	  // add the meat of correct implementation logic to them

	  // you MAY change the signatures if you wish...
	  // make the take more or different parameters
	  // have them return different types
	  //
	  // you may use recursive or iterative implementations

	  
	  public boolean containsNode(String s){ 
		  
		  BST_Node help1=this;
		  while(help1!=null) {
			  if(s.compareTo(help1.data)>0) {
				  help1=help1.right;
			  } else if(s.compareTo(help1.data)<0){
				  help1=help1.getLeft();
			  } else if(s.compareTo(help1.data)==0){
				  return true;
			  }
		  }
		  return false; 
		  
	  }
	  
	  public boolean insertNode(String s){ 
		  
		if(s.compareTo(this.data)<0) {
		
			if(this.left==null) {
				this.left=new BST_Node(s);
				return true;
			} else { 
				this.left.insertNode(s);
			}
			
		} else if(s.compareTo(this.data)>0) {
			
			if(this.right==null) {
				this.right=new BST_Node(s);
				return true;
			} else {
				this.right.insertNode(s);
			}
		} else {
			return false;
		}
		
		return true;
			
		}
	  
	 
	  
	  public boolean removeNode(String s){ 
		  
		  BST_Node help1=this;
		  String a=help1.data;
		  BST_Node parent=help1;
		  
		  while(help1!=null) {
			  if(s.compareTo(help1.data)>0) {
				  parent=help1;
				  help1=help1.right;
			  } else if(s.compareTo(help1.data)<0){
				  parent=help1;
				  help1=help1.getLeft();
			  } else {
				  if(help1.right==null&&help1.left==null) {
					  if(parent.data.compareTo(help1.data)>0) {
						  parent.left=null;
						  help1=null;
					  } else {
						  parent.right=null; 
						  help1=null;
					  }
					  
				  } else if(help1.right==null&&help1.left!=null){

					  if(parent.data.compareTo(help1.data)>0) {
						  parent.left=help1.left;
						  //help1.left.parent=help1.parent;
					  } else {
						  parent.right=help1.left; 
						  //help1.right.parent=help1.parent;
					  }

				  } else if(help1.right!=null&&help1.left==null) {

					  if(parent.data.compareTo(help1.data)>0) {
						  parent.left=help1.right;
					  } else {
						  parent.right=help1.right; 
					  }
					  
				  } else {
					  if(help1.data.compareTo(a)>0) {
						  String max=help1.left.findMax().data;
						  help1.removeNode(help1.left.findMax().data);
						  help1.data=max;
						  
						  
					  } else if(help1.data.compareTo(a)<0){
						  String min=help1.right.findMin().data;
						  help1.removeNode(help1.right.findMin().data);
						  help1.data=min;
					  }
				  }
				  
				  return true;
			  }
		  }
		  return false;
	  }
	  
	  public BST_Node findMin(){ 
		  BST_Node help1=this;
			while(help1.left!=null) {
				help1=help1.left;
			}
			return help1; 
	  }
	  
	  public BST_Node findMax(){ 
		  BST_Node help1=this;
			while(help1.right!=null) {
				help1=help1.right;
			}
			return help1; 
	  }
	  
	 /* public BST_Node getParent(BST_Node node) {
		  BST_Node help1=this;
		  while(help1!=null) {
			  if(help1.right==node||help1.left==node) {
				  parent = help1;
				  return parent;
			  } else if(help1.data.compareTo(node.data)<0){
				  help1=help1.right;
			  } else if(help1.data.compareTo(node.data)>0){
				  help1=help1.left;
			  }
		  }
		  
		  return null;
		
	  }*/
	  
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
	  

	  // --- end fill in these methods --------------------------------------


	  // --------------------------------------------------------------------
	  // you may add any other methods you want to get the job done
	  // --------------------------------------------------------------------
	  
	  public String toString(){
	    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
	            +",Right: "+((this.right!=null)?right.data:"null");
	  }

}
