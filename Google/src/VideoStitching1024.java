import java.util.Arrays;

public class VideoStitching1024 {
	 public static int videoStitching(int[][] clips, int T) {
			int[] dp = new int[T + 1];
			Arrays.fill(dp, T + 2);
			dp[0] = 0;

			for (int i = 0; i <= T; i++) {
				for (int[] clip : clips) {
					int start = clip[0];
					int end = clip[1];
					if (i >= start && i <= end)
						dp[i] = Math.min(dp[i], dp[start] + 1);
				}
			}

			return dp[T] == T + 2 ? -1 : dp[T];
		}
	

	public static void main(String[] args) {
		int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}; 
				int T = 10;
				System.out.println(videoStitching(clips,T));

	}

}
