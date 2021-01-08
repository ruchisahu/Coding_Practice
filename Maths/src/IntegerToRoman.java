import java.util.*;

public class IntegerToRoman {
	public static String intToRoman(int num) {
		Map<Integer, String> map = new HashMap();
		map.put(1, "I"); map.put(5, "V"); map.put(10, "X");
		map.put(50, "L"); map.put(100, "C"); map.put(500, "D"); map.put(1000, "M");
		map.put(4, "IV"); map.put(9, "IX"); map.put(40, "XL"); map.put(90, "XC");
		map.put(400, "CD"); map.put(900, "CM");
		StringBuilder sb=new StringBuilder();

		int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		for(int i=0;i<numbers.length;i++) {
			while(num>=numbers[i]) {
				num=num-numbers[i];
				sb=sb.append(map.get(numbers[i]));
			}
		}
		return sb.toString();
	
}
	
	


	public static void main(String[] args) {
		int num1=5;
		System.out.println(intToRoman(num1));

	}

}
