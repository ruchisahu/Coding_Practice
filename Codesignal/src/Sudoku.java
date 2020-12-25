//https://app.codesignal.com/interview-practice/task/SKZ45AF99NpbnvgTn/description
/**
 * https://codefights.com/interview-practice/task/SKZ45AF99NpbnvgTn
 * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.
 * <p>
 * Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.
 * <p>
 * Example
 * <p>
 * For
 * <p>
 * grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
 * ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
 * ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
 * ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
 * ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
 * ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
 * ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
 * ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
 * ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
 * the output should be
 * sudoku2(grid) = true;
 * <p>
 * For
 * <p>
 * grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
 * ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
 * ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
 * ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
 * ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
 * ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
 * ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
 * ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
 * ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
 * the output should be
 * sudoku2(grid) = false.
 * <p>
 * The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.
 * <p>
 * Input/Output
 * <p>
 * [execution time limit] 3 seconds (java)
 * <p>
 * [input] array.array.char grid
 * <p>
 * A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.
 * <p>
 * [output] boolean
 * <p>
 * Return true if grid represents a valid Sudoku puzzle, otherwise return false.
 */
public class Sudoku {
	static boolean sudoku2(char[][] grid) {
		for(int i = 0; i < grid.length; i++){
		        for(int j = 0; j < grid[0].length; j++){
		            if(grid[i][j] != '.'){
		                char tmp = grid[i][j];
		                for(int k = j+1; k < grid[0].length; k++){
		                    if(tmp == grid[i][k]){
		                        return false;
		                    }
		                }
		                for(int l = i+1; l < grid.length; l++){
		                    if(tmp == grid[l][j]){
		                        return false;
		                    }
		                }
		                int x = 0;
		                int y = 0;
		                if(i < 3){
		                    x = 0;
		                }
		                if(j < 3){
		                    y = 0;
		                }
		                 if(i > 3 && i < 6){
		                    x = 3;
		                }
		                if(j > 3 && j < 6){
		                    y = 3;
		                }
		                 if(i  > 6){
		                    x = 6;
		                }
		                if(j > 6){
		                    y = 6;
		                }
		                int tmp2 = 0;
		                for(int p = x; p < x+3; p++){
		                    for(int g = y; g < y+3; g++){
		                        if(grid[p][g] == tmp){
		                            tmp2++;
		                        }
		                    }
		                }
		                if(tmp2 >= 2){
		                    return false;
		                }
		            }
		        }
		    }
		    return true;
		}

	public static void main(String[] args) {
		char[][] grid =
            {
                    {'.', '.', '.', '.', '2', '.', '.', '9', '.'},
                    {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                    {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
                    {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
                    {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
                    {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                    {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                    {'.', '2', '.', '.', '3', '.', '.', '.', '.'}
            };
		System.out.println(sudoku2(grid));

	}

}
