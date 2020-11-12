
public class TransposeMatrix {
	public static int[][] transpose(int[][] A){
        int result[][] = new int[A[0].length][A.length];

        if(A.length == 0){
            return result;
        }

        for(int i = 0; i < A[0].length; i++){
            for(int j = 0; j < A.length; j++){
                result[i][j] = A[j][i];
            }
        }

        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
