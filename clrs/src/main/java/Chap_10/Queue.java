package Chap_10;

public class Queue {
	int size;
	int[] arr;
	int front, rear;
	int capacity;
	
	Queue(int n){
	    size=0;
		int capacity=n;
		arr=new int[n];
		front=rear=-1;
		
	}
	public void enqueue(int element) {
		if (isFull()) {
		      System.out.println("Queue is full");
		      System.exit(1);
		     
		    } else {
		      if (front == -1)
		        front = 0;
		    
		      arr[++rear] = element;
		      size++;
		      System.out.println("Inserted " + element);
		    }
	}
	
	public int dequeue() {
		 int element;
		    if (isEmpty()) {
		      System.out.println("Queue is empty");
		      return (-1);
		    } else {
		      element = arr[front];
		      if (front >= rear) {
		        front = -1;
		        rear = -1;
		      } /* Q has only one element, so we reset the queue after deleting it. */
		      else {
		        front++;
		      }
		      System.out.println("Deleted -> " + element);
		      return (element);
		    }
		}
	
	
	public boolean isFull() {
		if(front==0 && rear==capacity-1)return true;
		else return false;
	}
	
	public boolean isEmpty() {
		if(front==-1)return true;
		else return false;
	}
	public int getSize() {
        return size;
    }

	public static void main(String[] args) {
		Queue q = new Queue(5);

	    // deQueue is not possible on empty queue
	    q.dequeue();

	    // enQueue 5 elements
	    q.enqueue(1);
	    q.enqueue(2);
	    q.enqueue(3);
	    q.enqueue(4);
	    q.enqueue(5);

	    // 6th element can't be added to queue because queue is full
	    q.enqueue(6);

	}

}
