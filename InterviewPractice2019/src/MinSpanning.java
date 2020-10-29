import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Minimum Spanning Tree
Given a list of Connections, which is the Connection class (the city name at both ends of the edge and a cost between them),
 find some edges, connect all the cities and spend the least amount.
Return the connects if can connect all the cities, otherwise return empty list.
Return the connections sorted by the cost, or sorted city1 name if their cost is same, 
or sorted city2 if their city1 name is also same.

*/
public class MinSpanning {
	public List<Connection> lowestCost(List<Connection> connections) {
        // Sort the list
        Collections.sort(connections, new Comparator<Connection>(){
            public int compare(Connection c1, Connection c2) {
                if (c1.cost != c2.cost) {
                    return (c1.cost - c2.cost);
                }
                if (!c1.city1.equals(c2.city1)) {
                    return c1.city1.compareTo(c2.city1);
                }
                return c1.city2.compareTo(c2.city2);
            }
        });
        
        //give each city id
        Map<String, Integer> nameId = new HashMap<>();
        int id = 0;
        for (Connection connect : connections) {
            if (!nameId.containsKey(connect.city1)) {
                nameId.put(connect.city1, ++id);
            }
            if (!nameId.containsKey(connect.city2)) {
                nameId.put(connect.city2, ++id);
            }
        }
        
        //initial father array
        int[] father = new int[id + 1];
        for (int i = 1; i < id + 1; i++) {
            father[i] = i;
        }
        
        //union find
        List<Connection> result = new ArrayList<>();
        for (Connection connect : connections) {
            int id1 = nameId.get(connect.city1);
            int id2 = nameId.get(connect.city2);
            
            if (find(father, id1) != find(father, id2)) {
                union(father, id1, id2);
                result.add(connect);
            }
        }
        
        // id = node number, size() = edge number = node number - 1
        return (result.size() == id - 1) ? result : new ArrayList<Connection>();
    }
    
    private int find (int[] father, int id) {
        if (father[id] == id) {
            return id;
        }
        
        return father[id] = find(father, father[id]);
    }
    
    private void union (int[] father, int id1, int id2) {
        int father1 = find(father, id1);
        int father2 = find(father, id2);
        
        father[father1] = father2;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
// Definition for a Connection.
 class Connection 
 {
  public String city1, city2;
   public int cost;
  public Connection(String city1, String city2, int cost) {
       this.city1 = city1;
       this.city2 = city2;
       this.cost = cost;
   }
 }