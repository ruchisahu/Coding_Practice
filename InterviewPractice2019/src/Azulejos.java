

	import java.util.*;
	import java.io.*;


public class Azulejos {

		public static int n;
		public static tile[] back;
		public static tile[] front;
		
		public static void main(String[] args) throws Exception {
			
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer tok = new StringTokenizer(stdin.readLine());
			n = Integer.parseInt(tok.nextToken());

			// Store the raw data for back tiles.
			int[] p1 = new int[n];
			tok = new StringTokenizer(stdin.readLine());
			for (int i=0; i<n; i++) p1[i] = Integer.parseInt(tok.nextToken());
			
			int[] h1 = new int[n];
			tok = new StringTokenizer(stdin.readLine());
			for (int i=0; i<n; i++) h1[i] = Integer.parseInt(tok.nextToken());		

			// Create the back tiles.
			back = new tile[n];
			for (int i=0; i<n; i++) back[i] = new tile(p1[i], h1[i], i+1, true);
			Arrays.sort(back);
			
			// Store raw data for front tiles.
			int[] p2 = new int[n];
			tok = new StringTokenizer(stdin.readLine());
			for (int i=0; i<n; i++) p2[i] = Integer.parseInt(tok.nextToken());
			
			int[] h2 = new int[n];
			tok = new StringTokenizer(stdin.readLine());
			for (int i=0; i<n; i++) h2[i] = Integer.parseInt(tok.nextToken());	
		
			// Create the front tiles.
			front = new tile[n];
			for (int i=0; i<n; i++) front[i] = new tile(p2[i], h2[i], i+1, false);	
			Arrays.sort(front);
			
			// Current price groups.
			int curpBack = back[0].price;
			int curpFront = front[0].price;
			
			// Load up TreeSets.
			int iBack = 0, iFront = 0;
			TreeSet<tile> tsBack = new TreeSet<tile>();
			while (iBack < n && back[iBack].price == curpBack) 
				tsBack.add(back[iBack++]);
			TreeSet<tile> tsFront = new TreeSet<tile>();
			while (iFront < n && front[iFront].price == curpFront) 
				tsFront.add(front[iFront++]);
			
		
			int[] backIdx = new int[n];
			int[] frontIdx = new int[n];
			int idx = 0;
			boolean okay = true;
			
			
			while (true) 
			{
				
				
				if (tsBack.size() < tsFront.size()) 
				{
					
					// Greedily match back items with largest possible item (smaller than it) from front.
					while (tsBack.size() > 0) {
						tile tBack = tsBack.pollFirst();
						tile tFront = tsFront.lower(tBack);
						
						// If none exists, we can't do it.
						if (tFront == null) {
							okay = false;
							break;
						}
						
						// Bookkeeping.
						tsFront.remove(tFront);
						backIdx[idx] = tBack.idx;
						frontIdx[idx++] = tFront.idx;
					}
					if (!okay) break;
				}
				
				// Equal or fewer pics in front.
				else {
					
					// Greedily match front items with smallest possible item (larger than it) from back.
					while (tsFront.size() > 0) {
						tile tFront = tsFront.pollFirst();
						tile tBack = tsBack.higher(tFront);
						
						// If none exists, we can't do it.
						if (tBack == null) {
							okay = false;
							break;
						}
						
						// Bookkeeping
						tsBack.remove(tBack);
						backIdx[idx] = tBack.idx;
						frontIdx[idx++] = tFront.idx;
					}				
					if (!okay) break;
				}
				
				// Done!
				if (idx == n) break;
				
				// Load stuff into empty tree sets.
				if (iBack < n && tsBack.size() == 0) {
					curpBack = back[iBack].price;
					while (iBack < n && back[iBack].price == curpBack) tsBack.add(back[iBack++]);
				}
				if (iFront < n && tsFront.size() == 0) {
					curpFront = front[iFront].price;
					while (iFront < n && front[iFront].price == curpFront) tsFront.add(front[iFront++]);
				}
			}
			
			// Output result.
			if (!okay)
				System.out.println("impossible");
			else {
				StringBuilder sb = new StringBuilder();
				for (int i=0; i<n-1; i++) sb.append(backIdx[i]+" ");
				sb.append(backIdx[n-1]+"\n");
				for (int i=0; i<n-1; i++) sb.append(frontIdx[i]+" ");
				sb.append(frontIdx[n-1]+"\n");
				System.out.print(sb);
			}		
		}
	}

	class tile implements Comparable<tile> 
	{

		public int price;
		public int height;
		public int idx;
		public boolean back;
		
		public tile(int p, int h, int i, boolean flag)
		{
			price = p;
			height = h;
			idx = i;
			back = flag;
		}
		
		public int compareTo(tile other) {
			
			// We compare items between sets only by height.
			if (back != other.back) return this.height - other.height;
			
			// Within sets by price then height.
			if (price != other.price)
				return price - other.price;
			if (height != other.height)
				return height-other.height;
			return idx - other.idx;
		}
	}