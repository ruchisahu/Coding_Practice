/*import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
*/
public class ReverseAnInteger {

    public static int reverse(int num){
        if(num == 0 || num > 0 && num < 10) return num;

        boolean isN = false;

        if(num < 0){
            isN = true;
            num = num*-1;
        }

        long res = 0;
        while(num != 0){
            res = res*10 + num%10;
            checkInt(res);
            num /= 10;
        }

        if(isN){
            return (int) res * -1;
        }else{
            return (int) res;
        }

    }

    public static void checkInt(long res){
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            throw new ArithmeticException("Husbando");
        }
    }

    public static void main(String args[]){
        // 2147483647
        int x = reverse(-12345);
        System.out.println(x);
    }

}
