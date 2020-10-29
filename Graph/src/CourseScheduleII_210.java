import java.util.*;

public class CourseScheduleII_210 {
	 public static int[] findOrder(int numCourses, int[][] prerequisites) {
		 
		 Digraph G = new Digraph(numCourses);
		 for (int[] edge : prerequisites) 
		 G.addEdge(edge[1],edge[0]);
	        
	        boolean[] visited = new boolean[numCourses];
	        Stack<Integer> stack = new Stack<>();
	        
	        for (int i = 0; i < numCourses; i++) {
	            boolean[] onPath = new boolean[numCourses];
	            if (!visited[i] && !dfs(i, G, onPath, visited, stack)) {
	                return new int[0];
	            }
	        }
	        
	        int[] order = new int[numCourses];
	        for (int i = 0; i < numCourses; i++) {
	            order[i] = stack.pop();
	            System.out.println(order[i]);
	        }
	        return order;
	    }
	    
	    private static boolean dfs(int source, Digraph G, boolean[] onPath, boolean[] visited, Stack<Integer> stack) {
	        onPath[source] = true;
	        visited[source] = true;
	        
	        for (int neighbor : G.adj(source)) {
	            if (onPath[neighbor]) {
	                return false;
	            }
	            if (!visited[neighbor] && !dfs(neighbor, G, onPath, visited, stack)) {
	                return false;
	            }
	        }
	        onPath[source] = false;
	        stack.push(source);
	        return true;
	    }
	    
	    //sol2
	    private class Graph {
	        private List<Integer>[] vertices;
	        public int size;
	        
	        public Graph(int size) {
	            this.vertices = new ArrayList[size];
	            this.size = size;
	            
	            for (int i = 0; i < size; i++) {
	                vertices[i] = new ArrayList();
	            }
	        }
	        
	        private void addEdge(int i, int j) {
	            // System.out.printf("adding edge %d->%d\n", i, j);
	            vertices[i].add(j);
	        }
	        
	        public Iterable<Integer> adjacent(int v) {
	            return vertices[v];
	        }
	    }
	    
	    private class DFS {
	        private Graph G;
	        private boolean onStack[];
	        private boolean marked[];
	        private Deque<Integer> postOrder;
	        public boolean hasCycle;
	        
	        public DFS(Graph G) {
	            this.G = G;
	            onStack = new boolean[G.size];
	            marked = new boolean[G.size];
	            postOrder = new ArrayDeque();
	            
	            for (int v = 0; v < G.size; v++) {
	                if (marked[v]) {
	                    continue;
	                }

	                if (!dfs(v)) {
	                    hasCycle = true;
	                    return;
	                }
	            }
	        }
	    
	        private boolean dfs(int v) {
	            onStack[v] = true;
	            marked[v] = true;

	            for (int w : G.adjacent(v)) {
	                if (onStack[w]) {
	                    return false;
	                }

	                if (marked[w]) {
	                    continue;
	                }

	                if (!dfs(w)) {
	                    return false;
	                }
	            }

	            onStack[v] = false;

	            postOrder.addLast(v);
	            return true;
	        }
	        
	        public int[] reversePostOrder() {
	             System.out.println(postOrder);
	            int[] ans = new int[G.size];
	            int i = 0;
	            while (!postOrder.isEmpty()) {
	                int val = postOrder.pollLast();
	                ans[i++] = val;
	            }
	            
	            return ans;
	        }
	    }

	    public int[] findOrder1(int numCourses, int[][] prerequisites) {
	        if (numCourses == 0) {
	            return new int[]{};
	        }
	        Graph G = new Graph(numCourses);
	        for (int[] p : prerequisites) {
	            G.addEdge(p[1], p[0]);
	        }
	        
	        int v = 0;
	        int ansPtr = 0;
	        int[] ans = new int[numCourses];
	        
	        DFS dfs = new DFS(G);
	        if (dfs.hasCycle) {
	            return new int[]{};
	        }
	        
	        return dfs.reversePostOrder();
	    }
	
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4},{2,3}};
		System.out.println(Arrays.asList(findOrder(n,edges)));
		CourseScheduleII_210 c=new CourseScheduleII_210();
		System.out.println(Arrays.asList(c.findOrder1(n,edges)));
		
		

	}

}
