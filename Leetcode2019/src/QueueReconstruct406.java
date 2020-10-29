import java.util.Arrays;
import java.util.LinkedList;

public class QueueReconstruct406 
{
	public static int[][] reconstructQueue(int[][] people)
	{
		LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(people,(a,b)->{
            if(a[0]!=b[0])
                return b[0]-a[0];
            return a[1]-b[1];
        });
        for(int[] a:people)
            list.add(a[1],a);
        int[][] res = new int[people.length][2];
        int i=0;
        for(int[] a: list)
        {
        	res[i++]=a;
        	System.out.println(res[i++]);
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[][] people= {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		// TODO Auto-generated method stub
		System.out.println(reconstructQueue(people));

	}

}
