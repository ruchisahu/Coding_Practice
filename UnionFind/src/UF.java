class UF{
		     int [] parent;
		     int [] size;
		     int count;
		     
		     public UF(int n){
		         this.parent = new int[n];
		         this.size = new int[n];
		         for(int i = 0; i<n; i++){
		             parent[i] = i;
		             size[i] = 1;
		         }
		         
		         this.count = n;
		     }
		     
		     public int find(int i){
		         while(i != parent[i]){
		             parent[i] = parent[parent[i]];
		             i = parent[i];
		         }
		         
		         return parent[i];
		     }
		    
		     public void union(int p, int q){
		         int i = find(p);
		         int j = find(q);
		         if(size[i] > size[j]){
		             parent[j] = i;
		            size[i] += size[j];
		         }else{
		             parent[i] = j;
		           size[j] += size[i];
		        }
		        
		         this.count--;
		     }
}
//implementation2
/*
 * private static class UnionFind<T> {
        private HashMap<T, T> f = new HashMap<>();
        
        T find(T x) {
            T y = f.getOrDefault(x, x);
            
            if(y != x) {
                y = find(y);
                f.put(x, y);
            }
            return y;
        }
        
        void union(T x, T y) {
            f.put(find(x), find(y));
        }
    }
 */
