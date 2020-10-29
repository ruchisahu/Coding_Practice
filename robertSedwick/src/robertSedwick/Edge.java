package robertSedwick;

public class Edge implements Comparable<Edge> {
	int v;
	int u;
	double weight;
	public Edge(int v,int u,double weight) {
		this.v=v;
		this.u=u;
		this.weight=weight;
	}
	
	public double weight() {
		return weight;
	}

	
	int either() {
		return v;
	}
	public int other(int w) {
		if(w==v)return u;
		else if(w==u) return v;
		else throw new RuntimeException("Inconsistent edge");
		
	}
	public int compareTo(Edge other) {
		if(this.weight <other.weight)return -1;
		else if(this.weight>other.weight)return 1;
		else
			return 0;
	}
	
	public String toString() {
		 return String.format("%d-%d %.5f", v, u, weight);
	}

}
