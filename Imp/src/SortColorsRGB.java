public class SortColorsRGB {
    public static String sortColors(String str){
        String res = "";
        if(str == null || str.length() == 0) return res;

        char[] c = str.toCharArray();
        int start = 0, end = c.length-1, index = 0;


        while(start < end && c[start] == 'R') start++;
        while(end >= 0 && c[end] == 'B') end--;

        index = start;
        while(index <= end){
            if(c[index] == 'R'){
                swap(start++, index++, c);
            }else if(c[index] == 'G'){
                index++;
            }else if(c[index] == 'B'){
                swap(index, end--, c);
            }
        }
        res = new String(c);
        return res;
    }

    public static void swap(int i, int j, char[] c){
        char x = c[i];
        c[i] = c[j];
        c[j] = x;
    }

    public static void main(String args[]){
        String test = "RRRBBGGGRBGBBB";
        String res = sortColors(test);
        System.out.println(res);
    }
}
