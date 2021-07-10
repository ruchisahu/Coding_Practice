import java.util.Arrays;
//Complexity:

//Time: O(N* (3^3) ^ 2) = O(27*N)
//Space O(3^3)
public class PaintGrid1411 {
	int MOD = 1000000007;
    public int numOfWays(int n) {
    	long[] f=new long[27];
    	long[] g=new long[27];
    	Arrays.fill(f,0);
    	Arrays.fill(g,0);
    	

    	for(int i = 0; i < 27; ++i) {
    		int x1=0, x2=0, x3=0;
    		getColor(i, x1, x2, x3);
    		if(!valid(x1, x2, x3)) continue;
    		f[i] = 1;
    	}
    	for(int k = 1; k < n; ++k) {
    		for(int i = 0; i < 27; ++i) {
    			int x1=0, x2=0, x3=0;
    			getColor(i, x1, x2, x3);
    			g[i] = 0;
    			if(!valid(x1, x2, x3)) continue;
    			for(int j = 0; j < 27; ++j) {
    				int y1=0, y2=0, y3=0;
    				getColor(j, y1, y2, y3);
    				if(!valid(y1, y2, y3) || y1 == x1 || y2 == x2 || y3 == x3) continue;
    				g[i] = (g[i] + f[j]) % MOD;
    			}
    		}
    		swap(g, f);
    	}
    	long ans = 0;
    	for(long i : f)
    		ans = (ans + i) % MOD;
    	return (int) ans; 
    }
    private void swap(long[] g, long[] f) {
		long[] t=g;
		g=f;
		f=t;
		
	}
	Boolean valid(int x1, int x2, int x3) {
    	return x1 != x2 && x2 != x3;
    }

    void getColor(int state,int x1, int x2, int x3) {
    	x1 = state/9;
    	x2 = state/3 % 3;
    	x3 = state%3;
    }

	public static void main(String[] args) {
		PaintGrid1411 p=new PaintGrid1411();
		p.numOfWays(2);

	}

}
