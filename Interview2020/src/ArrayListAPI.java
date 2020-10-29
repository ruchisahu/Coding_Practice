import java.util.*;

public class ArrayListAPI {
	

	public static void main(String[] args)
	{
		
		// TODO Auto-generated method stub
		List<Integer> val= new ArrayList<Integer>();
		val.add(1);
		val.add(5);
		System.out.println("arraylist after step 1");
		for(int i=0; i<val.size();i++)
		{
			System.out.println(val.get(i));
		}
		
		val.remove(1);
		val.add(3);
		val.set(1, 2);
		val.add(4);
		System.out.println("arraylist after step 2");
		for(int i=0; i<val.size();i++)
		{
			System.out.println(val.get(i));
		}
	val.remove(1);
	System.out.println("arraylist after step 3");
	for(int i=0; i<val.size();i++)
	{
		System.out.println(val.get(i));
	}
	
	if(val.contains(5))
	{
		System.out.println(true);
	}
	else
		System.out.println(false);
	val.remove(new Integer(4));
	
	System.out.println("arraylist after step 4");
	
	for(int i=0; i<val.size();i++)
	{
		System.out.println(val.get(i));
	}
	val.clear();
  System.out.println("arraylist after step 5");
	
	for(int i=0; i<val.size();i++)
	{
		System.out.println(val.get(i));
	}
	
	
    if(val.isEmpty())
    {
    	System.out.println("empty");
    }
	}

}
