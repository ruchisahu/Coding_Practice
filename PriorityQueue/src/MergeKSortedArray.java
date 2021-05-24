import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {
	private static class ArrayEntry {
	    public Integer value;
	    public Integer arrayId;

	    public ArrayEntry(Integer value, Integer arrayId) {
	      this.value = value;
	      this.arrayId = arrayId;
	    }
	  }
	
	  public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
		  List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
		    for (List<Integer> array : sortedArrays) {
		      iters.add(array.iterator());
		    }
		    PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
		        sortedArrays.size(), (o1, o2) -> Integer.compare(o1.value, o2.value));
		    for (int i = 0; i < iters.size(); ++i) {
		      if (iters.get(i).hasNext()) {
		        minHeap.add(new ArrayEntry(iters.get(i).next(), i));
		      }
		    }

		    List<Integer> result = new ArrayList<>();
		    while (!minHeap.isEmpty()) {
		      ArrayEntry headEntry = minHeap.poll();
		      result.add(headEntry.value);
		      if (iters.get(headEntry.arrayId).hasNext()) {
		        minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(),
		                                   headEntry.arrayId));
		      }
		    }
		    return result;
		    }

	public static void main(String[] args) {
		//private List<Integer> expected=Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		  List<List<Integer>> input =Arrays.asList(
			        Arrays.asList(1, 4, 7),
			        Arrays.asList(2, 5, 8),
			        Arrays.asList(3, 6, 9)
			    );
		  
		  mergeSortedArrays(input);

	}

}
