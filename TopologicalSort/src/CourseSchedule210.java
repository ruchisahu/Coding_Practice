import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/course-schedule-ii/submissions/
public class CourseSchedule210 {
	//sol1
	 public static int[] findOrder1(int numCourses, int[][] prerequisites) {
	      int ans[] = new int[numCourses];
	        int indegree[] = new int[numCourses];
	        
	        for(int i=0;i<prerequisites.length;i++)
	        {
	            indegree[prerequisites[i][0]]++;
	        }
	        
	        Queue<Integer> bfs = new LinkedList<>();
	        
	        for(int i=0;i<numCourses;i++)
	        {
	            if(indegree[i] == 0)
	                bfs.add(i);
	        }
	    
	        int count = bfs.size();
	        
	        int j=0;
	       
	        while(!bfs.isEmpty())
	        {
	             int comp=bfs.poll();
	            ans[j++]=comp;
	            for(int i=0;i<prerequisites.length;i++)
	            {
	                if(prerequisites[i][1] == comp)
	                {
	                    int dependent=prerequisites[i][0];
	                    indegree[dependent]--;
	                    
	                    if(indegree[dependent] == 0)
	                    {  bfs.add(dependent);
	                     count++;
	                    }
	                }
	            }
	        }
	        return (count == numCourses) ? ans : new int[0];
	        
	    }
	
	    //sol2
	    public static int[] findOrder(int numCourses, int[][] prerequisites) {
	        if (numCourses == 0) {
	            return new int[]{};
	        }
	        Graph G = new Graph(numCourses);
	        for (int[] p : prerequisites) {
	            G.addEdge(p[1], p[0]);
	        }
	      
	        int[] ans = new int[numCourses];
	        
	        DFS dfs = new DFS(G);
	        if (dfs.hasCycle) {
	            return new int[]{};
	        }
	        
	        return dfs.reversePostOrder();
	    }
	 

	public static void main(String[] args) {
		int numCourses=4;
		int[][] prerequisites= {{1,0},{2,0},{3,1},{3,2}};
		//int[] order=findOrder1(numCourses,prerequisites);
		int[] order=findOrder(numCourses,prerequisites);
		for(int i=0;i<order.length;i++)
			System.out.println(order[i]);
		}

	}


