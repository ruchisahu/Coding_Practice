import java.util.Arrays;

public class sortCenter 
{
public static int[] selection(int[] space, int truck)
{
	int[] result=new int[2];
	int max=0;
	Arrays.sort(space);
	int j=space.length-1;
	int i=0;
	while(i<j)
	{
		int val=space[i] + space[j];
		if( val>max && val<=truck )
		{
			max=val;
			result[0]=i;
					result[1]=j;
					
		}
		else if(val>truck)
		{
			j-- ;
		}
		else
			i++;
		
	}
	System.out.println(result[0]);
	System.out.println(result[1]);
	return result;
	}
	public static void main(String[] args)
	{
		int[] packagesSpace = {1, 10, 25, 35, 60};
		int truckspace=90;
		 selection(packagesSpace,truckspace-30);

	}

}
