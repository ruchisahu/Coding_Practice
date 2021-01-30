package test;

public class wordSearch {
	public static boolean exist(char[][] board, String word) {
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
        	boolean[][] visited=new boolean[board.length][board[0].length];
            if(board[i][j]==word.charAt(0)){
                boolean status=dfs(board,word,i,j,0,visited);
                if(status==true)return true;
            }
        }
    }
    return false;
}

 public static boolean dfs(char[][] board,String word,int i,int j,int index,boolean[][] visited){
     if(index==word.length()-1)return true;
     
     if(board[i][j]!=word.charAt(index))return false;
    	 if(i>0)
         dfs(board,word,i-1,j,index+1,visited);
    	 if(j>0)
         dfs(board,word,i,j-1,index+1,visited);
    	 if(i<board.length-1)
         dfs(board,word,i+1,j,index+1,visited);
    	 if(j<board[0].length-1)
         dfs(board,word,i,j,index+1,visited);
    	 
            
     
	return false;
 }



	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(exist(board, word)); //true
	}

}
