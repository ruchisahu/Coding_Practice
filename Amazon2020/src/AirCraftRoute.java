/*
 *
 Each aircraft should be assigned two shipping routes at once: one forward route and one return route.
 Due to the complex scheduling of flight plans,
all aircraft have a fixed maximum operating travel distance, and cannot be scheduled to fly a shipping route that requires more travel distance than 
the prescribed maximum operating travel distance.
The goal of the system is to optimize the total operating travel distance of a given aircraft.
A forward/return shipping route pair is considered to be “optimal” if there does not exist another pair that has a higher operating travel distance than this pair, and also has a total less than or equal to the maximum operating travel distance of the aircraft.

For example, if the aircraft has a maximum operating travel distance of 3000 miles,
a forward/return shipping route pair using a total of 2900 miles would be optimal if there does not exist a pair that uses a total operating travel distance of 3000 miles,
but would not be considered optimal if such a pair did exist.Your task is to write an algorithm to optimize the sets of forward/return shipping route pairs that allow the aircraft to be optimally utilized, given a list of forward shipping routes and a list of return shipping routes.

Examples 1:
maxTravelDist=7000
forwardRouteList=[[1,2000][2.4000][3,6000]]
returnRouteList=[[1,2000]]
Output: [[2,1]]

Examples 1:
maxTravelDist=10000
forwardRouteList=[[1,3000][2,5000][3,7000],[4,10000]
returnRouteList=[[1,2000][2,3000][3,4000][4,5000]]
Output: [[2,4],[3,2]]

  */
 

import java.util.*;

public class AirCraftRoute
{
	public static  List<PairInt> getOptimizedUtilize(int maxTravelDist, List<PairInt> forwardRouteList, List<PairInt> returnRouteList)
	{

		List<PairInt> result=new ArrayList<>();
		  int max=Integer.MIN_VALUE;
		  for(int i=0;i<forwardRouteList.size();i++){
			  for(int j=0;j<returnRouteList.size();j++){
				  int sum=forwardRouteList.get(i).second +returnRouteList.get(j).second;
				  if(sum<=maxTravelDist){
					  if(sum>max){
						  max=sum;
						  result=new ArrayList<>();
						  result.add(new PairInt(forwardRouteList.get(i).first, returnRouteList.get(j).first));
					  }else{
						 result.add(new PairInt(forwardRouteList.get(i).first, returnRouteList.get(j).first));
					  }
				   }
				}
			}
			return result;
	}
	//made this sol for optimalutilization
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


	public static void main(String[] args) {
		AirCraftRoute air=new AirCraftRoute();
		List<PairInt> forwardRouteList=new ArrayList<PairInt>();
		List<PairInt> returnRouteList=new ArrayList<PairInt>();
		forwardRouteList.add(new PairInt(1,2000));
		forwardRouteList.add(new PairInt(2,3000));
		forwardRouteList.add(new PairInt(3,4000));
		returnRouteList.add(new PairInt(1,2000));
		System.out.println(getOptimizedUtilize(7000,forwardRouteList,returnRouteList));
		 System.out.println("...............................................");
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
					
					
			System.out.println(getPairs(b,a,target));
			 System.out.println("...............................................");
		//diff input
		
		 int[] maxTravelDists = {7000, 10000, 10000};

	        int[][][] forwardRouteLists ={ {{1, 2000}, {2, 4000}, {3, 6000}},{{1, 2000}, {2, 5000}, {3, 7000}, {4, 10000}}, {{1,3000},{2,5000},{3,7000},{4,10000}}}; 

	        int[][][] returnRouteLists ={ {{1, 2000}}, {{1, 2000}, {2, 3000}, {3, 4000}, {4, 5000}}, {{1,2000},{2,2000},{3,4000},{4,4000}}}; 

	        for(int i = 0; i < maxTravelDists.length; ++i){

	     System.out.println(aircraftUtilization(maxTravelDists[i],forwardRouteLists[i],returnRouteLists[i]));
	    
	     
		
	        }

	}



//same ques input different
public static List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){



    int length1 = forwardRouteList.length;

    int length2 = returnRouteList.length;

    if(length1==0 || length2==0) return new ArrayList<>();

    Arrays.sort(forwardRouteList, (int[] a,int[] b) -> (a[1] - b[1]));

    Arrays.sort(returnRouteList, (int[] a,int[] b) -> (a[1] - b[1]));

    int left = 0;

    int right = length2-1;

    int maxVal = -1;

    HashMap<Integer, List<List<Integer>>> map = new HashMap<>();

    while(left < length1 && right >=0) {

        int sum = forwardRouteList[left][1] + returnRouteList[right][1];

        if(sum > maxTravelDist) {

            --right ;

            continue;

        }

        if(sum >= maxVal) {

            int r = right;

            map.putIfAbsent(sum, new ArrayList<>());

            //check for duplicates

            while(r>=0 && returnRouteList[r][1] == returnRouteList[right][1]){

                List<Integer> list = new ArrayList<>();

                list.add(forwardRouteList[left][0]);

                list.add(returnRouteList[r][0]);

                map.get(sum).add(list);

                --r;

            }

            maxVal = sum;

        }

        ++left;

    }

    return map.get(maxVal);

    

}    

}

//runtime: runtime O(M*N)