import java.util.*;

/*
 Given A, B, C, find any string of maximum length that can be created such that no 3 consecutive characters are same.
  There can be at max A 'a', B 'b' and C 'c'.
  
  Input: A = 1, B = 1, C = 6
Output: "ccbccacc"
 */
 
public class Longeststring {
	public static String findString(Map<Character, Integer> map,int a,int b,int c)
	{
		int total=a+b+c;
        int currA=0, currB=0, currC=0;
        String res = "";
        
        while(total>0){
            
            if((a>=b && a>=c && currA!=2) || (a>0 && (currB==2|| currC==2))){
                res+='a'; 
                a--;
                currA++;
                currB=currC=0;
            }
            else if((b>=a && b>=c && currB!=2) || (b>0 && (currA==2|| currC==2))){
                res+='b';
                b--;
                currB++;
                currA=currC=0;
            }
            else if((c>=a && c>=b && currC!=2) || (c>0 && (currA==2|| currB==2))){
                res+='c';
                c--;
                currC++;
                currA=currB=0;
            }
            total--;
        }
        return res;
	}

	public static void main(String[] args)
	{
		Map<Character, Integer> map = new HashMap<>();
		map.put('a', 2);
		map.put('b', 1);
		map.put('c', 7);
		System.out.println(findString(map,2,1,7));

	}

}
