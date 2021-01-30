package test;

import java.util.HashMap;

public class anagram {
	
	 public static boolean isAnagram1(String s, String t) {
	        int[] alp = new int[26];
	        for(int i=0;i<s.length();i++){
	        	alp[s.charAt(i)-'a']++;
	        }
	        for(int i=0;i<t.length();i++){
	        	alp[t.charAt(i)-'a']--;
	        }
	        for(int i=0;i<alp.length;i++){
	        	if(alp[i]!=0)return false;
	        }
			return true;
	        
	        }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
        
        for(int i=0;i<t.length();i++){
        	if(!map.containsKey(t.charAt(i)))return false;
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        for(Character key:map.keySet()){
            if(map.get(key)>0){
                return false;
            }
        }
        return true;
    }


	public static void main(String[] args) {
		String s="cat";
		String t="act";
		System.out.println(isAnagram1(s,t));
		
		String s1="cut";
		String t1="act";
		System.out.println(isAnagram1(s1,t1));

	}

}
