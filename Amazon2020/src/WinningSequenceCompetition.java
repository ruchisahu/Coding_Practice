import java.util.Arrays;

//https://aonecode.com/amazon-online-assessment-winning-sequence
//https://leetcode.com/discuss/interview-question/945674/amazon-oa-winning-sequence
public class WinningSequenceCompetition {
	public static int[] winningSequence(int num, int lower, int upper) {

		int delta = upper - lower;

		if (num > 2 * delta + 1) return null; // we cannot form a sequence, there are not enough numbers between lower and upper

		// if we can form a sequence, assume that the element to the left of upper is the starting one
		int starting_number = upper - 1;

		// move to the left until we can form a sequence
		while ((((upper - starting_number) + 1) + delta) < num) {
		  starting_number--;
		}

		// construct the array
		int[] res = new int[num];
		int i = 0;

		// this will fill the elements in the strictly increasing order
		while (starting_number < upper) {
		  res[i++] = starting_number++;
		}

		// we need to place the upper number
		res[i++] = starting_number--;

		// this will fill the elements in the strictly decreasing order
		while (i < num) {
		  res[i++] = starting_number--;
		}

		return res;
		}

		public static void main(String[] args) {

		System.out.println(Arrays.toString(winningSequence(5, 3, 10))); // => [9, 10, 9, 8, 7]
		System.out.println(Arrays.toString(winningSequence(7, 3, 10))); // => [9, 10, 9, 8, 7, 6 ,5]
		System.out.println(Arrays.toString(winningSequence(10, 3, 10))); // => [8, 9, 10, 9, 8, 7, 6, 5, 4, 3]
		System.out.println(Arrays.toString(winningSequence(15, 3, 10))); // => [3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3]
		System.out.println(Arrays.toString(winningSequence(16, 3, 10))); // => null
		//
		System.out.println(Arrays.toString(winningSequence(5, 1, 3))); // => [1, 2, 3, 2, 1]
		System.out.println(Arrays.toString(winningSequence(3, 1, 3))); // => [2, 3, 2]
		//
		System.out.println(Arrays.toString(winningSequence(5, 9, 10))); // => null
		System.out.println(Arrays.toString(winningSequence(5, 10, 10))); // => null
		}

	
}
