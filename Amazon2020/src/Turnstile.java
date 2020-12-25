import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/discuss/interview-question/699973/
public class Turnstile {
    public static int[] getTimes(int[] time, int[] direction) {
        Queue<Integer> enters = new LinkedList<Integer>();
        Queue<Integer> exits = new LinkedList<Integer>();
        int n = time.length;
        for(int i = 0; i < n; i++) {
            Queue<Integer> q = direction[i] == 1 ? exits : enters;
            q.offer(i);
        }

        int[] result = new int[n];
        int lastTime = -2;
        Queue<Integer> lastQ = exits;
        while(enters.size() > 0 && exits.size() > 0) {
            int currentTime = lastTime + 1;
            int peekEnterTime = time[enters.peek()];
            int peekExitTime = time[exits.peek()];
            Queue<Integer> q;
            if (currentTime < peekEnterTime && currentTime < peekExitTime) {
                // The turnstile was not used
                // Take whoever has the earliest time or
                // if enter == exit, take exit
                q = (peekEnterTime < peekExitTime) ? enters : exits;
                int personIdx = q.poll();
                result[personIdx] = time[personIdx];
                lastTime = time[personIdx]; // time
                lastQ = q;
            } else {
                // Turnstile was used last second
                if (currentTime >= peekEnterTime && currentTime >= peekExitTime) {
                    // Have people waiting at both ends
                    // Prioritize last direction
                    q = lastQ;
                } else {
                    // current >= enters.peek() || current >= exits.peek()
                    q = currentTime >= peekEnterTime ? enters : exits; // take whatever that's queuing
                }
                int personIdx = q.poll();
                result[personIdx] = currentTime;
                lastTime = currentTime; // time
                lastQ = q;
            }
        }

        Queue<Integer> q = enters.size() > 0 ? enters : exits;
        while(q.size() > 0) {
            int currentTime = lastTime + 1;
            int personIdx = q.poll();
            if (currentTime < time[personIdx]) {
                // The turnstile was not used
                currentTime = time[personIdx];
            }

            result[personIdx] = currentTime;
            lastTime = currentTime; // time
        }

        return result;
    }

    public static void test(int[] time, int[] direction, int[] expected) {
        int[] result = getTimes(time, direction);
        System.out.println("ACTUAL: " + Arrays.toString(result));
        System.out.println("EXPECTED: " + Arrays.toString(expected));
    }

    public static void runner() {
        System.out.println("Turnstile");
        test(new int[] {0, 0, 1, 5}, new int[] {0,1,1,0}, new int[] {2, 0, 1, 5});
        test(new int[] {0, 0, 5, 5}, new int[] {0,1,1,0}, new int[] {1, 0, 5, 6});
        test(new int[] {0, 0, 1, 1}, new int[] {0,1,1,0}, new int[] {2, 0, 1, 3});
        test(new int[] {0, 0, 0, 0}, new int[] {0,1,1,0}, new int[] {2, 0, 1, 3});
        test(new int[] {0, 0, 0, 0}, new int[] {0,0,0,0}, new int[] {0, 1, 2, 3});
        test(new int[] {0, 0, 1, 3, 10}, new int[] {0,1,1,1,0}, new int[] {2, 0, 1, 3, 10});
        test(new int[] {0, 1, 1, 3, 3}, new int[] {0, 1, 0, 0, 1}, new int[] {0,2,1,4,3});
    }

	public static void main(String[] args) {
		runner();

	}

}
