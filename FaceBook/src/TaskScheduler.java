import java.util.Arrays;

public class TaskScheduler {
	 public static int leastInterval(char[] tasks, int n) {
    int[] counter = new int[26];
   int space = 0;
   int maxCount = 0;
   for(char task : tasks) 
   {
       counter[task - 'A']++;
   }

   
   Arrays.sort(counter);
   int i=0;
  
   int len=counter.length-1;
   maxCount=counter[len] -1 ;
  
   space = maxCount*n;
   
   for(int j=len-1;j>0;j--)
   {
   	space=space - Math.min(maxCount, counter[j]);
   	
   }
  
   
	return (space>0)?space + tasks.length: tasks.length;
       
   }
// 
	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B','C','C','C','D','D','D'};
		int n = 2;
		System.out.println(leastInterval(tasks,n));

	}

}
