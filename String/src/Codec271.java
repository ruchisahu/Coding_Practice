import java.util.LinkedList;
import java.util.List;

public class Codec271 {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        // encode with stringlength + "#" + str
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	List<String> result = new LinkedList<>();
        
        // Corner case
        if (s == null || s.length() == 0) {
            return result;
        }
        
        int start = 0;
        int end = 0;
        
        while (end < s.length()) {
            if (s.charAt(end) == '#') {
                // find the length
                int length = Integer.valueOf(s.substring(start, end));
                // add the str
                result.add(s.substring(end + 1, end + 1 + length));
                // reset the start and the end
                start = end + 1 + length;
                end = start;
            }
            end++;
        }
       return result; 
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
