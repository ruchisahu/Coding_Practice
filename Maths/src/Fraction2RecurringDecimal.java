import java.util.HashMap;
import java.util.Map;

public class Fraction2RecurringDecimal {
	 public static String fractionToDecimal(int numerator, int denominator) {
         StringBuilder tem = new StringBuilder();
         if(numerator < 0 && denominator > 0 || denominator < 0 && numerator > 0)
            tem.append("-");
        if(numerator==0)
            return "0";
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long r = numerator%denominator;  
        long q = numerator/denominator;
         tem.append(String.valueOf(Math.abs(q)));
        Map<Long,Integer> resu = new HashMap<>();
        if(r == 0){
            return tem.toString();
        }
        else{
            tem.append(".");
        while(r !=0){
                if(resu.containsKey(r)){
                    int k = resu.get(r);
                    tem.insert(k,"(");
                    tem.append(")");
                    break; 
                }
            resu.put(r,tem.length());
         
            r*=10;
           q = r/denominator;
           r = r%denominator;
          tem.append(String.valueOf(Math.abs(q)));
         }
        }
         
           return tem.toString(); 
    }

	public static void main(String[] args) {
		int numerator1 = 1;
		int denominator1 = 2;
				System.out.println(fractionToDecimal(numerator1,denominator1));
				
				int numerator2 = 4;
				int denominator2 = 333;
						System.out.println(fractionToDecimal(numerator2,denominator2));
						

	}

}
