import java.util.*;

//https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
public class NonOverlappingSubstrings {
	public static List<String> maxNumOfSubstrings(String s) {
        int len = s.length(), range[][] = new int[26][2];
        for (int i = 0; i < 26; i++) range[i] = new int[]{len, 0};
        Stack<int[]> st = new Stack<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            range[idx][0] = Math.min(i, range[idx][0]);
            range[idx][1] = Math.max(i, range[idx][1]);
        }
        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            if (range[idx][0] != i) continue;
            int l = range[idx][0], tail = range[idx][1], r = getRightMost(l, tail, range, s);
            if (r < 0) continue;
            while (!st.isEmpty() && l >= st.peek()[0] && r <= st.peek()[1]) st.pop();
            st.push(new int[]{l, r});
        }
        while (!st.isEmpty()) res.add(s.substring(st.peek()[0], st.pop()[1] + 1));
        return res;
    }
    
    private static int getRightMost(int l, int r, int[][] range, String s){
        for (int i = l + 1; i < r; i++) {
            int idx = s.charAt(i) - 'a';
            if (range[idx][0] < l) return -1;
            r = Math.max(r, range[idx][1]);
        }
        return r;
    }

	public static void main(String[] args) {
		String s="adefaddaccc";
		List<String> list=maxNumOfSubstrings(s);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}

	}

}
