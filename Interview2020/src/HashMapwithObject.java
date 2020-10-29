import java.util.*;
public class HashMapwithObject {

	public static void main(String[] args) {
		Map<Point,Integer> pointCount=new HashMap<Point, Integer>();
		
		Map<Point,Integer> pointCount1=new HashMap<Point, Integer>();
		
		ArrayList<Point> point=new ArrayList<Point>();
		
		Point p1= new Point(0,0);
		Point p2= new Point(1,1);
		Point p3= new Point(1,1);
		point.add(new Point(2,2));
		
		pointCount.put(p1,0);      //wrong pointCount.add(p1,0);
		pointCount.put(p2,0);
		pointCount.put(p3,0);
		
		for(Point p:pointCount.keySet()) {
			pointCount1.put(p,pointCount1.getOrDefault(p,0)+1);
		}
		
		for(Map.Entry m:pointCount1.entrySet())  
	     { 
			
	       // System.out.println(m.getKey()+" "+m.getValue()); 
			Point a=(Point) m.getKey();
			System.out.println(a.x+"  "+a.y+"  "+"   ="+m.getValue());
	     } 
		
		pointCount1.put(p1,pointCount1.getOrDefault(p1,0)+1);
		for(Map.Entry m:pointCount1.entrySet())  
	     { 
			
	       // System.out.println(m.getKey()+" "+m.getValue()); 
			Point a=(Point) m.getKey();
			System.out.println(a.x+"  "+a.y+"  "+"   ="+m.getValue());
	     } 
		//values
		System.out.println(pointCount1.values());
		
		pointCount1.replace(p1, 1, 4);
		System.out.println(pointCount1.values());  //not working
		
		

	}

}
