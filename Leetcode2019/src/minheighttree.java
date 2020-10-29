//310 leetcode
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class minheighttree {

	
	    // Time Complexity - O(V+E), Space Complexity - O(V)
	    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
	        if(n==1) return Arrays.asList(0);
	        
	        Map<Integer, Set<Integer>> graph = new HashMap<>();
	        for(int i=0; i<n; i++) graph.put(i, new HashSet<Integer>());
	        
	        //build graph
	        for(int[] edge : edges){
	            //In a bi-directional way
	            graph.get(edge[0]).add(edge[1]); 
	            graph.get(edge[1]).add(edge[0]);
	        }
			
	        // Please note leaves are not the leaves not having any Children like in tree
			// In this approach, we refer leaves to nodes having one node in their value set(corresponding child)
	        // find leaves(having one child) because approach is to cut all nodes having one element in it's child set 
	        // (we call nodes having one child node as leaves here)
	        List<Integer> leaves = new ArrayList<>();
	        for(int i=0; i<n; i++){
	            if(graph.get(i).size()==1) // leaves having child node hence size is 1
	            leaves.add(i); // why we add i? refer diagram (Please note we initially populated set for every index)
	        }
	      //Eat all leaves having one child make sure to cover edge case by taking newLeaves local list
	        //in edge case we will go through more than 1 halve, 
	        //and will cut new leaves (Refer edge case example in diagram)
	         while(n>2){ // why more than 2? because in case of 2 nodes we just need to return leaves
	             // See Edge case from diagram to see why we need local list here
	             // we might need to cover more than one halve
	            List<Integer> newLeaves = new ArrayList<Integer>();
	            n-=leaves.size(); // this is just to break
	            // below for loop will eat all 
	            //eligible leaves(having one child node) in one or more halves depending upon input, more than one halve will use newleaves to cut
	            for(int leaf : leaves){
	                int parent = graph.get(leaf).iterator().next(); // note every parent(Integer-Key) having it's corrsponding children(Set-Value) in set hence need iterator, there is no straight forward way to get items from set without iterator
	                graph.get(parent).remove(leaf); // remove leaf node having its own one child for this parent node in first halve 
	                if(graph.get(parent).size()==1) // let's see if we ate all child nodes in set for this parent node apart from one remaining, hence checking size of parent node's value set(this set contains leaves)
	                 newLeaves.add(parent); // ok congrats, finally this patrent has only one child now, rest got eaten   
	            }
	            leaves = newLeaves; // this is to cover edge case where we need to cover more than one halve
	        }
	        return leaves;
	    }
	    public static void main(String[] arg)
	    {
	    	int n=6;
	    	int[][] edges= {{0,3},{1,3},{2,3},{4,3},{5,4}};
	    	System.out.println(findMinHeightTrees(n, edges));
	    }
	}
