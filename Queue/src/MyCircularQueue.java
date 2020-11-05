//https://leetcode.com/problems/design-circular-queue/
public class MyCircularQueue {
	
    
	 /** Initialize your data structure here. Set the size of the queue to be k. */
    final int[] a;
       int front, rear = -1, len = 0;

       public MyCircularQueue(int k) { a = new int[k];}

       public boolean enQueue(int val) {
           if (!isFull()) {
               rear = (rear + 1) % a.length;
               a[rear] = val;
               len++;
               return true;
           } else return false;
       }

       public boolean deQueue() {
           if (!isEmpty()) {
               front = (front + 1) % a.length;
               len--;
               return true;
           } else return false;
       }

       public int Front() { return isEmpty() ? -1 : a[front];}

       public int Rear() {return isEmpty() ? -1 : a[rear];}

       public boolean isEmpty() { return len == 0;}

       public boolean isFull() { return len == a.length;}


    

	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
		circularQueue.enQueue(1);  // return true
		circularQueue.enQueue(2);  // return true
		circularQueue.enQueue(3);  // return true
		circularQueue.enQueue(4);  // return false, the queue is full
		System.out.println(circularQueue.Rear());  // return 3
		circularQueue.isFull();  // return true
		circularQueue.deQueue();  // return true
		circularQueue.enQueue(4);  // return true
		System.out.println(circularQueue.Rear());  // return 4

	}

}
