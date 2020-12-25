//https://leetcode.com/problems/rotate-image/
public class RotateImage {
	 public static void rotate(int[][] matrix) {
	        int m=0;
	        int n=matrix.length-1;
	        while(m<n){
	        	int[] temp=matrix[m];
	        	matrix[m]=matrix[n];
	        	matrix[n]=temp;
	        	m++;
	        	n--;
	        	}
	        
	 
	 for(int i = 0; i < matrix.length; i++){
	        for(int j = i+1; j < matrix[i].length; j++){
	            int temp = matrix[i][j];
	            matrix[i][j]=matrix[j][i];
	            matrix[j][i]=temp;
	        }
	 }
	 for(int i = 0; i < matrix.length; i++){
	        for(int j = 0; j < matrix[i].length; j++){
	        	System.out.println(matrix[i][j]);
	        }}
	 }

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);

	}

}
