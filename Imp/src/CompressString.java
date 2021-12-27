public class CompressString {
    public static String compress(String s){
        if(s == null || s.length() == 0) return s;

        int count = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(sb.length() > s.length()) return s;

            count++;

            if( i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)){
                sb.append(count);
                sb.append(s.charAt(i));
                count = 0;
            }
        }

        return sb.toString();
    }

    public static void main (String args[]){
        String res = compress("accccc");
        System.out.println(res);
    }
}
