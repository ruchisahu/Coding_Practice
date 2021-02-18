
public class HammingWeight {
	public static int hammingWeight(int n) 
    {
		int count=0;
        
	       
        while(n!=0)
        {
          
            int x=n & 1;
            System.out.println(x);
            if(x==1)
                
                count++;
           
            n=n>>>1;
            
        }

        return count;
    }

	public static void main(String[] args) {
		int testInput1 = Integer.parseInt("1011");  
		System.out.println(hammingWeight(testInput1));
      //  System.out.println("The input binary string 1011 has a total of three '1' bits.");

        int testInput2 = Integer.parseInt("00000000000000000000000010000000");
     //   System.out.println(hammingWeight(testInput2));
        

	}

}
