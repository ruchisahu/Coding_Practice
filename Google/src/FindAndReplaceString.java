import java.util.HashMap;

public class FindAndReplaceString {
	
		public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
	        if(S == null || S.length() == 0) return S;
	        HashMap<Integer,Integer> map = new HashMap<>();

	        for(int i = 0; i < indexes.length; i++){
	            map.put(indexes[i],i);
	        }

	        StringBuilder sb = new StringBuilder();
	        sb.append(S);

	        for(int i = S.length() - 1; i >= 0; i--){
	            if(map.containsKey(i)){
	                int index = map.get(i);
	                String s = sources[index];
	                String t = targets[index];
	                if(S.substring(i).startsWith(s)){
	                    sb.replace(i, i + s.length(), t);
	                }
	            }
	        }

	        return sb.toString();
		}
    public static void main(String args[]){
        String S = "abcd";
        int[] indexes = new int[]{0,2};
        String[] sources = new String[]{"a", "cd"};
        String[] targets  = new String[]{"eee", "ffff"};

        System.out.println(findReplaceString(S,indexes, sources,targets));
    }
}


