import java.util.*;

/*
 There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    Otherwise, it becomes vacant.

(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

 

Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]


 */
public class PrisonCell 
{
public static int[] prisonAfterNDays(int[] cells, int N)
{
	int temp[] = new int[cells.length];
	for(int day=0; day<N; day++) 
	{
		for(int i=1; i<temp.length-1; i++) 
			temp[i] = cells[i-1]==cells[i+1]? 1 : 0;
		System.arraycopy(temp, 0, cells, 0, cells.length);
	}
	
			  
	   for(int k=0;k<=cells.length-1;k++)
	   {
		   System.out.println(cells[k]);
	   }
        return cells;
 }

//sol2
public int[] prisonAfterNDays1(int[] cells, int N) {

	if(cells==null || cells.length==0 || N<=0) return cells;

    boolean hasCycle = false;

    int cycle = 0;

    HashSet<String> set = new HashSet<>(); 

    for(int i=0;i<N;i++){

        int[] next = nextDay(cells);

        String key = Arrays.toString(next);

        if(!set.contains(key)){ //store cell state

            set.add(key);

            cycle++;

        }

        else{ //hit a cycle

            hasCycle = true;

            break;

        }

        cells = next;

    }

    if(hasCycle){

        N%=cycle;

        for(int i=0;i<N;i++){

            cells = nextDay(cells);

        }   

    }

    return cells;

}



private int[] nextDay(int[] cells){

    int[] tmp = new int[cells.length];

    for(int i=1;i<cells.length-1;i++){

        tmp[i]=cells[i-1]==cells[i+1]?1:0;

    }

    return tmp;

}


	public static void main(String[] args) {
		int[] cells = {0,1,0,1,1,0,0,1};
				int N = 7;
				prisonAfterNDays(cells,N);
	}

}
