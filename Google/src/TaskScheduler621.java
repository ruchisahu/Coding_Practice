import java.util.*;

//https://leetcode.com/problems/task-scheduler/
//https://leetcode.com/discuss/interview-question/1133524/Google-Phone-Interview
//O(n*klogk)
public class TaskScheduler621 {
	 public static int leastInterval(char[] tasks, int k) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char task: tasks) {
	            map.put(task, map.getOrDefault(task, 0)+1);
	        }
	        int count = 0;
	        int res = 0;
	        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
	        Queue<Integer> buffer = new LinkedList<>();
	        queue.addAll(map.values());
	        while (count != map.size()) {
	            if (queue.isEmpty()) queue.add(Integer.MAX_VALUE);
	            int temp = queue.poll();
	            temp--;
	            if (temp == 0) count++;
	            buffer.add(temp);
	            res++;
	            if (buffer.size() == k+1) queue.add(buffer.poll());
	        }
	        return res; 
	    }
	 //sol2 different question
	 //https://leetcode.com/discuss/interview-question/1133524/Google-Phone-Interview
	 public static int totalRunTime(char[] tasks, int n) {
		    
		    Map<Character, Integer> map = new HashMap<>();
		    
		    int curr_time = 0;
		    
		    for (char c : tasks) {
		        if (map.containsKey(c)) {
		            if (curr_time - map.get(c) <= n) {
		                curr_time += n - (curr_time - map.get(c)) + 1;
		            }
		        }
		        map.put(c, curr_time);
		        curr_time++;
		    }
		    
		    return curr_time;
		} 

	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};    
				int n = 2;
				System.out.println(totalRunTime(tasks,n));   //14
				System.out.println(leastInterval(tasks,n));
		}

	}


