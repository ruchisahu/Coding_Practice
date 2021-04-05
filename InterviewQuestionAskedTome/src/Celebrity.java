//277 leetcode
public class Celebrity {
	public int findCelebrity(int n) {
	    int suspectedCelebrity = 0;
	    for (int i = 1; i < n; i++) {
	      if (knows(suspectedCelebrity, i)) {
	        suspectedCelebrity = i;
	      }
	    }
	    for (int i = 0; i < n; i++) { 
	      if (i != suspectedCelebrity && (knows(suspectedCelebrity, i) || !knows(i, suspectedCelebrity))) {
	        return -1;
	      }
	    }
	    return suspectedCelebrity;
	  }

	private boolean knows(int suspectedCelebrity, int i) {
		// TODO Auto-generated method stub
		return false;
	}
}