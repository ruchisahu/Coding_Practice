import java.util.Arrays;
import java.util.HashSet;

public class MinCostTorapair2 {
	 public static int minCost(int n, int[][] edges, int[][] edgesToRepair) {
	        if (n == 0) return -1;
	        int[] roots = new int[n + 1];// id -> index + 1
	        Arrays.fill(roots, -1);

	        HashSet<String> broken = new HashSet<>();//record broken edges
	        for (int[] edge : edgesToRepair) {
	            broken.add(Arrays.toString(Arrays.copyOfRange(edge, 0, 2)));
	        }


	        for (int[] edge : edges) {
	            if (broken.contains(Arrays.toString(edge))) continue;
	            int left = find(roots, edge[0]);
	            int right = find(roots, edge[1]);
	            if (left != right) {
	                n--;
	                roots[left] = right;
	            }
	        }
	        int res = 0;
	        Arrays.sort(edgesToRepair, (a, b) -> a[2] - b[2]);
	        for (int[] edge : edgesToRepair) {
	            if (n == 1) break;
	            int left = find(roots, edge[0]);
	            int right = find(roots, edge[1]);
	            if (left == right) continue;
	            roots[left] = right;
	            n--;
	            res += edge[2];
	        }
	        return n == 1 ? res : -1; //return -1 if the graph is not connected, (not possible in the problem)
	    }

	    private static int find(int[] roots, int i) {
	        while (roots[i] != -1) {
	            i = roots[i];
	        }
	        return i;
	    }

	    public static void main(String[] args) {
	        int[][] edges = new int[][]{{1, 2}, {2, 3}, {4, 5}, {3, 5}};
	        int[][] repair = new int[][]{{1, 6, 410}, {2, 4, 800}};
	        System.out.println(minCost(6, edges, repair));

	        edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
	        repair = new int[][]{{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};
	        System.out.println(minCost(5, edges, repair));
	    }
	}


