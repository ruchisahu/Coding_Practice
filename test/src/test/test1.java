package test;

import java.util.*;

class point{
	int x;
	int y;
	point(int x,int y){
		x=x;
		y=y;
	}
}
	
public class test1 
{
	public static boolean move(String path,point p1) {
		char[] pa=path.toCharArray();
		Set<String> set=new HashSet<String>();
		String str=p1.x+" "+p1.y;
		set.add(str);
		point p=new point(0,0);
		for(int i=0;i<pa.length;i++) {
			
			if(pa[i]=='N') {
				p.x=p.y++;
				
				
			}
			if(pa[i]=='S') {
				p.x=p.y--;
			}
			if(pa[i]=='E') {
				p.x=p.x--;
			}
			if(pa[i]=='W') {
				p.x=p.x++;
			}
			String str1=p.x+" "+p.y;
			if(!set.contains(str1)) {
				set.add(str1);
			}
				
			else
				return true;
			
		}
		return false;
		
}


	public static void main(String[] args) {
		point p=new point(0,0);
		String path="NESWW";
		System.out.println(move(path,p));
		
		String path2="NES";
		System.out.println(move(path2,p));
		

	}

}
