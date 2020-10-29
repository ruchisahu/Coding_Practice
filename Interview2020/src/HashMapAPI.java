import java.util.*;

public class HashMapAPI {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> address=new HashMap<String, Integer>();
		address.put("adam", 123);
		address.put("Kate", 234);
		System.out.println("first pass");
		
		
		if(address.containsKey("adam"))
		{
		System.out.println(address.get("adam"));
		}
		
		
		System.out.println("second pass");
		for(String names: address.keySet())
		{
			System.out.println(names);
			System.out.println(address.get(names));
		}
		
		
		System.out.println("third pass");
		for(Integer val: address.values())
		{
			System.out.println(val);
		}
		System.out.println("fouth pass");
		
		 System.out.println("The set is: " + address.entrySet()); 
		 
		  System.out.println("Initial Mappings are: " + address); 

		  
		  SortedMap<String, Integer> 
          sotree_map = new TreeMap<String, 
                                   Integer>(); 

      // Mapping int values to string keys 
      sotree_map.put("Geeks", 10); 
      sotree_map.put("4", 15); 
      sotree_map.put("Geeks", 20); 
      sotree_map.put("Welcomes", 25); 
      sotree_map.put("You", 30); 

      // Displaying the TreeMap 
      System.out.println("Initial Mappings are: "
                         + sotree_map); 

      // Using entrySet() to get the set view 
      System.out.println("The set is: "
                         + sotree_map.entrySet()); 
      
      sotree_map.remove("You"); 
      
      System.out.println(sotree_map); 
      
      //putall
      SortedMap<Integer, String> map 
      = new TreeMap<>(); 

  map.put(1, "One"); 
  map.put(3, "Three"); 
  map.put(5, "Five"); 
  map.put(7, "Seven"); 
  map.put(9, "Nine"); 
  System.out.println(map); 

  SortedMap<Integer, String> mp 
      = new TreeMap<>(); 

  mp.put(10, "Ten"); 
  mp.put(30, "Thirty"); 
  mp.put(50, "Fifty"); 

  map.putAll(mp); 

  System.out.println(map);
  System.out.println("getordefault");
  String s="HellooH";
	HashMap<Character,Integer> smap=new HashMap<>();
    int sl=s.length();
      
    for(int i=0;i<sl;i++){
        smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
        
    }
    System.out.println(smap);
    
  //iterator
    System.out.println("iterator");
    Iterator<String> i=address.keySet().iterator();  
    while(i.hasNext())  
    {  
    System.out.println(i.next());  
    }  
	}

}
