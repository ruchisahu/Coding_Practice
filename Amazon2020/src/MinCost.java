/*
 There's an undirected connected graph with n nodes labeled 1..n. But some of the edges has been broken disconnecting the graph. 
Find the minimum cost to repair the edges so that all the nodes are once again accessible from each other.

Input:

    n, an int representing the total number of nodes.
    edges, a list of integer pair representing the nodes connected by an edge.
    edgesToRepair, a list where each element is a triplet representing the pair of nodes between which an edge is currently broken and the cost of repearing that edge, respectively (e.g. [1, 2, 12] means to repear an edge between nodes 1 and 2, the cost would be 12).

Example 1:

Input: n = 5, edges = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]], edgesToRepair = [[1, 2, 12], [3, 4, 30], [1, 5, 8]]
Output: 20
Explanation:
There are 3 connected components due to broken edges: [1], [2, 3] and [4, 5].
We can connect these components into a single component by repearing the edges between nodes 1 and 2, and nodes 1 and 5 at a minimum cost 12 + 8 = 20.

Example 2:

Input: n = 6, edges = [[1, 2], [2, 3], [4, 5], [3, 5], [1, 6], [2, 4]], edgesToRepair = [[1, 6, 410], [2, 4, 800]]
Output: 410

 */
	import java.util.*;

	/**
	 * https://github.com/s-chepurnov/LeetCode/blob/master/MinimalCostToRepairRoads.java

	 * Notice, that the major logic is in methods:
	 * MinimalCostToRepairRoads#solve()
	 * KruskalMST#KruskalMST()
	 */
	public class MinCost {

	    public static void main(String[] args) {
		int numTotalAvailableCities = 5;
		int numTotalAvailableRoads = 5;
		int numRoadsToBeRepaired = 3;

		EdgeWeightedGraph g = new EdgeWeightedGraph(numTotalAvailableRoads + 1);
		g.addEdge(new Edge(1,2,12));
		g.addEdge(new Edge(2,3,0));
		g.addEdge(new Edge(3,4,30));
		g.addEdge(new Edge(4,5,0));
		g.addEdge(new Edge(5,1,8));

		int minCost = solve(g);
		System.out.println("minimal cost to repair roads and connect all cities: " + minCost);
	    }

	    public static int solve(EdgeWeightedGraph g) {

		UF uf = new UF(g.V);
		//no need to repair, already connected
		uf.union(2,3);
		uf.union(4,5);

		KruskalMST mst = new KruskalMST(g, uf);

		for (Edge e : mst.mst) {
		    System.out.println(" " + e);
		}

		return mst.weight;
	    }
	}

	    class KruskalMST {

	    public Queue<Edge> mst = new LinkedList<Edge>();  // edges in MST
	    public int weight;                                // weight of MST
	    public UF uf;

	    public KruskalMST(EdgeWeightedGraph g, UF uf) {
		this.uf = uf;
		PriorityQueue<Edge> minHeap = new PriorityQueue<Edge>(10, (o1, o2) -> {
		    return o1.compareTo(o2);
		});

		for (Edge e : g.edges()) {
		    minHeap.add(e);
		}

		while ( !minHeap.isEmpty() && mst.size() <= (g.V - 1) ) {
		    Edge e = minHeap.poll();

		    int p = e.either();
		    int q = e.other(p);

		    if( !uf.connected(p,q)) {
		        uf.union(p,q);
		        mst.offer(e);
		        weight += e.weight;
		    }
		}

	    }
	}

	class Edge implements Comparable<Edge> {

	    int v;
	    int w;
	    int weight;

	    public Edge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	    }

	    public int either() {
		return v;
	    }

	    public int other(int other) {
		if (other == v) return w;
		else if (other == w) return v;
		else throw new IllegalArgumentException("Illegal endpoint");
	    }

	    public int compareTo(Edge that) {
		if( this.weight > that.weight )
		    return 1;
		else if ( this.weight < that.weight )
		    return -1;
		else
		    return 0;
	    }

	    public String toString() {
		return String.format("%d-%d %d", v, w, weight);
	    }
	}

	class EdgeWeightedGraph {

	    private static final String NEWLINE = System.getProperty("line.separator");
	    public final int V;
	    public int E;
	    public List<Edge>[] adj;

	    public EdgeWeightedGraph(int N) {
		this.V = N;
		this.E = 0;
		adj = (ArrayList<Edge>[]) new ArrayList[N];

		for (int i = 0; i < N; i++) {
		    adj[i] = new ArrayList<Edge>();
		}

	    }

	    public void addEdge(Edge edge) {
		int v = edge.either();
		int w = edge.other(v);

		adj[v].add(edge);
		adj[w].add(edge);
		E++;
	    }

	    public List<Edge> adj(int v) {
		return adj[v];
	    }

	    public List<Edge> edges() {
		List<Edge> list = new ArrayList<Edge>();

		for (int v = 0; v < V; v++) {
		    int selfLoops = 0;
		    for (Edge e : adj(v)) {
		        if (e.other(v) > v) {
		            list.add(e);
		        }
		        // add only one copy of each self loop (self loops will be consecutive)
		        else if (e.other(v) == v) {
		            if (selfLoops % 2 == 0) list.add(e);
		            selfLoops++;
		        }
		    }
		}

		return list;
	    }

	    public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " " + E + NEWLINE);
		for (int v = 0; v < V; v++) {
		    s.append(v + ": ");
		    for (Edge e : adj[v]) {
		        s.append(e + "  ");
		    }
		    s.append(NEWLINE);
		}
		return s.toString();
	    }

	}

	class UF {

	    private int[] parent;  // parent[i] = parent of i
	    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
	    private int count;     // number of components

	    public UF (int n) {
		if (n < 0) throw new IllegalArgumentException();
		count = n;
		parent = new int[n];
		rank = new byte[n];
		for (int i = 0; i < n; i++) {
		    parent[i] = i;
		    rank[i] = 0;
		}
	    }

	    public int find(int p) {
		validate(p);
		while (p != parent[p]) {
		    parent[p] = parent[parent[p]];    // path compression by halving
		    p = parent[p];
		}
		return p;
	    }

	    public boolean connected(int p, int q) {
		return find(p) == find(q);
	    }

	    // validate that p is a valid index
	    private void validate(int p) {
		int n = parent.length;
		if (p < 0 || p >= n) {
		    throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
		}
	    }

	    public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) return;

		// make root of smaller rank point to root of larger rank
		if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
		else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
		else {
		    parent[rootQ] = rootP;
		    rank[rootP]++;
		}
		count--;
	    }
	}