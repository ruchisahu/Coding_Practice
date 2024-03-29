

	import java.util.*;
	import java.io.*;

	public class DeadEnd {

		public static int n;
		public static HashSet[] graph;
		public static int[] degree;
		public static int[] comp;
		
		public static void main(String[] args) throws Exception {
		
			// Set up graph.
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer tok = new StringTokenizer(stdin.readLine());
			n = Integer.parseInt(tok.nextToken());
			int e = Integer.parseInt(tok.nextToken());
			graph = new HashSet[n];
			for (int i=0; i<n; i++) 
				graph[i] = new HashSet<Integer>();
			degree = new int[n];
			
			// Read it in.
			for (int i=0; i<e; i++)
			{
				tok = new StringTokenizer(stdin.readLine());
				int v1 = Integer.parseInt(tok.nextToken()) - 1;
				int v2 = Integer.parseInt(tok.nextToken()) - 1;
				graph[v1].add(v2);
				graph[v2].add(v1);
				degree[v1]++;
				degree[v2]++;
			}

			// Keep track of graph components.
			comp = new int[n];
			int id = 0;
			Arrays.fill(comp, -1);
			for (int i=0; i<n; i++)
			{
				System.out.println("comp"+i+"="+comp[i]);
				if (comp[i] == -1) 
				{
					dfs(i, id);
					id++;
				}
			}		
		
			boolean[] isTree = new boolean[id];
			
			// Get the sum of the degrees of each component.
			int[] sumdeg = new int[id];
			int[] compsize = new int[id];
			for (int i=0; i<n; i++) {
				sumdeg[comp[i]] += degree[i]; 
				compsize[comp[i]]++;
			}
			
			// Here is my tree check.
			for (int i=0; i<id; i++)
				isTree[i] = (2*compsize[i] - 2 == sumdeg[i]);
					
			// My pair is my "parent" in the tree structure when we start out roadblocks at all the "leaf" nodes.
			int[] mypair = new int[n];
			
			// This will store each of a node's kids.
			HashSet[] mykids = new HashSet[n];
			for (int i=0; i<n; i++) mykids[i] = new HashSet<Integer>();
			
			// We'll set in[i] to true if we are roadblocking node i.
			boolean[] in = new boolean[n];
			
			// Queue for my algorithm.
			LinkedList<Integer> q = new LinkedList<Integer>();
			
			Arrays.fill(mypair, -1);
			
			// Find each node with degree 1 and load up the queue.
			for (int i=0; i<n; i++) {
				if (degree[i] == 1) {
					
					// Annoying because of my HashSet storage to get my only neighbor.
					int dad = -1;
					HashSet<Integer> tmp = (HashSet<Integer>)graph[i];
					for (int x : tmp)
						dad = x;
					 
					// Bookkeeping - adding i to dad in set.
					mypair[i] = dad;
					mykids[dad].add(i);
					in[i] = true;
					q.offer(i);
				}
			}
			
			// Run until we can "choke" the graph any more.
			while (q.size() > 0) {
				
				// Get next item, means we are removing this edge.
				int cur = q.poll();
				int par = mypair[cur];
				degree[par]--;
				
				// The tree case is weird, we do nothing in the tree case, so this works.
				if (isTree[comp[par]]) continue;
				
				// New choke node if we have one node left for my storage, I need that extra check.
				if (degree[par] == 1 && graph[par].size() > mykids[par].size()) {
					
					// We can take off all the old kid road blocks and add one to par.
					for (int all: (HashSet<Integer>)graph[par]) {
						
						// Old ones off.
						if ( ((HashSet<Integer>)mykids[par]).contains(all)) {
							in[all] = false;
						}
						
						// Here we add the new one.
						else {
							in[par] = true;
							mypair[par] = all;
							mykids[all].add(par);
							q.offer(par);
						}
					}
				}
			}
			
			// We build the result here, again the tree case is weird.
			ArrayList<edge> res = new ArrayList<edge>();
			for (int i=0; i<n; i++) {
				if (in[i]) {
					if (isTree[comp[i]])
						res.add(new edge(i, mypair[i]));
					else
						res.add(new edge(mypair[i], i));
				}
			}
			Collections.sort(res);
			
			// Ta da!
			System.out.println(res.size());
			for (int i=0; i<res.size(); i++)
				System.out.println(res.get(i));
		}
		
		// A regular DFS...
		public static void dfs(int v, int cur) {
			comp[v] = cur;
			for (Integer x: (HashSet<Integer>)graph[v])
				if (comp[x] == -1)
					dfs(x, cur);
		}

	}

	class edge implements Comparable<edge> {
		
		public int v1;
		public int v2;
		
		public edge(int a, int b) {
			v1 = a;
			v2 = b;
		}
		
		public int compareTo(edge other) {
			if (v1 != other.v1) return v1 - other.v1;
			return v2 - other.v2;
		}
		
		public String toString() {
			return (v1+1)+" "+(v2+1);
		}
	}