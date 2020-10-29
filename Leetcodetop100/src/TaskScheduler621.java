import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TaskScheduler621 {
public static int leastInterval(char[] tasks, int n) 
{
	int[] counter = new int[26];
    int space = 0;
    int maxCount = 0;
    for(char task : tasks) 
    {
        counter[task - 'A']++;
    }
 //   Comparator<Object> cms = Collections.reverseOrder();
	//Arrays.sort(taks, cms);
   // Arrays.sort(counter, Collections.reverseOrder());
    
    Arrays.sort(counter);
    int i=0;
    for(int c : counter) 
    {
    	 System.out.println(i++ +"  "+c);
    }
    int len=counter.length-1;
    maxCount=counter[len] -1 ;
    System.out.println("maxcount="+maxCount);
    space = maxCount*n;
    System.out.println("space="+space);
    for(int j=len-1;j>0;j--)
    {
    	space=space - Math.min(maxCount, counter[j]);
    	System.out.println(space);
    }
    /* without sorting
     {
    	int idleSlots=(most-1)*n;
        for(int i=0;i<25;i++)
        {
            if(instances[i]>0)
                idleSlots-=(instances[i]==most)?(most-1):instances[i];
        }
        return countTasks+max(0,idleSlots);
    }
     */
    
	return (space>0)?space + tasks.length: tasks.length;
        
    }

//sol2
public int leastInterval1(char[] tasks, int n) {
    if(n == 0) return tasks.length;
    int[] count = new int[27];
    int max = 0;
    for(char c: tasks) {
        count[c - 'A']++;
        max = Math.max(max, count[c - 'A']);
    }
    int occurrences = 0, sum = 0;
    for(int i: count){
        if(i == max) occurrences++;
        sum += i;
    }
    if((sum - (occurrences*max)) / n >= max) return sum;
    return (max-1)*(n+1) + occurrences;
}

	public static void main(String[] args) {
		char[] tasks= {'A','A','A','B','B','B'};
				int n=2;
		System.out.println(leastInterval(tasks,n));

	}

}
