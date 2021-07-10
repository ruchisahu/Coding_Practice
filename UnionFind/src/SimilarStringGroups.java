//https://leetcode.com/problems/similar-string-groups/discuss/1187395/Similar-String-Groups-or-Union-find-or-Java
public class SimilarStringGroups {
	 public int numSimilarGroups(String[] strs) {
		 UF uf = new UF(strs.length);
		 int ans = 0;
	        for(int i = 0 ; i < strs.length;i++){
	            String word = strs[i];
	            for(int j = i+1 ; j < strs.length ;j++){
	                int count = 0;
	                String curr = strs[j];
	                int k = 0;
	                if(curr.equals(word)){
	                    uf.union(i,j);
	                }
	                while(k < word.length()){
	                    if(word.charAt(k) != curr.charAt(k)){
	                        count++;
	                    }
	                    k++;
	                }
	                if(count == 2){
	                    int px = uf.find(i);
	                    int py = uf.find(j); 
	                   if(py != px){
	                       uf.union(i,j);
	                   }
	                }
	            }
	        }
		return uf.getComponent();
		}

	public static void main(String[] args) {
		SimilarStringGroups s=new SimilarStringGroups();
		String[] strs = {"tars","rats","arts","star"};
		System.out.println(s.numSimilarGroups(strs));

	}

}
