//https://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-atleast-d-distance-away/?ref=rp
import java.util.*; 
public class RearrangeString {
	// Java program to rearrange a string so that all same 
	// characters become atleast d distance away 
	

	
	static int MAX_CHAR = 256; 

	// The function returns next eligible character 
	// with maximum frequency (Greedy!!) and 
	// zero or negative distance 
	static int nextChar(int freq[], int dist[]) 
	{ 
		int max = Integer.MIN_VALUE; 
		for (int i = 0; i < MAX_CHAR; i++) 
			if (dist[i] <= 0 && freq[i] > 0 && 
			(max == Integer.MIN_VALUE || freq[i] > freq[max])) 
					max = i; 

		return max; 
	} 

	// The main function that rearranges input string 'str' 
	// such that two same characters become atleast d 
	// distance away 
	static int rearrange(char str[], char out[], int d) 
	{ 
		// Find length of input string 
		int n = str.length; 

		int []freq = new int[MAX_CHAR]; 

		for (int i = 0; i < n; i++) 
			freq[str[i]]++; 

		int []dist = new int[MAX_CHAR]; 

		for (int i = 0; i < n; i++) 
		{ 
			// find next eligible character 
			int j = nextChar(freq, dist); 

			// return 0 if string cannot be rearranged 
			if (j == Integer.MIN_VALUE) 
				return 0; 

			// Put character j at next position 
			out[i] = (char) j; 

			// decrease its frequency 
			freq[j]--; 

			// set distance as d 
			dist[j] = d; 

			// decrease distance of all characters by 1 
			for (int k = 0; k < MAX_CHAR; k++) 
				dist[k]--; 
		} 

		// null terminate output string 
			Arrays.copyOfRange(out, 0, n); 
		// out[n] = '\0'; 

		// return success 
		return 1; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		char str[] = "aaaaabbbcc".toCharArray(); 
		int n = str.length; 

		// To store output 
		char []out = new char[n]; 

		if (rearrange(str, out, 2)==1) 
				System.out.println(String.valueOf(out)); 
		else
				System.out.println("Cannot be rearranged"); 
	} 
	} 

	
	
