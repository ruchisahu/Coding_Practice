import java.util.*;

//https://www.geeksforgeeks.org/job-sequencing-problem/
//https://www.youtube.com/watch?v=zPtI8q9gvX8&t=100s
//The time complexity of this problem is O(n2). 
public class JobSequencingWithDeadline {
	 void JobScheduling(ArrayList<Job> arr, int t) 
	    { 
		 int n=arr.size();
		 Collections.sort(arr,(a,b)->b.profit-a.profit);
		 int j,k;
		 int maxprofit = 0;
		 int filledTimeslot=0;
		 int dmax=0;
		 for(int i=0;i<n;i++) {
			 if(dmax<arr.get(i).deadline) {
				 dmax=arr.get(i).deadline;
			 }
		 }
		 int[] timeSlot=new int[dmax+1];
		 System.out.println("max deadline"+dmax);
		 //free timeslot
		 for(int i = 1; i <= dmax; i++) {
			    timeSlot[i] = -1;
			  }
		 
		 for(int i=1;i<=n;i++) {
			 k=Math.min(dmax, arr.get(i-1).deadline);
			 while(k>=1) {
				 if(timeSlot[k]==-1) {
					 timeSlot[k]=i-1;
					 filledTimeslot++;
					 break;
				 }
				 k--;
			 }
			  //if all time slots are filled then stop
			    if(filledTimeslot == dmax) {
			      break;
			    }
		   }
		 //jobs
		 for(int i=1;i<=dmax;i++) {
			 System.out.println(i+" :"+ arr.get(timeSlot[i]).id);
		 }
		 //maxProfit
		 for(int i = 1; i <= dmax; i++) {
			 maxprofit+=arr.get(timeSlot[i]).profit;
		 }
		 
		 System.out.println("maxprofit:"+maxprofit);
		 }
	    
	
	
	public static void main(String[] args) {
		 ArrayList<Job> arr = new ArrayList<Job>(); 
		  
	        arr.add(new Job('a', 2, 100)); 
	        arr.add(new Job('b', 1, 19)); 
	        arr.add(new Job('c', 2, 27)); 
	        arr.add(new Job('d', 1, 25)); 
	        arr.add(new Job('e', 3, 15)); 
	        
	        // Function call 
	        System.out.println("Following is maximum "
	                           + "profit sequence of jobs"); 
	  
	        JobSequencingWithDeadline job = new JobSequencingWithDeadline(); 
	        job.JobScheduling(arr, 3);
	   

	}

}
