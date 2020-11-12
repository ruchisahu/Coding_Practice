//https://leetcode.com/problems/rotate-image/
public class RotateArray {
	public void rotate(int[][] matrix) {
        int m = 0, n = matrix.length - 1;
    while(m < n){
        int[] temp = matrix[m];
        matrix[m] = matrix[n];
        matrix[n] = temp;
        m++; n--;
    }

    for(int i = 0; i < matrix.length; i++){
        for(int j = i+1; j < matrix[i].length; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
    }
    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
