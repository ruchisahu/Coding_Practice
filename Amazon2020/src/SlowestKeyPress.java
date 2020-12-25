
public class SlowestKeyPress {
public static char slowestKey(int[] releaseTimes, String keysPressed) {
	int maxTime=releaseTimes[0];
	char c=keysPressed.charAt(0);
	for(int i=1;i<releaseTimes.length;i++) {
		int diff=releaseTimes[i]-releaseTimes[i-1];
		if(maxTime< diff || (maxTime== diff && keysPressed.charAt(i) > c)) {
			maxTime=diff;
			c=keysPressed.charAt(i);
		}
		
	}
	return c;
        
    }

	public static void main(String[] args) {
		int[] releaseTimes = {9,29,49,50}; 
		String keysPressed = "cbcd";
		System.out.println(slowestKey(releaseTimes,keysPressed));

	}

}
