import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.cnblogs.com/Dylan-Java-NYC/p/11280623.html
//leetcode 1135
//o(nlogn) space o(n)
//You are given connections, where each connections[i] = [city1, city2, cost] 
public class ConnectedCitiesMinCose {
	 public int minimumCost(int N, int[][] connections) {
		Arrays.sort(connections,(a,b)->a[2]-b[2]);
		int res=0;
		UF uf=new UF(N);
		for(int[] connect:connections) {
			if(uf.find(connect[0])!=uf.find(connect[1])) {
				uf.union(connect[0],connect[1]);
				res+=connect[2];
			}
			if(uf.count==1)return res;
		}
		 return -1;
		 
	 }
//sol2
	 private class connect {
	        public int from;
	        public int to;
	        public int cost;
	        public connect(int from, int to, int cost) {
	            this.from = from;
	            this.to = to;
	            this.cost = cost;
	        }
	    }
	    
	    private class connectComparator implements Comparator<connect> {
	        public int compare(connect a, connect b) {
	            return a.cost - b.cost;
	        }
	    }

	 public int minimumCost1(int N, int[][] connections) {
	        if(connections == null || connections.length == 0 || connections[0].length == 0) {
	            return -1;
	        }
	        PriorityQueue<connect> pq = new PriorityQueue(N);
	        for(int[] e : connections) {
	            pq.add(new connect(e[0], e[1], e[2]));
	        }
	        
	        UF uf = new UF(N);
	        int totalcost = 0;
	        while(!pq.isEmpty()) {
	            connect con = pq.poll();
	            int a = con.from;
	            int b = con.to;
	            if(uf.find(a) != uf.find(b)) {
	                uf.union(a, b);
	                totalcost += con.cost;
	            }
	        }
	        
	        if(uf.count == 1) {
	            return totalcost;
	        } 
	        return -1;
	    }

	public static void main(String[] args) {
		ConnectedCitiesMinCose c=new ConnectedCitiesMinCose();
		int N = 3; 
	//	int[][]connections = {{1,2,5},{1,3,6},{2,3,1}};
		int[][]connections = {{0,1,5},{0,2,6},{1,2,1}};
		System.out.println(c.minimumCost(N, connections));
	}

}
