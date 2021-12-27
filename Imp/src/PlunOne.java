public class PlunOne {

    public static int[] plusOne(int[] digits){
        if(digits == null || digits.length == 0) return digits;

        for (int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        int[] res = new int[digits.length+1];
        res[0] = 1;

        return res;
    }

    public static void main(String args[]){
        int[] arr = {9,9,9};
        int[] res = plusOne(arr);
        System.out.println(res);
    }
}
