import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MovieDuration 
{
	public static List<Integer> movieDuration(List<Integer> movie,int duration)
	{
		List<Integer> result = null;
	
		 if(movie == null | movie.size()==0)
	            return result;
		
		int max=0;
		for(int i=0;i<movie.size();i++)
		{
			for(int j=i;j<movie.size();j++)
			{
				int total=movie.get(i) + movie.get(j);
			
			if(total < 220)
			{
				if(total> max) 
				{
					max=total;
					result=new ArrayList<Integer>();
					result.add(movie.get(i));
					result.add(movie.get(j));
				}
			}
			
			}
		}
		return result;
	}
//////////////////////////////////////////////////////////////using two pointer
	public static int [] movieDuration1(int [] nums, int d)
	{
		int [] result = new int [2];
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = nums.length-1;
		Arrays.sort(nums);
		int i = 0;
		int j = 0;
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		while(start <= end)
		{
			if((nums[start] + nums[end])<= d-30)
			{
				
				if(max < (nums[start] + nums[end]))
				{
					max = (nums[start] + nums[end]);
					i = nums[start];
					j = nums[end];
				}
				start++;
			
			}
			else if((nums[start] + nums[end]) > d-30)
					{
						end--;
					}
		}
		result[0] = i;
		result[1] = j;
		System.out.println("second sol"+result[0]+result[1]);
		return result;
	}
	
		
	
	public static void main(String[] args) 
	{
		List<Integer> movie=new ArrayList<Integer>();
		//int[] movie_d = {90, 85, 75, 60, 120, 150, 125};
		movie.add(90);
		movie.add(85);
		movie.add(75);
		movie.add(60);
		movie.add(120);
		movie.add(150);
		movie.add(125);
		int duration=250;
		System.out.println(movieDuration(movie,duration));
		
		int [] nums =  new int [] {90, 85, 75, 60, 120, 150, 125};
		movieDuration1(nums,duration);
		
		
	}

}
