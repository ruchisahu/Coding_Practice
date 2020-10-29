import java.util.*;

/*
 * Give a computer with total K memory space, and an array of foreground tasks and background tasks the computer needs to do. Write an algorithm to
 *  find a pair of tasks from each array to maximize the memory usage. Notice the tasks could be done without origin order. 

Input
The input to the function/method consists of three arguments :
foregroundTask, an array representing the memory usage of the foreground tasks, 
backgroundTask, an array representing the memory usage of the background tasks, 
K, the total memory space of the computer.

Output
Return a list of pairs of the task ids. 

Examples 1
Input:
foregroundTasks = [1, 7, 2, 4, 5, 6]
backgroundTasks = [3, 1, 2]
K = 6

Output:
[(3, 2), (4, 1), (5,-1)]
 */
public class optimizeMemoryusage {
public static List<int[]> optimizeMemoryUsage(int[] foregroundTasks, int[] backgroundTasks, int K) {
	List<int[]> result=new ArrayList<int[]>();
//	Arrays.sort(foregroundTasks);
//	Arrays.sort(backgroundTasks);
	for(int i=foregroundTasks.length-1;i>=0;i--) {
		int max=0;
		for(int j=backgroundTasks.length-1;j>=0;j--) {
			int[] temp=new int[2];
			
			if(backgroundTasks[j]!=-1 && foregroundTasks[i]+backgroundTasks[j]<=K && foregroundTasks[i]+backgroundTasks[j]>max)
			{
				temp[0]=i;
				temp[1]=j;
				max=foregroundTasks[i]+backgroundTasks[j];
				System.out.print(i+"  "+j);
				System.out.print("...........");
				result.add(temp);
				backgroundTasks[j]=-1;
				break;
			}
		}
		
	}
	return result;
		
    }
//sol2
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
	public static void main(String[] args) {
		int[] foregroundTasks = {1, 7, 2, 4, 5, 6};
			int[] backgroundTasks = {3, 1, 2};
				int K = 6;
				optimizeMemoryUsage(foregroundTasks, backgroundTasks,K) ;
				
				 int[][][] As = {
				            {{1, 2}, {2, 4}, {3, 6}},
				            {{1, 3}, {2, 5}, {3, 7}, {4, 10}},
				            {{1, 8}, {2, 7}, {3, 14}},
				            {{1, 8}, {2, 15}, {3, 9}}
				        };
				        int[][][] Bs = {
				            {{1, 2}},
				            {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
				            {{1, 5}, {2, 10}, {3, 14}},
				            {{1, 8}, {2, 11}, {3, 12}}
				        };
				        int[] targets = {7, 10, 20, 20};

				        for (int i=0; i<4; i++) {
				            System.out.println(compute(As[i], Bs[i], targets[i]).toString());
				        }

	}

}
