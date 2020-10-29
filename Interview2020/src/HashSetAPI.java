import java.util.HashSet;
import java.util.Iterator;

public class HashSetAPI {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> set=new HashSet();  
        set.add("One");    
        set.add("Two");    
        set.add("Three");   
        set.add("Four");  
        set.add("Five");  
        set.add("One");    //remove  duplicate
        Iterator<String> i=set.iterator();  
        while(i.hasNext())  
        {  
        System.out.println(i.next());  
        }  
        set.remove("One");
        
        HashSet<String> set1=new HashSet<String>();  
        set1.add("Ajay");  
        set1.add("Gaurav");  
        set.addAll(set1);  
        System.out.println("Updated List: "+set);  
        
        set.removeAll(set1);  
        System.out.println("After invoking removeAll() method: "+set);  
        //Removing elements on the basis of specified condition  
        set.removeIf(str->str.contains("Vijay"));    
        System.out.println("After invoking removeIf() method: "+set);  
        //Removing all the elements available in the set  
        set.clear();  
        System.out.println("After invoking clear() method: "+set);  
        
        //size
        System.out.println(set.size());
        if(set.isEmpty()){  
            System.out.println(" is empty: ");  
        }
            else
            {
            	 System.out.println(" not empty: ");  
            }
        //contains
        

	}

}
