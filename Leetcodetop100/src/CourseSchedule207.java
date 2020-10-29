import java.util.*;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 
 */
public class CourseSchedule207 {
	 public static boolean canFinish(int numCourses, int[][] prerequisites) {
		 if(numCourses<0)
			 return false;
		 int[] inDegree=new int[numCourses];
		 for(int[] row:prerequisites)
		 {
			 inDegree[row[0]]++;
		 }
		 Queue<Integer> queue=new ArrayDeque<Integer>();
		 for(int i=0;i<inDegree.length;i++)
		 {
			 if(inDegree[i]==0)
			 {
				 queue.offer(i);
			 }
		 }
		 //Topological sort
		 int count=0;
		 while(!queue.isEmpty())
		 {
			 int c=queue.poll();
			 count++;
			 for(int[]p:prerequisites)
			 {
				 if(c==p[1])
				 {
					 inDegree[p[0]]--;
					 if(inDegree[p[0]]==0)
					 {
						 queue.offer(p[0]);
					 }
				 }
			 }
		 }
	        return count==numCourses;
	    }
	
	public static void main(String[] args) {
		int numCourses=2;
		int[][] prerequisites= {{1,0},{0,1}};
		System.out.println(canFinish(numCourses, prerequisites));

	}

}
