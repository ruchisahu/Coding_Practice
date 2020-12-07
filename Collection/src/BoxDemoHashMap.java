import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BoxDemoHashMap {

		  

	public static void main(String[] args) {
		Scanner s = new Scanner(
	            "car         toyota\n" +
	            "car         bmw\n" +
	            "car         honda\n" +
	            "fruit       apple\n" +
	            "fruit       banana\n" +
	            "computer    acer\n" +
	            "computer    asus\n" +
	            "computer    ibm");
		 ArrayList<ArrayList<String> > aList =  new ArrayList<ArrayList<String> >(); 
		 ArrayList<String> a1 = new ArrayList<String>(); 
		 a1.add("car"); 
	     a1.add("toyota"); 
		 aList.add(a1);
		 
		 ArrayList<String> a2 = new ArrayList<String>(); 
		 a1.add("car"); 
	     a1.add("honda"); 
		 aList.add(a2);
		 
		 ArrayList<String> b1 = new ArrayList<String>(); 
		 b1.add("fruit"); 
	     b1.add("banana"); 
		 aList.add(b1);
		 
		 ArrayList<String> b2 = new ArrayList<String>(); 
		 b2.add("fruit"); 
	     b2.add("apple"); 
		 aList.add(b2);
		 
		 ArrayList<String> c1 = new ArrayList<String>(); 
		 c1.add("vegitable"); 
	     c1.add("spinach"); 
		 aList.add(c1);
		 
		 ArrayList<String> c2 = new ArrayList<String>(); 
		 c2.add("vegitable"); 
	     c2.add("carrot"); 
		 aList.add(c2);
		 
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (List<String> item : aList) {
			for(int i=1;i<item.size();i++)
			{
				String v=item.get(i);
	    	if(!map.containsKey(item.get(0)))
	    	{
	    		List<String> val = new ArrayList<String>(){ { add(v);}};
	    		map.put(item.get(0), new ArrayList<String>());
	    	}
	    	
	    		map.get(item.get(0)).add(v);
	    	
			}

	   
		//Map<String, List<String>> myMap = new HashMap<String, List<String>>();

	
		}
		 System.out.println(map);
	}
}
