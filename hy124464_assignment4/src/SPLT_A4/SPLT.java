
package SPLT_A4;

public class SPLT implements SPLT_Interface {
	
	  private BST_Node root;
	  private int size;
	  
	  public SPLT() {
	    this.size = 0;
	  } 
	  
	  public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
	    return root;
	  }  

	@Override
	public void insert(String s) {
		// TODO Auto-generated method stub
		if(root==null) {
			 root=new BST_Node(s);
			 size++;
		} else {
			root=root.insertNode(s);
			if(root.justMade==true) {
				size++;
			}
			}
	} 
		



	@Override
	public void remove(String s) {
		
		// TODO Auto-generated method stub
		if (root == null){
			
		}
		if (contains(s)==false){
			
		}else {
			size -= 1;
			if (root.left == null){
				root = root.right;
				
			} else {
				
				BST_Node right = this.root.right;
				if (right == null){
					root = root.left;
					
				} else {
					root = root.left.findMax();
				}
				if (right != null) {
					root.right = right;
				}
				if (root.right != null){
					root.right.par = root;
				}
			}
			if (root != null) {
				root.par = null;
			}

		}
		
		
		
		
		
	}
		

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if(root==null) {
			return null;
		} else if(root.left==null&&root.right==null) {
			return root.data;
		} else {
			root=root.findMin();
			return root.getData();
		}
		
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if(root==null) {
			return null;
		} else if(root.left==null&&root.right==null) {
			return root.data;
		} else {
			root=root.findMax();
			return root.getData();
		}
	}

	@Override
	public boolean empty() {
		if(size==0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub

		if(root==null) {
			return false;
		}else {
			root=root.containsNode(s);
			return root.data.contentEquals(s);
			
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		if(root==null) {
			return -1;
		} else if(root.left==null&&root.right==null) {
			return 0;
		} else {
			return root.getHeight()-1;
		}
	}

}
