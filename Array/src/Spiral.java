import java.util.ArrayList;
import java.util.List;

public class Spiral {
	 public static List<Integer> spiralOrder(int[][] matrix) {
	      List<Integer> spiral = new ArrayList<>();
	        if (matrix == null || matrix.length == 0  || matrix[0].length == 0)
	            return spiral;
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        int total = m*n;
	        
	        int topRow = 0;
	        int bottomRow = m-1;
	        int leftCol = 0;
	        int rightCol = n-1;
	        
	        while (spiral.size() < total){
	            for (int i = leftCol; i <= rightCol; i++){
	                spiral.add(matrix[topRow][i]);
	            }
	            topRow++; //Finished with the top row 
	            for (int i = topRow; i <= bottomRow; i++){
	                spiral.add(matrix[i][rightCol]);
	            }
	            rightCol--;//Finished with right column
	            for (int i = rightCol; i >= leftCol; i--){
	                spiral.add(matrix[bottomRow][i]);
	            }
	            bottomRow--; //Finished the bottom row
	                        if (spiral.size() == total) break;

	            for (int i = bottomRow; i >= topRow; i--){
	                spiral.add(matrix[i][leftCol]);
	            }

	            leftCol++;
	        }
	        
	        while (spiral.size() > total) spiral.remove(spiral.size()-1);
	        
	        return spiral;
	    }

	public static void main(String[] args) {
		int[][] spiral={
		                { 1, 2, 3 },
		                { 4, 5, 6 },
		                { 7, 8, 9 }};
		spiralOrder(spiral);
		               

	}

}
