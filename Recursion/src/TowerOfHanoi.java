
public class TowerOfHanoi {
	// n : Number of plates
	// Origin: 1st tower, Buffer: Tower that will be used as buffer , Destination: Tower on which all plates has to transferred.
	static int count = 0;
	static void recursive_toh(int N, char from, char to, char using){
		if (N == 1) {
			// base condition. If only one disk is there we can directly move it to target
			System.out.println ("Removing Disk 1 from rod"+ from +" and placing on rod" +to);
			count = count+1;
			return;
		}
		// see code explanation part for clear understanding of these 3 lins
		recursive_toh( N-1, from, using, to); 
		System.out.println ("Removing Disk "+N+" from rod"+ from +" and placing on rod" +to);
		count = count+1;
		recursive_toh( N-1, using, to, from);
	}
	public static void main(String[] args) {
		int N = 4; //Number of disks
		recursive_toh(N,'1','3','2'); // Meaning of this line is
		// Move N disks from rod 1 to rod 3 using rod 2
		System.out.println("Minimum No of disk movements for "+N+" disks is "+count);
	}
}
