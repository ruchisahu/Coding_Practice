import java.util.List;

//import robertSedwick.Digraph;
//o(V+E)
public class CourseSchedule207 {
	 public static boolean canFinish(int numCourses, int[][] prerequisites) {
		 Digraph G = new Digraph(numCourses);
		 for (int[] edge : prerequisites) {
		 G.addEdge(edge[1],edge[0]);
		 }
		 boolean[] visited = new boolean[numCourses];
	        for (int i = 0; i < numCourses; i++) {
	            if (hasCycle(i, G, new boolean[numCourses], visited)) {
	                return false;
	            }
	        }
	        return true;
		 
	 }
	 private static boolean hasCycle(int course,Digraph G, boolean[] marked, boolean[] visited) {
		if(marked[course])return true;
		marked[course]=true;
		
		for(int w: G.adj(course)) {
			if(!visited[w] && hasCycle(w, G, marked, visited)) {
				return true;
			}
		}
		visited[course] = true;
		 return false;
		 
	 }

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4},{2,3}};
		System.out.println(canFinish(n,edges));

	}

}
