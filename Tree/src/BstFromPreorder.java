import java.util.ArrayList;
import java.util.List;

public class BstFromPreorder {
	 public static BstNode<Integer>
	  rebuildBSTFromPreorder(List<Integer> preorderSequence) {

	    return rebuildBSTFromPreorderHelper(preorderSequence, 0,
	                                        preorderSequence.size());
	  }

	  // Builds a BST from preorderSequence.subList(start, end).
	  private static BstNode<Integer>
	  rebuildBSTFromPreorderHelper(List<Integer> preorderSequence, int start,
	                               int end) {
	    if (start >= end) {
	      return null;
	    }
	    int transitionPoint = start + 1;
	    while (transitionPoint < end &&
	           Integer.compare(preorderSequence.get(transitionPoint),
	                           preorderSequence.get(start)) < 0) {
	      ++transitionPoint;
	    }
	    return new BstNode<>(
	        preorderSequence.get(start),
	        rebuildBSTFromPreorderHelper(preorderSequence, start + 1,
	                                     transitionPoint),
	        rebuildBSTFromPreorderHelper(preorderSequence, transitionPoint, end));
	  }

	  public static void main(String[] args) {
		  List<Integer> preorderSequence=new ArrayList<>();
		  preorderSequence.add(1);
		  preorderSequence.add(2);
		  preorderSequence.add(3);
		  
		  rebuildBSTFromPreorder(preorderSequence);
	  }
	}

	

