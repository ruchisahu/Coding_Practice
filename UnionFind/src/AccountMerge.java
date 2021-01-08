import java.util.*;

public class AccountMerge {
private static Map<String, String> unionFind = new HashMap<>();
    
    public static List<List<String>> accountsMerge(List<List<String>> accounts) 
    {
        Map<String, String> users = new HashMap<>();
        
        for(List<String> list : accounts)
        {
            for(int i = 1; i < list.size(); i++)
            {
                users.put(list.get(i), list.get(0));
                if(!unionFind.containsKey(list.get(i)))
                {
                    unionFind.put(list.get(i), list.get(i));
                }
                union(list.get(1), list.get(i));
            }
        }
        
        Map<String, Set<String>> temp = new HashMap<>();
        for(String email : unionFind.keySet())
        {
            String root = findRoot(email);
            if(!temp.containsKey(root)) temp.put(root, new HashSet<>());
            temp.get(root).add(email);
        }
        
        List<List<String>> ans = new LinkedList<>();
        for(Map.Entry<String, Set<String>> entry : temp.entrySet())
        {
            List list = new LinkedList<>(entry.getValue());
            Collections.sort(list);
            list.add(0, users.get(entry.getKey()));
            ans.add(list);
        }
        
        return ans;
    }
    
    private static void union(String str1, String str2)
    {
        if(str1.equals(str2)) return;
        String str1Root = findRoot(str1), str2Root = findRoot(str2);
        unionFind.put(str2Root, str1Root);
    }
    
    private static String findRoot(String str)
    {
        while(!str.equals(unionFind.get(str)))
        {
            str = unionFind.get(str);
        }
        return str;
    }


	public static void main(String[] args) {
		//accounts = {{"John", "johnsmith@mail.com", "john00@mail.com"}, ["John", "johnnybravo@mail.com"],
		//["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
				List<String> t1=new ArrayList<String>();
				t1.add("John");
				t1.add("johnsmith@mail.com");
				t1.add("john00@mail.com");
				List<List<String>> accounts=new ArrayList<List<String>>();
				accounts.add(t1);
				
				List<String> t2=new ArrayList<String>();
				t2.add("John");
				t2.add("johnnybravo@mail.com");
				accounts.add(t2);
				
				List<String> t3=new ArrayList<String>();
				t3.add("John");
				t3.add("johnsmith@mail.com");
				t3.add("john_newyork@mail.com");
				accounts.add(t3);
				
				List<String> t4=new ArrayList<String>();
				t4.add("Mary");
				t4.add("mary@mail.com");
				
				accounts.add(t4);
		System.out.println(accountsMerge(accounts));

	}

}
