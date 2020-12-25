import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IsCryptSolution {
	//sol1
	boolean isCryptSolution1(String[] crypt, char[][] solution) {
		   char[] dict = new char[200];
		        for (char[] aSolution : solution) {
		            dict[aSolution[0]] = aSolution[1];
		        }

		        List<Double> list = new ArrayList<>();
		        for (String str : crypt) {
		            if (dict[str.charAt(0)] == '0' && str.length() > 1) return false;
		            StringBuilder num = new StringBuilder();
		            for (int i = 0; i < str.length(); i++) {
		                num.append(dict[str.charAt(i)]);
		            }
		            System.out.println(num);
		            list.add(Double.parseDouble(num.toString()));
		        }
		        return list.get(0) + list.get(1) == list.get(2);

		}
	//sol2
	static boolean isCryptSolution(String[] crypt, char[][] solution) {
	    HashMap<Character,Integer> count=new HashMap<>();
	    int val1,val2,val3;
	    val1=val2=val3=0;
	    for(int k=0;k<solution.length;k++){
	        char w=solution[k][0];
	        int no=solution[k][1]-'0';
	        count.put(w, no);
	    }
	    
	    for(int i=0;i<crypt.length;i++){
	        int val=0;
	        for(int j=0;j<crypt[i].length();j++){
	            char c=crypt[i].charAt(j);
	            int n=count.get(c);
	            val=val*10+n;
	            if(i==0 && j==crypt[i].length()-1){ val1=val;}
		        if(i==1 && j==crypt[i].length()-1){ val2=val;}
		        if(i==2 && j==crypt[i].length()-1){ val3=val;}
	        }
	        
	       
	        
	    }
	    if(val1+val2==val3)return true;
	    return false;

	}


	public static void main(String[] args) {
		String[] crypt = {"SEND", "MORE", "MONEY"};
		char[][] solution = {{'O', '0'},{'M', '1'},{'Y', '2'},{'E', '5'},{'N', '6'},{'D', '7'},{'R', '8'},{'S', '9'}};
		System.out.println(isCryptSolution(crypt,solution));

	}

}
