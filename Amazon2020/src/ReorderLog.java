import java.util.*;

public class ReorderLog {
	public static String[] reorderLogFiles(String[] logs) {
		  if (logs == null || logs.length == 0)
			  return logs;
	        int len = logs.length;
	        List<String> letterList = new ArrayList<>();
	        List<String> digitList = new ArrayList<>();
	        for (String log : logs) {
	            if (log.split(" ")[1].charAt(0) < 'a') {
	                digitList.add(log);
	            } else {
	                letterList.add(log);
	            }
	        }
	        Collections.sort(letterList, (o1, o2) -> {
	            String[] s1 = o1.split(" ");
	            String[] s2 = o2.split(" ");
	            int len1 = s1.length;
	            int len2 = s2.length;
	            for (int i = 1; i < Math.min(len1, len2); i++) {
	                if (!s1[i].equals(s2[i])) {
	                    return s1[i].compareTo(s2[i]);
	                }
	            }
	           return s1[0].compareTo(s2[0]);
	        });

	        for (int i = 0; i < len; i++) {
	            if (i < letterList.size())
	                logs[i] = letterList.get(i);
	            else logs[i] = digitList.get(i - letterList.size());
	        }
	        for (String log : logs) 
	        {
	        	System.out.println(log);
	        }
	        return logs;
	    }
	
//sol2
	public String[] reorderLogFiles1(String[] logs) {

        Arrays.sort(logs, (log1, log2) -> {

            String[] split1 = log1.split(" ",2);

            String[] split2 = log2.split(" ",2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));

            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2) {

                int cmp = split1[1].compareTo(split2[1]);

                if(cmp != 0)

                    return cmp;

                else 

                    return split1[0].compareTo(split2[0]);

            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;

        });

        

        return logs;

    }
	public static void main(String[] args) {
		String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		reorderLogFiles(logs);

	}

}