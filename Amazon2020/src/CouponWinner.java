
public class CouponWinner {
	 public static int winner(String[][] codes, String[] shoppingCart){
	        StringBuilder sb = new StringBuilder(".*"); //the dot means anything can go here and the star means at least 0 times so .* accepts any sequence of characters, including an empty string.

	        for(String[] code : codes){
	            for(String str : code){
	                sb.append(str.equals("anything") ? ".+" : str);
	            }
	            sb.append(".*");
	        }

	        StringBuilder cart = new StringBuilder();

	        for(String str : shoppingCart){
	            cart.append(str);
	        }

	        return cart.toString().matches(sb.toString()) ? 1 : 0;
	    }
	 public int isWinner(String[][] codeList, String[] shoppingCart) {
		    int i = 0; // i points to group
		    int k = 0; // points to fruit in cart
		    while (i < codeList.length && k < shoppingCart.length) {
		        int j = 0; // j points to fruit in group
		        while (j < codeList[i].length && k < shoppingCart.length) {
		            if (!isMatch(codeList[i][j], shoppingCart[k++])) {
		                break;
		            }
		            j++;
		        }
		        if (j == codeList[i].length) {
		            i++;
		        } else {
		            k -= j;
		        }
		    }

		    return i == codeList.length ? 1 : 0;
		}

		private boolean isMatch(String x, String y) {
		    return "anything".equals(x) || x.equals(y);
		}

	public static void main(String[] args) {
		 String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
	     String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
	     System.out.println(winner(codeList1,shoppingCart1));

	}

}
