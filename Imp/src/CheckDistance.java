public class CheckDistance {
    public static boolean checkDis(String str, Character a, Character b, int k){
        if(str == null || str.length() == 0) return false;

        int count = 0;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == a){
                int idx = i+1;
                while(idx < str.length() && str.charAt(idx) != b){
                    count++;
                    idx++;
                }
                //if(count == k) return true;
                //i = idx;
                //count = 0;
                if(count == k){
                    return true;
                }else{
                    break;
                }
            }
        }

        return false;
    }

    public static void main(String args[]){
        String res = "abcaaadecaade";
        Character a = 'c';
        Character b = 'd';
        int k = 2;
        System.out.println(checkDis(res,a,b,k));
    }
}
