import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Permutaion {
	// Java program to print all permutations of a 
	// given string. 
	
		public static void main(String[] args) 
		{ 
			String str = "ABC"; 
			int n = str.length(); 
			Permutaion permutation = new Permutaion(); 
			permutation.permute(str, 0, n-1); 
		} 

	
		private void permute(String str, int l, int r) 
		{ 
			ArrayList<String> st=new ArrayList<String>();
			if (l == r) 
			{
				//System.out.println(str); 
				st.add(str);
			}
			else
			{ 
				for (int i = l; i <= r; i++) 
				{ 
					str = swap(str,l,i); 
					permute(str, l+1, r); 
					str = swap(str,l,i); 
				} 
			} 
			st.sort( Comparator.comparing( String::toString ) ); 
			System.out.println(st);
		} 

	
		public String swap(String a, int i, int j) 
		{ 
			char temp; 
			char[] charArray = a.toCharArray(); 
			temp = charArray[i] ; 
			charArray[i] = charArray[j]; 
			charArray[j] = temp; 
			return String.valueOf(charArray); 
		} 

	} 


