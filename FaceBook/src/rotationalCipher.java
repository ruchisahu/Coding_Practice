import java.util.Arrays;

public class rotationalCipher {
	private static String rotationalCipher(String input, int rotationFactor)
	{
		// Write your code here
		if (input.length() > 0)
		{
			//char [] origCharArray = new char[input.Length];
			char[] retCharArray = new char[input.length()];
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < input.length(); i++)
			{
				char curChar = input.charAt(i);
				if (Character.isLetter(curChar))
				{ // current Char is alphanumeric
					//System.Globalization.CharUnicodeInfo.GetNumericValue(curChar);
					int tempVal = (int)curChar + rotationFactor % 26;
					//System.out.println("temp"+tempVal);
					if (Character.isLowerCase(curChar))
							
					{ // check if the tempVal is greater than the value of 'z'
						if (tempVal > (int)'z')
						{
							tempVal = (int)'a' + (tempVal - (int)'z') - 1;
						}
					}
					else
					{ // upper case check if tempVal is greater than 'Z'
						if (tempVal > (int)'Z')
						{
							tempVal = (int)'A' + (tempVal - (int)'Z') - 1;
						}
					}

					retCharArray[i] = (char)(tempVal);
					sb.append((char)retCharArray[i]);
				}
				else if (Character.isDigit(curChar))
				{ // current Char is digit
					int tempNum = curChar-'0';
					tempNum = (tempNum + rotationFactor) % 10;
					retCharArray[i] = (char) (tempNum-'0');
					sb.append(Integer.toString(tempNum));
				}
				else
				{
					retCharArray[i] = curChar;
					sb.append(retCharArray[i]);
				}
			}
			

			return sb.toString();
		}

		return "";
	}
	static void printString(String str) {
	    System.out.print("[\"" + str + "\"]");
	  }
	static int test_case_number = 1;
	  static void check(String expected, String output) {
	    boolean result = (expected.equals(output));
	    char rightTick = '\u2713';
	    char wrongTick = '\u2717';
	    if (result) {
	      System.out.println(rightTick + " Test #" + test_case_number);
	    }
	    else {
	      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
	      printString(expected); 
	      System.out.print(" Your output: ");
	      printString(output);
	      System.out.println();
	    }
	    test_case_number++;
	  }
	public static void main(String[] args) {
		String input_1 = "All-convoYs-9-be:Alert1.";
	    int rotationFactor_1 = 4;
	    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
	    String output_1 = rotationalCipher(input_1, rotationFactor_1);
	    check(expected_1, output_1);

	    String input_2 = "abcdZXYzxy-999.@";
	    int rotationFactor_2 = 200;
	    String expected_2 = "stuvRPQrpq-999.@";
	    String output_2 = rotationalCipher(input_2, rotationFactor_2);
	    check(expected_2, output_2);
	}
}



