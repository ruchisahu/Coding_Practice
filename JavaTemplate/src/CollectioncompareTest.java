import java.util.*;
public class CollectioncompareTest {
	public static List<String> getFrequent(){
	  
	    HashMap<String, Integer> count=new HashMap<String, Integer>();
		count.put("adam", 123);
		count.put("Kate", 234);
		count.put("Kim", 236);
		List<String> ls = new ArrayList<>(count.keySet());    
		
	  //  Collections.sort(list, (o1, o2) -> (o1>o2 ? -1 : (o1==o2 ? 0 : 1)));
	    Collections.sort(ls, (a,b)-> (count.get(a)).equals(count.get(b))?a.compareTo(b):count.get(b)-count.get(a));    
	    int k=2;
	    for(int i=0; i<ls.size();i++)
		{
			System.out.println(ls.get(i));
		}
	    return ls.subList(0,k);    
	  }
	 public static void main(String[] args) {
		 getFrequent();
	 }
	}


