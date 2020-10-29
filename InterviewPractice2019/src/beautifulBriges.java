

	import java.util.*;

	public class beautifulBriges {


		public static int n;
		public static long h;
		public static long a;
		public static long b;
		public static long[] x;
		public static long[] y;
		
		public static void main(String[] args) {
		
			// Get basic parameters.
			Scanner stdin = new Scanner(System.in);
			//n = stdin.nextInt();
			//h = stdin.nextLong();
			//a = stdin.nextLong();
			//b = stdin.nextLong();
			n=5;
			h=60;
			a=18;
			b=2;
			// Get points.
			x = new long[n];
			y = new long[n];
		/*	for (int i=0; i<n; i++) {
				x[i] = stdin.nextLong();
				y[i] = stdin.nextLong();
			}
			*/
			x[0]=0;
			y[0]=0;
					x[1]=20;
					y[1]=20;
					x[2]=30;
					y[2]=10;	
					x[3]=50;
					y[3]=30;
					x[4]=70;
					y[4]=20;
			// Most we can go to the left or right for our DP.
			// Initialize based on height FROM bridge.
			long[] maxDeltaRight = new long[n];
			long[] maxDeltaLeft = new long[n];
			for (int i=0; i<n; i++) {
				maxDeltaRight[i] = 2*(h-y[i]);
				maxDeltaLeft[i] = 2*(h-y[i]);
			}
			
			// Go through all pairs now.
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					
					if (i == j) continue;
					
					// Two quantities that matter in forming the relevant semicircle.
					long dx = Math.abs(x[i]-x[j]);
					long dy = h - y[j];
					System.out.println("dx="+dx);
					System.out.println("dy="+dy);
					// How far we can move either left or right from index i.
					long move = (long)(2*(dx + dy + Math.sqrt(2*dx*dy)) + 1e-9);
					System.out.println("move"+move);
					// Update the appropriate side.
					if (i < j) 
						maxDeltaRight[i] = Math.min(maxDeltaRight[i], move);
					else    
						maxDeltaLeft[i] =  Math.min(maxDeltaLeft[i], move);
				}
			}
			
			for (int i=0; i<n; i++)
			{
				
					System.out.println("right="+i+maxDeltaRight[i]);
					System.out.println("left="+i+ maxDeltaLeft[i]);
				
				}
			
			// Store answers here.
			Long[] dp = new Long[n];
			Arrays.fill(dp, null);
			dp[0] = 0L;
			
			// i+1 is the right hand column we are currently building back from.
			for (int i=1; i<n; i++) {

				// Now we try building a bridge from 0 to j, then a single one from pillar j to pillar i+1.
				for (int j=i-1; j>=0; j--) {
					
					// j prevents us from building the arc from j to i.
					if (x[j] + maxDeltaRight[j] < x[i])
						continue;
					
					// We've gone to far for i, so we can get out.
					if (x[i] - maxDeltaLeft[i] > x[j]) break;
					
					// No answer to build off of.
					if (dp[j] == null) continue;
					
					// This is our best answer if we build an arc from j to i.
					long newval = dp[j] + a*(h-y[i])  + b*(x[i]-x[j])*(x[i]-x[j]);
					
					// Update if we have no previous answer or this is best.
					if (dp[i] == null || newval < dp[i])
						dp[i] = newval;
				}
			}
			
			// Ta da!
			if (dp[n-1] == null)
				System.out.println("impossible");
			else
				System.out.println(dp[n-1] + a*(h - y[0]) );
		}
	}