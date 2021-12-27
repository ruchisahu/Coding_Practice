import java.util.PriorityQueue;

public class PQTest {
    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        pq.offer(5);
        pq.offer(2);
        pq.offer(9);
        pq.offer(4);
        pq.offer(1);

        System.out.println(pq);
    }
}
