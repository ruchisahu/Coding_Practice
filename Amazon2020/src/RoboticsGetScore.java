import java.util.Stack;

public class RoboticsGetScore {
private static int getScore(int num, String[] blocks){
        
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        stack.push(Integer.valueOf(blocks[0]));
        int score = Integer.valueOf(blocks[0]);
        while(i < blocks.length){
            if (blocks[i] == "X"){
                int elem = (int) stack.peek() * 2;
                score += elem;
                stack.push(elem);
            } else if (blocks[i] == "+"){
                int elem2 = (int) stack.pop();
                int elem1 = (int) stack.pop();
                score += elem1 + elem2;
                stack.push(elem1);
                stack.push(elem2);
                stack.push(elem1 + elem2);
            } else if (blocks[i] == "Z"){
                int elem2 = (int) stack.pop();
                score -= elem2;
            } else {
                score += Integer.valueOf(blocks[i]);
                stack.push(Integer.valueOf(blocks[i]));
            }
            i++;
        }
        return score;
    
}

	public static void main(String[] args) {
		int num = 8;
        String[] blocks = new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"};
      //  int score = getScore(num, blocks);
    //    System.out.println(score);
        
        String[] blocks1 = new String[]{"1", "2", "+", "Z"};
        int score1 = getScore(4, blocks1);
        System.out.println(score1);

	}

}
