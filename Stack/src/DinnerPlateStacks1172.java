import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
//incomplete
class DinnerPlates {

    List<ArrayDeque<Integer>> list;
    int capacity;
    TreeSet<Integer> availableSet;

    public DinnerPlates(int capacity1) {
        this.list = new ArrayList<>();
        this.capacity = capacity;
        this.availableSet = new TreeSet<>();
    }

    public void push(int val) {
        if (availableSet.isEmpty()) {
            list.add(new ArrayDeque<>());
            availableSet.add(list.size() - 1);
        }
        ArrayDeque<Integer> stack = list.get(availableSet.first());
        stack.push(val);
        if (stack.size() >= capacity) {
            availableSet.pollFirst();
        }
    }

    public int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        int ans = list.get(list.size() - 1).pop();
        availableSet.add(list.size() - 1);
        // Amortized O(1)
        while (!list.isEmpty() && list.get(list.size() - 1).isEmpty()) {
            list.remove(list.size() - 1);
            availableSet.pollLast();
        }
        return ans;
    }

    public int popAtStack(int index) {
        if (index >= list.size()) return -1;
        if (index == list.size() - 1) {
            return pop();
        }
        ArrayDeque<Integer> stack = list.get(index);
        int ans = stack.isEmpty() ? -1 : stack.pop();
        availableSet.add(index);
        return ans;
    }





	public static void main(String[] args) {
		
		DinnerPlates D = new DinnerPlates(2);  // Initialize with capacity = 2
		D.push(1);
		D.push(2);
		D.push(3);
		D.push(4);
		D.push(5);
		System.out.println(D.popAtStack(0));   // Returns 2.  The stacks are now:     4
        
		D.push(20);   
		D.push(21);      
		
		D.popAtStack(0);   
		D.popAtStack(2);  
		D.pop();            
		D.pop();            
		D.pop() ;          
		D.pop();         
		D.pop() ;           // Returns -1.  There are still no stacks.


	}

}
	

	

	


