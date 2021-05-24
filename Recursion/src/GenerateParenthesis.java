import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	int count=0;
	 public List<String> generateParenthesis(int n) {
	        List<String>result=new ArrayList<>();
	        if(n==0)return result;
	        helper(n-1,n,"(",result);
			return result;
	        }

	private void helper(int left, int right, String curr, List<String> result) {
		if(left==0 && right==0) {
			result.add(curr);
			count++;
			System.out.println(result);
		}
		if(right>left) {
			helper(left,right-1,curr+")",result);
		}
		if(left>0) {
			helper(left-1,right,curr+"(",result);
		}
		
		
	}
	private int getcount() {
		return count;
		
	}

	public static void main(String[] args) {
		GenerateParenthesis P=new GenerateParenthesis();
		P.generateParenthesis(2);
		System.out.println(P.getcount());
		
		P.generateParenthesis(3);
		System.out.println(P.getcount());

	}

	

}
