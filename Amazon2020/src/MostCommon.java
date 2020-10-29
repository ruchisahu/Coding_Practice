import java.util.*;
public class MostCommon {
//sol1
public static String mostCommonWord(String paragraph, String[] banned) 
{

    HashMap<String, Integer> count=new HashMap<String, Integer>();
    HashSet<String> ban=new HashSet<String>();
    
    String[] strs = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
    
	for(String s: banned)
	{
        ban.add(s.toLowerCase());
    }

	for(String s1: strs)
	{
        String s=s1.toLowerCase();
		if(!ban.contains(s)){
          count.put(s,count.getOrDefault(s,0)+1);
        }
	
	}
     List<String> ls = new ArrayList<>(count.keySet()); 
	
	 Collections.sort(ls, (a,b)-> (count.get(a)).equals(count.get(b))?a.compareTo(b):count.get(b)-count.get(a));    
        ///
	 System.out.println("most frequent="+ls.get(0));
	 
	 //k frequent
	 for(int i=0;i<2;i++)
	 System.out.println("k frequent="+ls.get(i));
	 
    return ls.get(0);  
	
}
//sol2

	public String mostCommonWord2(String paragraph, String[] banned) {

        paragraph += ".";



        Set<String> banset = new HashSet();

        for (String word: banned) banset.add(word);

        Map<String, Integer> count = new HashMap();



        String ans = "";

        int ansfreq = 0;



        StringBuilder word = new StringBuilder();

        for (char c: paragraph.toCharArray()) {

            if (Character.isLetter(c)) {

                word.append(Character.toLowerCase(c));

            } else if (word.length() > 0) {

                String finalword = word.toString();

                if (!banset.contains(finalword)) {

                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);

                    if (count.get(finalword) > ansfreq) {

                        ans = finalword;

                        ansfreq = count.get(finalword);

                    }

                }

                word = new StringBuilder();

            }

        }



        return ans;

    }



	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
				String[] banned = {"hit"};
				mostCommonWord(paragraph, banned);

	}

}
