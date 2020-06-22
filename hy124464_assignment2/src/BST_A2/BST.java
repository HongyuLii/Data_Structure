package BST_A2;

public class BST implements BST_Interface {
	
	  public BST_Node root;
	  int size;
	  public BST(){ size=0; root=null; }
	  
	  
	  
	  @Override
	  //used for testing, please leave as is
	  public BST_Node getRoot(){ return root; }

	@Override
	public boolean insert(String s) {
		// TODO Auto-generated method stub
		if(contains(s)==true) {
			return false;
		} else {
			size++;
			if(root==null) {
				root = new BST_Node(s);
				return true;
			}
			return root.insertNode(s);
		}
		 
	}
	
	 

	@Override
	public boolean remove(String s) {
		// TODO Auto-generated method stub
		if(contains(s)==true) {
			size--;
			if(root.data.compareTo(s)==0) {
				if(root.left==null&&root.right==null) {
					root=null;
				}else if(root.left==null&&root.right!=null) {
					String next=root.right.data;
					root.removeNode(root.right.data);
					root.data=next;
				} else if(root.left!=null&&root.right==null){
					String next=root.left.data;
					root.removeNode(root.left.data);
					root.data=next;
				} else {
					String max=root.left.findMax().data;
					root.removeNode(root.left.findMax().data);
					root.data=max;
				}
				return true;
			} else {
				return root.removeNode(s);
			}
		} else  {
			return false;
		}
		
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if(root==null) {
			return null;
		}
		return root.findMin().getData();
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if(root==null) {
			return null;
		}
		return root.findMax().getData();
	
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if(size==0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if(root==null) {
			return false;
		} else {
			return root.containsNode(s);
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if(size<0) {
			size=0;
		}
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
