import java.util.Stack;
//https://abhinandandubey.github.io/posts/2019/12/15/Largest-Rectangle-In-Histogram.html
public class LargestRectangleHistogram {
public static int largestRectangleArea(int[] heights) {
	int N = heights.length;
    Stack<Integer> stk=new Stack<>();
    int maxArea = 0;
    
    for (int i = 0; i <= N;) {
        int height = ((i == N) ? 0 : heights[i]);
        
        if (stk.empty() || height >= heights[stk.peek()]) {
            stk.push(i);
            i++;
        }
        
        else {
            int curHeight = heights[stk.peek()]; stk.pop();
            
            int rightBoundary = i - 1;
            int leftBoundary = stk.empty() ? 0 : stk.peek() + 1;
            int curWidth = rightBoundary - leftBoundary + 1;
            
            int curArea = curHeight * curWidth;
            
            maxArea = Math.max(maxArea, curArea);
        }
    }
    
    return maxArea;
    }

	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));

	}

}
