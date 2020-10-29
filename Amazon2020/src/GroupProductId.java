import java.util.*;

/*
 * Given a list of Product Id pairs, group them according to their categories and return the new list containing categorized Product Ids.

Input: ((1,2), (2,5), (3,4), (4,6), (6,8), (5,7), (5,2), (5,2))

Output: ((1,2,5,7), (3,4,6,8))

Test case I came up with:

Input: ((1,2), (2,5), (3,4), (4,6), (6,8), (5,7), (5,2), (3,1))

Output: ((1,2,5,7,3,4,6,8))
 */
public class GroupProductId {
	 private Map<Integer, List<Integer>> graph = new HashMap<>();

	    public List<List<Integer>> getCatagories(List<int[]> productlist){

	        for(int[] prods : productlist){
	            graph.putIfAbsent(prods[0], new ArrayList<>());
	            graph.putIfAbsent(prods[1], new ArrayList<>());

	            graph.get(prods[0]).add(prods[1]);
	            graph.get(prods[1]).add(prods[0]);
	        }

	        Set<Integer> visited = new HashSet<>();
	        List<List<Integer>> result = new ArrayList();

	        for(int key: graph.keySet()){
	            if(!visited.contains(key)){
	                List<Integer> group = new ArrayList();
	                dfs(key, group, visited);
	                result.add(group);
	            }
	        }

	        return result;

	    }

	    private List<Integer> dfs(int node, List<Integer> group, Set<Integer> visited){
	        if(!graph.containsKey(node) || visited.contains(node)) return group;

	        visited.add(node);
	        group.add(node);
	        List<Integer> children = graph.get(node);
	        for(Integer child: children){
	            if(!visited.contains(child)){
	                dfs(child, group, visited);
	            }
	        }
	        return group;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
