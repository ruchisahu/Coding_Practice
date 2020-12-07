import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/discuss/interview-question/865660/
public class ItemsInContainer {
	//my sol working
	   public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
		   List<Integer> result=new ArrayList<Integer>();
		   for(int i=0;i<startIndices.size();i++) {
			   int st=startIndices.get(i)-1;
			   int end=endIndices.get(i);
			   Stack<Integer>stack=new Stack<Integer>();
			   result.add(count(s.substring(st, end),stack,st,end));   //"|**|*|*"
		   }
		return result;
		   
	   }

	private static Integer count(String string,Stack<Integer> stack, int st, int end) {
		int flag=0;
		int count=0,max=0;
		for(char s:string.toCharArray()) {
			if(s=='|')
				flag=1;
			if(s=='*' && flag==1) {
			//	stack.push((int) s);
				count++;
				
			}
			if(flag==1 && s=='|') {
				max=count;
			}
			
		}
		return max;
	}
//others
	private static int[] getItems(String s, int[] startIndex, int[] endIndex) {
        int[] answer = new int[endIndex.length];

        for (int i = 0; i < startIndex.length; i++) {
            int j=startIndex[i]-1, k = endIndex[i]-1;
            while (j < endIndex[i]){
                if(s.charAt(j) == '|'){
                    break;
                }
                j++;
            }

            while(k > startIndex[i]){
                if(s.charAt(k) == '|'){
                    break;
                }
                k--;
            }
            int count = 0;
            for(int p = j; p<k; p++){
                if(s.charAt(p) == '*'){
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
	public static void main(String[] args) {
		
		String s1 = "|**|*|*";
        System.out.println("Items in " + s1 + " : " + numberOfItems(s1, Arrays.asList(1, 1), Arrays.asList(5, 6))); // Output is [2, 3]
        
        String s2 = "*|*";
        System.out.println("Items in " + s2 + " : " + numberOfItems(s2, Arrays.asList(1), Arrays.asList(3))); // Output is [0]
        
        String s3 = "****|*|";
        System.out.println("Items in " + s3 + " : " + numberOfItems(s1, Arrays.asList(1, 4, 2), Arrays.asList(3, 7, 7))); // Output is [0, 1, 1]

	}

}
