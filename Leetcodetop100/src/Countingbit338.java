/*
 Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
Example 1:
Input: 2
Output: [0,1,1]
Example 2:
Input: 5
Output: [0,1,1,2,1,2]
 */
public class Countingbit338
{
	public static int[] countBits(int num)
    {
        int[] result=new int[num+1];
      for(int i=0;i<=num;i++)
      {
          int n=countbit(i);
          result[i]=n;
          System.out.println(n);
      }
      
        return result;
    }

	private static int countbit(int m)
	{
		int count=0;
		while(m!=0)
		{
			int n=m%2;
			m=m/2;
			if(n==1)
			{
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		countBits(5);

	}

}
