import java.util.ArrayDeque;
import java.util.Deque;

public class DFS {
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

    public boolean dfs(int v) {
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
        // System.out.println(postOrder);
        int[] ans = new int[G.size];
        int i = 0;
        while (!postOrder.isEmpty()) {
            int val = postOrder.pollLast();
            ans[i++] = val;
        }
        
        return ans;
    }
}