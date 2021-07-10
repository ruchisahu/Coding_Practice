import java.util.*;
//https://leetcode.com/problems/minimum-area-rectangle/discuss/192072/java-sweep-line
public class MinimumAreaRectangle {
	 public static int minAreaRect(int[][] points) {
		  
		        if (points.length < 4)
		            return 0;
		        List<Integer>[] bkts = new List[40001];
		        int minX = 40001, maxX = -1;
		        for (int[] point : points) {
		            if (bkts[point[0]] == null)
		                bkts[point[0]] = new ArrayList<>();
		            bkts[point[0]].add(point[1]);
		            minX = Math.min(minX, point[0]);
		            maxX = Math.max(maxX, point[0]);
		        }
		        int min = Integer.MAX_VALUE;
		        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
		        for (int x = minX; x <= maxX; x++) {
		            if (bkts[x] != null) {
		                List<Integer> l = bkts[x];
		                Collections.sort(l);
		                for (int i = 0; i < l.size() - 1; i++) {
		                    for (int j = i+1; j < l.size(); j++) {
		                        Pair<Integer, Integer> key = new Pair<>(l.get(i), l.get(j));
		                        if (map.containsKey(key)) {
		                            int area = (key.getValue() - key.getKey()) * (x - map.get(key));
		                            if (area < min) min = area;
		                        }
		                        map.put(key, x);
		                    }
		                }
		            }
		        }
		        return min == Integer.MAX_VALUE ? 0 : min;
	    }
	  class Point{
	        int x, y;
	        Point(int i, int j){ x =i; y =j; }
	        @Override
	        public boolean equals(Object obj){
	            return (((Point) obj).x == this.x) && (((Point) obj).y == this.y);
	        }
	        
	        @Override
	        public int hashCode(){ return Objects.hash(x,y); }
	    }
	    
	    public int minAreaRect1(int[][] points) {
	        Set<Point> allPoints = new HashSet<>();
	        int result = Integer.MAX_VALUE;
	        for(int[] p:points){
	            allPoints.add(new Point(p[0],p[1]));
	        }
	        /* Assume p1 and p2 are diagonals, check if there are p3, p4 available in given points*/
	        for(Point p1:allPoints){
	            for(Point p2:allPoints){
	                if(p1.equals(p2) || p1.x == p2.x || p2.y==p1.y) continue;
	                Point p3 = new Point(p1.x,p2.y);
	                Point p4 = new Point(p2.x,p1.y);
	                if(allPoints.contains(p3) && allPoints.contains(p4)){
	                    int area = Math.abs(p1.x-p2.x)*Math.abs(p1.y-p2.y);
	                    result = Math.min(area,result);
	                }
	            }
	        }
	        if(result==Integer.MAX_VALUE) return 0;
	        return result;
	    }

	public static void main(String[] args) {
		MinimumAreaRectangle m=new MinimumAreaRectangle();
		int[][]points = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
				System.out.println(m.minAreaRect1(points));

	}

}
