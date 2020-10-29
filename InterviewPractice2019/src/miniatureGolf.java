import java.util.Arrays;

public class miniatureGolf 
{
	public static int P;
	public static int H;
	
	
    static int[] ranking(int P, int H, int[][] scores)
    {
    	int[] result=new int[P];
    	Rank[] rank=new Rank[P];
    	int l=100;
    	for(int i=0;i<P;i++)
		{
			for(int j=0;j<H;j++)
			{
				result[i]+=scores[i][j];
				
			}
			if(result[i]>l)
			{
				result[i]=l;
			}
			rank[i]=new Rank(i+1 ,result[i], 0 );
			
		}
    	for(int i=0;i<P;i++)
		{
    		System.out.println(result[i]);
		}
		Arrays.sort(rank);
		System.out.println("befor"+Arrays.toString(rank));
		for(int i=0;i<P;i++)
		{
			
			if(i>0 && i<P && rank[i].score==rank[i-1].score)
			{
				rank[i].position=rank[i-1].position;
			}
			else
				rank[i].position=i+1;
		}
		
		System.out.println(Arrays.toString(rank));
    	return result;
    }
   
	public static void main(String[] args) 
	{
		//test1
		//P = 3;
		//H = 3;
		//int[][] scores= {{2,2,2},{4,2,1},{4,4,1}};
		//ranking(P,H,scores);
		//test2
		P=6;
		H=4;
		int[][] scores= {{3,1,2,2},{4,3,2,2},{6,6,3,2},{7,3,4,3},{3,4,2,4},{2,3,3,5}};
		ranking(P,H,scores);
	}

}
class Rank implements Comparable<Rank> 
{
	int id;
	int position;
	int score;
	public Rank(int id,int score,int position)
	{
		this.id=id;
		this.score=score;
		this.position=position;
	}
	@Override
	public int compareTo(Rank r) {
		
		return this.score-r.score;
	}
	
	public String toString() {
	    return String.format("(%s, %d, %d)", id, score, position);
	}
}