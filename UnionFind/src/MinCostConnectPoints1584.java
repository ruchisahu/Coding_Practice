import java.util.PriorityQueue;

public class MinCostConnectPoints1584 {
	class point{
		int x,y,dis;
		point(int x,int y,int dis){
			this.x=x;
			this.y=y;
			this.dis=dis;
		}
	}
	//kruskal min spanning tree
public int minCostConnectPoints(int[][] points) {
	int n=points.length;
	int minCost=0;
	PriorityQueue<point>pq=new PriorityQueue<>((a,b)->a.dis-b.dis);
	for(int i=0;i<n;i++) {
		for(int j=i+1;j<n;j++) {
			int dis=manhattanDis(points,i,j);
			point p=new point(i,j,dis);
			pq.add(p);
		}
	}
	int count=0;
	UF uf=new UF(n);
	while(count< n-1) {
		point p=pq.poll();
		if(uf.find(p.x)!=uf.find(p.y)) {
			minCost+=p.dis;
			count++;
			uf.union(p.x,p.y);
		}
		
	}
	
	
	return minCost;
        
    }

	private static int manhattanDis(int[][] points, int a, int b) {
		return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
		
	}

	public static void main(String[] args) {
		MinCostConnectPoints1584 dis=new MinCostConnectPoints1584();
		int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
		System.out.println(dis.minCostConnectPoints(points));   //20
	}

}
