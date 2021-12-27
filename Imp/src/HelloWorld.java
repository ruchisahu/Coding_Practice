public class HelloWorld {
/*
    public static String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0;
        while(i >= 0 || j >= 0){
            int sum = remainder;
            if (i >=0) sum += a.charAt(i) - '0';
            if (j >=0) sum += b.charAt(j) - '0';
            sb.append(sum%2);
            remainder = sum/2;
        }
        if (remainder != 0){
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }
    */
    public static void main (String args[]){
        String a = "11";
        String b = "234";
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        System.out.println(a.charAt(i) - '0');
        System.out.println(b.charAt(j) - '0');
        /*
        while(i >= 0 || j >= 0) {
            int sum;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            System.out.print(a.charAt(i) - '0');
        }
*/
    }
}
