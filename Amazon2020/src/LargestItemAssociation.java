//https://leetcode.com/discuss/interview-question/782606/
import java.util.ArrayList;
import java.util.List;

public class LargestItemAssociation {
	
		public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
			for(PairString item:itemAssociation) {
				String f=item.first;
				String s=item.second;
				
				//union(f,s);
				
			}
			return null;
			// write your code here
		}
		private int count = 0;
        private String[] parent, rank;
        
        public LargestItemAssociation(int n) {
            count = n;
            parent = new String[n];
            rank = new String[n];
          /*  for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            */
        }
	/*	public boolean union(String u, String v) {
	        int parent_u = find(u);
	        int parent_v = find(v);
	        if (parent_u == parent_v) {
	         
	            return false;
	        }
	       
	        if (rank[parent_u] > rank[parent_v]) {
	            parent[parent_v] = parent_u;
	        } else if (rank[parent_u] < rank[parent_v]) {
	            parent[parent_u] = parent_v;
	        } else {
	            
	            parent[parent_v] = parent_u;
	           
	            rank[parent_u] += 1;
	        }
	        return true;
	    }
		
		 public int find(String node) {
		       
		        if (node != parent[node]) {
		         
		            parent[node] = find(parent[node]);
		        }
		        return parent[node];
		        
	*/	        

		    
	

	

	public static void main(String[] args) {
		  List<PairString> itemAssociation1 = new ArrayList(){
	            {
	                add(new PairString("item1", "item2"));
	                add(new PairString("item3", "item4"));
	                add(new PairString("item4", "item5"));
	            }
	        };
	   /*     List<PairString> itemAssociation2 = new ArrayList(){
	            {
	                add(new PairString("item1", "item2"));
	                add(new PairString("item3", "item4"));
	                add(new PairString("item4", "item5"));
	                add(new PairString("item6", "item7"));
	                add(new PairString("item6", "item8"));
	            }
	        };
	        List<PairString> itemAssociation3 = new ArrayList(){
	            {
	                add(new PairString("item1", "item2"));
	                add(new PairString("item4", "item5"));
	                add(new PairString("item3", "item4"));
	                add(new PairString("item1", "item4"));
	            }
	        };
	        */
	        LargestItemAssociation s = new LargestItemAssociation(5);
	       
	        System.out.println(s.largestItemAssociation(itemAssociation1)); // Output: [item3, item4, item5]
	      //  System.out.println(s.largestItemAssociation(itemAssociation2)); // Output: [item3, item4, item5], here we got same size, so have to sort lexicographical.
	      //  System.out.println(s.largestItemAssociation(itemAssociation3)); // Output: [item1, item2, item3, item4, item5]
		}

	}

	
	


