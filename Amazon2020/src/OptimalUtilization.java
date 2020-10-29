import java.util.*;

/*
 Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and 
 the second integer represents a value. Your task is to find an element from a and an element form b such that 
 the sum of their values is less or equal to target and as close to target as possible.
  Return a list of ids of selected elements. If no pair is possible, return an empty list.
  
  Input:
a = [[1, 2], [2, 4], [3, 6]]
b = [[1, 2]]
target = 7

Output: [[2, 1]]

Explanation:
There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
 * */

public class OptimalUtilization {
	
	  public static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) 
	  {
		  List<int[]> result=new  ArrayList<int[]> ();
		  
		  int max=Integer.MIN_VALUE;
		  for(int i=0;i<a.size();i++)
		  {
			  
			  for(int j=0;j<b.size();j++){
				  //a.get(i)[1]
				  int sum=a.get(i)[1] +b.get(j)[1];
				  System.out.println(sum);
				  if(sum<=target){
					  if(sum>=max){
						  if(max==sum)
	  						result.clear();//new max found
						  max=sum;
						  result=new ArrayList<>();
						  int[] sum1=new int[2];
						  sum1[0]=a.get(i)[0];
						  sum1[1]=b.get(j)[0];
						  
						  result.add(sum1);
						  System.out.println("result="+sum1[0]+"   "+sum1[1]);
					  }else{
						  
						  int[] sum1=new int[2];
						  sum1[0]=a.get(i)[0];
						  sum1[1]=b.get(j)[0];
						  
						  result.add(sum1);
					  }
				   }
				}
			}
		
		  
		  return result;
	  }
	  
	  //second sol
	  private static List<int[]> getPairs2(List<int[]> a, List<int[]> b, int target) {
	        
	        Map<Integer, List<int[]>> map = new HashMap<>();
	        
	        for( int[] x : a) {
	            for( int[] y : b) {
	                int sum = x[1] + y[1];
	                if( sum <= target) {
	                    if(!map.containsKey(sum)) {
	                        map.put(sum, new ArrayList<>());
	                    }
	                    map.get(sum).add( new int[]{x[0], y[0]});
	                }
	            }
	        }
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
	        pq.addAll( map.keySet());
	        return map.get(pq.poll());
	    }
	  //sol3 different input
	  public List<List<Integer>> findOptimalUtilization(int[][] forwardRoutes, int[][] returnRoutes, int maxTravelDistance) {
	        if (forwardRoutes == null || returnRoutes == null) {
	            return Collections.emptyList();
	        }

	        Arrays.sort(forwardRoutes, (pair1, pair2) -> pair1[1] - pair2[1]);
	        Arrays.sort(returnRoutes, (pair1, pair2) -> pair1[1] - pair2[1]);

	        List<List<Integer>> result = new ArrayList<>();

	        int diff = Integer.MAX_VALUE;
	        int l = 0, r = returnRoutes.length - 1;
	        while (l < forwardRoutes.length && r >= 0) {
	            int sum = forwardRoutes[l][1] + returnRoutes[r][1];

	            if (maxTravelDistance < sum) {
	                r--; // Decrement r as sum is too large
	            } else {
	                // Reset result and diff as we find a pair of elements whose sum is closer to target
	                if (maxTravelDistance - sum < diff) {
	                    result.clear();
	                    diff = maxTravelDistance - sum;
	                }

	                int right = r;
	                while (right >= 0 && returnRoutes[r][1] == returnRoutes[right][1]) { // Collect all duplicates (see duplicate case example below)
	                    result.add(Arrays.asList(forwardRoutes[l][0], returnRoutes[right][0]));
	                    right--;
	                }

	                l++;
	            }
	        }

	        return result;
	    }
	  
//sol4
	  private static List<List<Integer>> compute(int[][] a, int[][] b, int target) {
	        List<List<Integer>> res = new ArrayList<>();
	        TreeMap<Integer, List<List<Integer>>> tree = new TreeMap<>();

	        for (int i=0; i<a.length; i++) {
	            for (int j=0; j<b.length; j++) {
	                int sum = a[i][1] + b[j][1]; 
	                if (sum <= target) {
	                    List<List<Integer>> list = tree.computeIfAbsent(sum, (k) -> new ArrayList<>());
	                    list.add(Arrays.asList(a[i][0], b[j][0]));
	                }
	            }
	        }

	        return tree.floorEntry(target).getValue();
	    }
	  
	 
	    //sol4
	  public static List<int[]> getPairs1(List<int[]> a, List<int[]> b, int target) 
	  {
	  	int max = Integer.MIN_VALUE;
	  	int VALUE = 1;
	  	int KEY = 0;
	  	Collections.sort(a, (i, j) -> i[1] - j[1]);//ASCENDING
	  	Collections.sort(b, (i, j) -> j[1] - i[1]);//DESCENDING
	  	List<int[]> result = new ArrayList<>();
	  	for(int i=0;i<a.size();i++)
	  	{
	  		int aKey = a.get(i)[KEY];
	  		int aValue = a.get(i)[VALUE];
	  		for(int j=0;j<b.size();j++)
	  		{
	  			int bValue = b.get(j)[VALUE];
	  			int sum = aValue + bValue;
	  			if (sum > target) {
	  				continue;
	  			} else {
	  				if (max <= sum) {
	  					if (max < sum) {
	  						max = sum;
	  						result.clear();//new max found
	  					}
	  					result.add(new int[] { aKey, b.get(j)[KEY] });
	  					
	  					//Check j+1 till end of the b list to find if same bvalue exist otherwise break
	  					for(int k = j + 1; k < b.size(); k++)
	  					{
	  						if(b.get(k)[VALUE] == bValue)
	  						{
	  							result.add(new int[] { aKey, b.get(k)[KEY] });
	  							System.out.println(result.get(0)[0]+"   "+result.get(0)[1]);
	  						}
	  						else
	  						{
	  							break;
	  						}
	  					}
	  				}
	  			}
	  		}
	  	}
	  	return result;
	  }
	  
	  
	public static void main(String[] args) {
		List<int[]> a=new ArrayList<int[]>();
		int[] a1= {1,2};
		int[] a2= {2,4};
		int[] a3= {3,6};
		a.add(a1);
		a.add(a2);
		a.add(a3);
				List<int[]> b=new ArrayList<int[]>();
				int[] b1= {1,2};
				int[] b2= {1,2};
				b.add(b1);
				b.add(b2);
						 int target=7;
				
				
		getPairs(a,b,target);
		//getPairs2(a,b,target);
		
	

	}

}
