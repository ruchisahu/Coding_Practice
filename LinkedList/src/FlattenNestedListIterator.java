import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {
	
	  // This is the interface that allows for creating nested lists.
	  // You should not implement it, or speculate about its implementation
	  public interface NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	     public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	     // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }
	 
	  
		  private List<Integer> flattenedList;
		  private Iterator<Integer> it;
		  public FlattenNestedListIterator(List<NestedInteger> nestedList) {
			  flattenedList=new LinkedList<Integer>();
			  flatten(nestedList);
			  it = flattenedList.iterator();
		  }
		  

	private void flatten(List<NestedInteger> nestedList) {
		 for (NestedInteger i : nestedList) {
		        if (i.isInteger()) {
		            flattenedList.add(i.getInteger());
		        } else {
		            flatten(i.getList());
		        }
		    }
			
			
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	@Override
	public Integer next() {
	    return it.next();
	}

	@Override
	public boolean hasNext() {
	    return it.hasNext();
	}

}
