import java.util.ArrayList;
import java.util.List;

public class MissingRange163 {
	public static List<String> findMissingRanges(int[] vals, int start, int end) {
		 List<String> ranges = new ArrayList<>();
		 int prev = start - 1;
		 for (int i = 0; i <= vals.length; i++) {
		 int curr = (i == vals.length) ? end + 1 : vals[i];
		 if (curr - prev >= 2) {
		 ranges.add(getRange(prev + 1, curr - 1));
		 }
		 prev = curr;
		 }
		 return ranges;
		}
		private static String getRange(int from, int to) {
		 return (from == to) ? String.valueOf(from) : from + "->" + to;
		}
		
		//sol2
		public static List<String> findMissingRanges1(int[] vals, int start, int end) {
			 List<String> ranges = new ArrayList<>();
			 for (int num:vals) {
				 if(num>start) {
					 ranges.add(getRange(start,num-1));
				 }
				 if(num==end)return ranges;
				 start=num+1;
			 }
			 if(start<=end)ranges.add(getRange(start,(end>start)?end:end));
			 return ranges;
		}
		
	public static void main(String[] args) {
		int[] vals={0, 1, 3, 50, 75};
		int start=0;
		int end=99;
		findMissingRanges(vals,start,end);
		findMissingRanges1(vals,start,end);

	}

}
