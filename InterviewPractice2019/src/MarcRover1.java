import java.util.HashMap;



	public class MarcRover1 {

		  HashMap<Character, Integer> directions;
		     HashMap<Character, Integer> moves;
		     private MarcRover1 marcRover1;
		     char[][] matrix;
		     Position position;
		     int[][] space;
	    
	    public void init() 
	    {
	        marcRover1 = new MarcRover1();
	        space = new int[5][5];
	        populateDirections();
	        populateMoves();
	        buildDirectionMatrix(directions.size(), moves.size());
	        position = new Position(1, 2, 'N');
	    }
	
	    private void executeCommand(char command) {
	        char updateDirection = getUpdateDirection(command, position.getDir());
	        int[] updatePosition;
	        if (command == 'M')
	        {
	            updatePosition = getUpdateLocation(position.getR(), position.getC(), updateDirection);
	            position.setR(updatePosition[0]);
	            position.setC(updatePosition[1]);
	        }
	        position.setDir(updateDirection);
	        
	        System.out.println(position.getC());
	        System.out.println(position.getR());
	        System.out.println(position.getDir());
	    }
	    
	    
	    private char getUpdateDirection(char movement, char oldDirection) {
	        char updatedDir = matrix[moves.get(movement)][directions.get(oldDirection)];
	        return updatedDir;
	    }

	    private int[] getUpdateLocation(int row, int col, char direction) throws IllegalStateException {
	        switch (direction) {
	            case 'N':
	                row -= 1;
	                break;
	            case 'S':
	                row += 1;
	                break;
	            case 'E':
	                col += 1;
	                break;
	            case 'W':
	                col -= 1;
	                break;
	        }
	        
	        if (row < 0 || col < 0 || row >= 5 || col >= 5)
	            throw new IllegalStateException("rover can not move");
	        int[] loc = new int[2];
	        loc[0] = row;
	        loc[1] = col;
	        return loc;
	    }

	   

	    class Position {
	        int r;
	        int c;
	        char dir;

	        public Position(int r, int c, char dir) {
	            this.r = r;
	            this.c = c;
	            this.dir = dir;
	        }

	        public int getR() {
	            return r;
	        }
	        
	        
	        public void setR(int r) {
	            this.r = r;
	        }

	        public int getC() {
	            return c;
	        }

	        public void setC(int c) {
	            this.c = c;
	        }

	        public char getDir() {
	            return dir;
	        }

	        public void setDir(char dir) {
	            this.dir = dir;
	        }
	    }
	    
	    private void buildDirectionMatrix(int col, int row) {
	        matrix = new char[row][col];
	        matrix[0][0] = 'W';
	        matrix[0][1] = 'E';
	        matrix[0][2] = 'N';
	        matrix[0][3] = 'S';
	        matrix[1][0] = 'E';
	        matrix[2][1] = 'W';
	        matrix[1][2] = 'S';
	        matrix[1][3] = 'N';
	        matrix[2][0] = 'N';
	        matrix[2][1] = 'S';
	        matrix[2][2] = 'E';
	        matrix[2][3] = 'W';
	    }

	    
	    /**
	     * Helper function to build map move to a row in matrix
	     */
	    private void populateMoves() {
	        moves = new HashMap<>();
	        moves.put('L', 0);
	        moves.put('R', 1);
	        moves.put('M', 2);
	    }

	    /**
	     * Helper function to build map direction to a col in matrix
	     */
	    private void populateDirections() {
	        directions = new HashMap<>();
	        directions.put('N', 0);
	        directions.put('S', 1);
	        directions.put('E', 2);
	        directions.put('W', 3);
	    }
	
	
	
	
	public static void main(String[] args) {
		MarcRover1 m=new MarcRover1();
		m.init();
		char[] commands = new char[]{'L', 'M', 'L', 'M', 'L', 'M', 'L', 'M', 'M'};
      for (char c : commands) {
          m.executeCommand(c);
      }
      
     // System.out.println(position.getC());

	}

}
