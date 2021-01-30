package test;

import java.util.*;

public class wordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
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

	public static void main(String[] args) {
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
