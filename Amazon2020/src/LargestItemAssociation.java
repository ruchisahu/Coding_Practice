//https://leetcode.com/discuss/interview-question/782606/
/*
 * In order to improve customer experience, Amazon has developed a system to provide recommendations to the customer regarding the item they can purchase. Based on historical customer purchase information, an item association can be defined as - If an item A is ordered by a customer, then item B is also likely to be ordered by the same customer (e.g. Book 1 is frequently orderered with Book 2). All items that are linked together by an item association can be considered to be in the same group. An item without any association to any other item can be considered to be in its own item association group of size 1.

Given a list of item association relationships(i.e. group of items likely to be ordered together), write an algorithm that outputs the largest item association group. If two groups have the same number of items then select the group which contains the item that appears first in lexicographic order.

Input
The itput to the function/method consists of an argument - itemAssociation, a list containing paris of string representing the items that are ordered together.

Output
Return a list of strings representing the largest association group sorted lexicographically.

Example
Input:
itemAssociation: [
[Item1, Item2],
[Item3, Item4],
[Item4, Item5]
]

Output:
[Item3, Item4, Item5]

Explanation:
There are two item association groups:
group1: [Item1, Item2]
group2: [Item3,Item4,Item5]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LargestItemAssociation {
	
private static List<String> getLargestAssociation(List<List<String>> itemAssociation){
        
        Map<String, List<String>> graph = new HashMap<>();
        List<List<String>> merged = new ArrayList<>();
        
        for (List<String> items : itemAssociation){
            List<String> vals = graph.getOrDefault(items.get(0), new ArrayList<>());
            vals.add(items.get(1));
            graph.put(items.get(0), vals);
            vals = graph.getOrDefault(items.get(1), new ArrayList<>());
            vals.add(items.get(0));
            graph.put(items.get(1), vals);
        }
        
        Set<String> visited = new HashSet<>();
        for (String key : graph.keySet()){
            List<String> list = new ArrayList<>();
            dfs(key, list, graph, visited);
            if(!list.isEmpty()) {
                Collections.sort(list);
                merged.add(list);
            }
        }
        
        Collections.sort(merged, (List<String> l1, List<String> l2) -> {
            if(l1.size() == l2.size()) {
                    for(int i=0; i<l1.size(); i++) {
                        if(l1.get(i).equals(l2.get(i))) continue;
                        return l1.get(i).compareTo(l2.get(i));
                    }
                }
                return l2.size() - l1.size();
        });
        return merged.get(0);
    }
    
    private static void dfs(String key, List<String> list, Map<String, List<String>> graph, Set<String> visited){
        
        if (visited.contains(key)) return;
        visited.add(key);
        list.add(key);
        for (String neighbour : graph.get(key)){
            dfs(neighbour, list, graph, visited);
        }
    }
    //sol2:pairstring
    public static List<String> largestItemAssociation(List<PairString> psList){
        
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for(PairString ps : psList){
          map.put(ps.first, new TreeSet<String>());
          map.get(ps.first).add(ps.first);
          map.put(ps.second, new TreeSet<String>());    
          map.get(ps.second).add(ps.second);
        }
      
        for(PairString ps : psList){
          map.get(ps.first).addAll(map.get(ps.second));
          map.get(ps.second).addAll(map.get(ps.first));
        }
        
        List<String> list = new ArrayList<String>(map.keySet());
        
        Collections.sort(list, 
                         (l1, l2) -> map.get(l1).size() != map.get(l2).size() 
                         ? Integer.compare(map.get(l2).size(), map.get(l1).size())
                         : map.get(l1).toArray()[0].toString().compareTo(map.get(l2).toArray()[0].toString()));
        
        return new ArrayList<String>(map.get(list.get(0)));
      }
      
    public static void main(String[] args) {
        
        List<List<String>> itemAssociation = new ArrayList<>();
        itemAssociation.add(Arrays.asList("item1", "item2"));
        itemAssociation.add(Arrays.asList("item3", "item4"));
        itemAssociation.add(Arrays.asList("item4", "item5"));
        getLargestAssociation(itemAssociation).forEach(x -> {
           System.out.print(x + " "); 
        });
    }
}