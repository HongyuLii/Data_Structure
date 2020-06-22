package DiGraph_A5;


public class MinBinHeap implements Heap_Interface {
	
	  private EntryPair[] array; //load this array
	  private int size=0;
	  private static final int arraySize = 10000; //Everything in the array will initially 
	                                              //be null. This is ok! Just build out 
	                                              //from array[1]

	  public MinBinHeap() {
	    this.array = new EntryPair[arraySize];
	    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
	                                             //of child/parent computations...
	                                             //the book/animation page both do this.
	  }
	    
	  //Please do not remove or modify this method! Used to test your entire Heap.
	  @Override
	  public EntryPair[] getHeap() { 
	    return this.array;
	  }

	@Override
	public void delMin() {
		// TODO Auto-generated method stub
		if(size<=0) {
			
		} else {
			EntryPair temp1=array[size];
			array[size]=null;
			array[1]=temp1;
			size--;
			int i=1;

			while(array[i*2+1]!=null||array[i*2]!=null) {
				if(array[i*2+1]==null&&array[i*2]!=null) {
						if(array[i].priority>=array[i*2].priority) {
							EntryPair temp=array[2*i];
							array[2*i]=array[i];
							array[i]=temp;
						}	
						i=2*i;			
				} else if(array[i*2+1]!=null&&array[i*2]!=null) {
					if(array[2*i].priority>array[2*i+1].priority) {
						if(array[i].priority>=array[i*2+1].priority) {
							EntryPair temp=array[2*i+1];
							array[2*i+1]=array[i];
							array[i]=temp;
						}		
							i=2*i+1;
					} else {
						if(array[i].priority>=array[i*2].priority) {
							EntryPair temp=array[2*i];
							array[2*i]=array[i];
							array[i]=temp;
						}
							i=2*i;
					}
				}
			}	
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stu
		return size;

	}

	@Override
	public void insert(EntryPair entry) {
		// TODO Auto-generated method stub
		if(entry==null) {
			
		}
		if(array==null) {
			size++;
			array[1]=entry;
		} else {
			size++;
			array[size]=entry;
			int j=size;
			int i=j/2;
			while(array[j].priority<array[i].priority) {
				EntryPair temp=array[j];
				array[j]=array[i];
				array[i]=temp;
				j=i;
				i=i/2;
			}
		}
		
		
	}

	@Override
	public EntryPair getMin() {
		// TODO Auto-generated method stub
		if(array==null) {
			return null;
		} else {
			return array[1];
		}
	}

	@Override
	public void build(EntryPair[] entries) {
		// TODO Auto-generated method stub
		
//		if(entries==null) {
//			
//		} else {
//			
//			for(int i=0; i<entries.length;i++) {
//				this.insert(entries[i]);
//			}
		
		for(int i=0; i<entries.length; i++) {
			array[i+1]=entries[i];
			size++;
		}
			int i=entries.length, j=i/2, v=j;
			
			if(i<=1) {
			} else {
//				for(int b=0; b<v; b++) {
//					j=v;
					for(j=i/2; j>=1; j--) {
				
						int k=j;
						while(k<=i/2) {
							int m=k*2, n=k*2+1;
							if(n>i) {
								if(array[k].priority>=array[m].priority) {
									EntryPair temp=array[m];
									array[m]=array[k];
									array[k]=temp;
									k=m;
								}else {
									break;
								}
							} else if(array[n]!=null&&array[m]!=null) {
								if(array[n].priority>array[m].priority) {
									if(array[k].priority>=array[m].priority||array[k].priority>=array[n].priority) {
										EntryPair temp=array[m];
										array[m]=array[k];
										array[k]=temp;
										k=m;
									} else {
										break;
									}
									
								} else {
									if(array[k].priority>=array[m].priority||array[k].priority>=array[n].priority) {
										EntryPair temp=array[n];
										array[n]=array[k];
										array[k]=temp;
										k=n;
									} else {
										break;
									}
								}
							}
							
							
						}
						
					
					
					
				}
				}
				
		}
			
	}
//}


