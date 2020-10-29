
public class PrisonCell
{
	 public static int[] prisonAfterNDays(int[] cells, int N) {
	        int rem = ((N-1)%14)+1;
		int temp[] = new int[cells.length];
		for(int day=0; day<rem; day++) {
			for(int i=1; i<temp.length-1; i++) 
				temp[i] = cells[i-1]==cells[i+1]? 1 : 0;
			System.arraycopy(temp, 0, cells, 0, cells.length);
		}
		for(int i=1; i<cells.length; i++) 
		{
			System.out.println(cells[i]);
		}
		return cells;
	    }
	
	public static void main(String[] args) 
	{
		int[] cells= {0,1,0,1,1,0,0,1};
		int N=7;
		prisonAfterNDays(cells,N);

	}

}
