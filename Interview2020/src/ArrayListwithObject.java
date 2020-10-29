import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListwithObject
{
	

	public static void main(String[] args) {
		ArrayList<Point> point=new ArrayList<Point>();
		
		Point p1= new Point(0,0);
		Point p2= new Point(1,1);
		
		point.add(new Point(2,2));
		
		point.add(p1);
		point.add(p2);
		
		Iterator<Point> it =point.iterator();
		while(it.hasNext()) {
			Point pt=(Point)it.next();  
			System.out.println("x="+pt.x+"    "+"y="+pt.y);
		//	System.out.println(pt.y);
		}
	

	}

}
