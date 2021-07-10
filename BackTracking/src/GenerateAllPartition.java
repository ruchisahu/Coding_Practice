import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllPartition {
	private void AllPartitions(List<Integer> parts, int whole) {
		
		List<Integer>t=new ArrayList<>();
		helper(parts,t,whole,0);
		
	}

	private void helper(List<Integer> parts,  List<Integer> result,int target,int index) {
		if(target==0) {
			 for(Integer i : result)
	              System.out.print(i + " ");
	           System.out.println();
	           return;
		}
		else if(target<0)return;
		
			for(int i=index;i<parts.size();i++) {
				result.add(parts.get(i));
				helper(parts,result,target-parts.get(i),i);
				result.remove(result.size()-1);
			}
			
		
		
		
	}
	//testing for if given n
private static void AllPartitionsN(int n, int whole) {  //n=8
		
		List<Integer>t=new ArrayList<>();
		helper(n,t,whole,1);
		
	}

	private static void helper(int n,  List<Integer> result,int target,int index) {
		if(target==0) {
			 for(Integer i : result)
	              System.out.print(i + " ");
	           System.out.println();
	           return;
		}
		else if(target<0)return;
		
			for(int i=index;i<=n;i++) {
				result.add(i);
				helper(n,result,target-i,i);
				result.remove(result.size()-1);
			}
			
		
		
		
	}

	public static void main(String[] args) {
		GenerateAllPartition p = new GenerateAllPartition();

        int whole = 8;
        List<Integer> parts = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
   //     p.AllPartitions(parts, whole);

        whole = 16;
        List<Integer> parts1 = Arrays.asList(1, 2, 4);
      //  p.AllPartitions(parts1, whole);
        
        //test
        AllPartitionsN(4,4);

	}

	

}
