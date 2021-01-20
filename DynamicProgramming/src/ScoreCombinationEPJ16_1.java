import java.util.*;
//https://massivealgorithms.blogspot.com/2014/09/count-number-of-score-combinations-epi.html
public class ScoreCombinationEPJ16_1 {
	 public static long countCombinations(int k, List<Integer> scoreWays) {
		 long[] combinations = new long[k + 1];
		    combinations[0] = 1; 
		    for (int score : scoreWays) {
		      for (int j = score; j <= k; ++j) {
		        combinations[j] += combinations[j - score];
		      }
		    }
		    return combinations[k];
		 
	 }
	  public static long countPermutations(int k, List<Integer> scoreWays) {
		    long[] permutations = new long[k + 1];
		    permutations[0] = 1; // One way to reach 0.
		    for (int i = 0; i <= k; ++i) {
		      for (int score : scoreWays) {
		        if (i >= score) {
		          permutations[i] += permutations[i - score];
		        }
		      }
		    }
		    return permutations[k];
		  }

	public static void main(String[] args) {
		List<Integer> scoreWays=new ArrayList<Integer>();
		scoreWays.add(2);
		scoreWays.add(3);
		scoreWays.add(7);
		int k=12;
		System.out.println(countCombinations(k,scoreWays));
		
		System.out.println(countPermutations(k,scoreWays));

	}

}
