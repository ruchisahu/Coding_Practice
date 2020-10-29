/*
 *Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 */
import java.util.*;

public class ListAccountsMerge721 {
	 public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		return accounts;
	        
	    }

	public static void main(String[] args) {
		List<List<String>> account=new ArrayList<List<String>>();
		List<String> email=new ArrayList<String>();
		email.add("John");
		email.add("johnsmith@mail.com");
		email.add("john00@mail.com");
		account.add(email);
		email.clear();
		
		email.add("John");
		email.add("johnnybravo@mail.com");
		account.add(email);
		email.clear();
		
		email.add("John");
		email.add("johnsmith@mail.com");
		email.add("john_newyork@mail.com");
		account.add(email);
		email.clear();
		
		email.add("Mary");
		email.add("mary@mail.com");
		account.add(email);
		email.clear();
		
		accountsMerge(account);
		
		

	}

}
