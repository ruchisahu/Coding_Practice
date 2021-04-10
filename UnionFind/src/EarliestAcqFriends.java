import java.util.Arrays;
//1101
//O(nlogn)
//https://www.cnblogs.com/Dylan-Java-NYC/p/11280351.html
public class EarliestAcqFriends {
	public int earliestAcq(int[][] logs, int N) {
		         UF uf= new UF(N);
		         Arrays.sort(logs, (a, b)-> a[0]-b[0]);
		        
		          for(int [] log : logs){
		              if(uf.find(log[1]) != uf.find(log[2])){
		                 uf.union(log[1], log[2]);   
		             }
	            
		             if(uf.count == 1){
		                 return log[0];
		             }
		         }
	         
		         return -1;
		     }
		 
	
	public static void main(String[] args) {
		EarliestAcqFriends e=new EarliestAcqFriends();
		int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
		int N = 6;
		e.earliestAcq(logs,N);

	}

}
