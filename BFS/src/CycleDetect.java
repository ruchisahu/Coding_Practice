import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetect {
	 boolean hasCycle(final int N, final int start, final boolean[] visited, final List<List<Integer>> graph) {
		    visited[start] = true;

		    final int parent[] = new int[N];
		    parent[start] = -1;
	 Queue<Integer> q = new LinkedList<>();
    q.add(start);

    while(!q.isEmpty()) {
      final int node = q.poll();

      // assumes for nodes without edges, an empty list will be returned
      for(int adj : graph.get(node)) {
        if (!visited[adj]) {
          q.add(adj);
          parent[adj] = node;
          visited[adj] = true;
        } else if (parent[node] != adj) {
          return true;
        }
      }
    }

    return false;
  }


//DFS
boolean hasCycle(final int N, final List<List<Integer>> graph) {
     boolean[] visited = new boolean[N];

    for (int vertex = 0; vertex < N; vertex++) {
      if (!visited[vertex] && hasCycle(N, vertex, visited, graph)) {
        return true;
      }
    }

    return false;
  }
}
