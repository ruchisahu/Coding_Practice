package test;

import java.util.*;

public class wordBreak {
	public static boolean wordBreak1(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] check=new boolean[n+1];
        Set<String> set=new HashSet<>();
        check[0]=true;
        int start=0;
        for(int i=1;i<=n;i++){
            String str=s.substring(start,i);
            
            if(wordDict.contains(str) && check[start]){
            	 wordDict.remove(str);
            	System.out.println(s.substring(start, i));
                check[i]=true;
                start=i;
                
            }
        }
        return check[n];
    }
	 public static boolean wordBreak(String s, List<String> wordDict) {
	        boolean[] check =new boolean[s.length()+1];
	        check[0]=true;
	        
	        for(int i=1;i<=s.length();i++){
	            for(int j=0;j<i;j++){
	                if(check[j] && wordDict.contains(s.substring(j,i))){
	                    check[i]=true;
	                    break;
	                }
	            }
	        }
	        return check[s.length()];
	    }

	public static void main(String[] args) {
		String s11="leetcode";
		List<String> wordDict11=new ArrayList<String>();
		wordDict11.add("leet");
		wordDict11.add("code");
		wordDict11.add("lee");
		System.out.println(wordBreak(s11, wordDict11));
		
		String s="aaaaaaa";
		List<String> wordDict=new ArrayList<String>();
		wordDict.add("aaaa");
		wordDict.add("aaa");
		System.out.println(wordBreak(s, wordDict));
		
		String s1="applepenapple";
		List<String> wordDict1=new ArrayList<String>();
		wordDict1.add("apple");
		wordDict1.add("pen");
		System.out.println(wordBreak(s1, wordDict1));

	}

}
