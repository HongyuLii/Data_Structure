package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	
	 Node sentinel; //this will be the entry point to your linked list (the head)
	  int size;
	  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
	    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
	    size=0;
	  }

	@Override
	public boolean insert(double elt, int index) {
		// TODO Auto-generated method stub
		
		if(index<0||index>size) {
			return false;
		} else {
			Node inserted_node=new Node(elt);
			if (index==0&&size==0) {
				sentinel.next=inserted_node;
				sentinel.prev=inserted_node;
				inserted_node.next=sentinel;
				inserted_node.prev=sentinel;
				size++;
				return true;
			}else if(index==0&&size>0) {    
				inserted_node.next=sentinel.next;
				sentinel.next.prev=inserted_node;
				inserted_node.prev=sentinel;
				sentinel.next=inserted_node;
				size++;
				return true;
			} else if(index==size) {
				inserted_node.prev=sentinel.prev;
				sentinel.prev.next=inserted_node;
				inserted_node.next=sentinel;
				sentinel.prev=inserted_node;
				size++;
				return true;
			} else {
				Node trav=getNode(index);
				trav.prev.next=inserted_node;
				inserted_node.prev=trav.prev;
				trav.prev=inserted_node;
				inserted_node.next=trav;
				size++;
				return true;
			}

		}
		
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		if(index<0||index>size) {
			return false;
		} else {
			if(index==0&&size==0) {
				return false;
			}else if(index==0&&size>0) {
			
				sentinel.next.next.prev=sentinel;
				sentinel.next=sentinel.next.next;
				
				size--;
				return true;
			} else if (index==size-1) {
				sentinel.prev.prev.next=sentinel;
				sentinel.prev=sentinel.prev.prev;
				size--;
				return true;
			} else {
				Node trav=getNode(index);
				trav.prev.next=trav.next;
				trav.next.prev=trav.prev;
				trav.prev=null;
				trav.next=null;
				size--;
				return true;
			} 
		}
		
		
	}

	@Override
	public double get(int index) {
		// TODO Auto-generated method stub3`M 
		if(size==0) {
			return Double.NaN;
		} else {
			Node iterator = getNode(index);
			return iterator.getData();
		}
		
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		Node iterator = sentinel.next;
		if(iterator==null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void clear() {
		sentinel.next=null;
		sentinel.prev=null;
		this.size=0;
		
		// TODO Auto-generated method stub

	}
	
	public Node getNode(int index) {
		
		Node trav =sentinel;
		for (int i=0; i<=index; i++) {
			trav=trav.next;
		}
		return trav;
		
	}
	
	public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
	    return sentinel;
	  }

}
