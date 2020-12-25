
public class RoverControl {
	public static int roverPos(int n,String[] com) {
		int pos=0;
		int row=0;
		int col=0;
		//(row * size) + column
		for(String c:com) {
			if(c=="R") {
				if((pos+1)%n!=0) {
					pos=pos+1;
				}
			}
			if(c=="U") {
				int newPos=pos-n;
				if(newPos>=0)
					pos=newPos;
			}
			if(c=="D") {
				int newPos=pos+n;
				if(newPos<(n*n))
					pos=newPos;
			}
			if(c=="L") {
				if(pos%n!=0) {
					pos=pos-1;
				}
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		int[][] matrix= {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
		String[] commands = {"R", "U", "D", "L", "D", "D"};
		int n=4;
		System.out.println(roverPos(n,commands));
	}

}
