import java.util.Arrays;

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

	public static void main(String[] args) {
		ConnectedCitiesMinCose c=new ConnectedCitiesMinCose();
		int N = 3; 
	//	int[][]connections = {{1,2,5},{1,3,6},{2,3,1}};
		int[][]connections = {{0,1,5},{0,2,6},{1,2,1}};
		System.out.println(c.minimumCost(N, connections));
	}

}
