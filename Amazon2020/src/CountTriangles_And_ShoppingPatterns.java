import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountTriangles_And_ShoppingPatterns {
	private static int getShoppingPatternsTrioMinimum(int numOfProducts,List<Integer> products_from, List<Integer> products_to) {
if(numOfProducts < 1 || products_from == null || products_to == null || products_to.size() != products_from.size()) return -1;
		
		Map<Integer,Set<Integer>> graph = new HashMap<>();
		for(int i=1;i<=numOfProducts;i++){
			graph.put(i,(new HashSet<Integer>()));
		}
		
		for(int i=0;i<products_from.size();i++){
			//since its undirected
			graph.get(products_from.get(i)).add(products_to.get(i));
			graph.get(products_to.get(i)).add(products_from.get(i));
		}
		
		int count =  Integer.MAX_VALUE;
		for(int i=1;i<=numOfProducts;i++){
			for(int j=i+1;j<=numOfProducts;j++){
				for(int k=j+1;k<=numOfProducts;k++){
					if(graph.get(i).contains(j) && graph.get(j).contains(k) && graph.get(k).contains(i)){
						// these vertices forms a TRio
						int val = (graph.get(i).size() + graph.get(j).size() + graph.get(k).size()) - 6;
						count =  Math.min(count, val);		
					}
				}	
			}
		}
		return count;
	}
		
	private static int getTriangleCount(int numOfProducts,List<Integer> products_from, List<Integer> products_to) {
		Map<Integer,Set<Integer>> graph = new HashMap<>();
		for(int i=1;i<=numOfProducts;i++){
			graph.put(i,(new HashSet<Integer>()));
		}
		
		for(int i=0;i<products_from.size();i++){
			//since its undirected
			graph.get(products_from.get(i)).add(products_to.get(i));
			graph.get(products_to.get(i)).add(products_from.get(i));
		}
		
		int countTriangles =  Integer.MAX_VALUE;
		for(int i=1;i<=numOfProducts;i++){
			for(int j=i+1;j<=numOfProducts;j++){
				for(int k=j+1;k<=numOfProducts;k++){
					if(graph.get(i).contains(j) && graph.get(j).contains(k) && graph.get(k).contains(i)){
						countTriangles++;
					}
				}	
			}
		}
		countTriangles /= 6;
		return countTriangles;
	}

	public static void main(String[] args) {
		int numOfProducts = 6;
		int[] productsFrom = {1,2,2,3,4,5};
		int[] productsTo = {2,4,5,5,5,6};
		List<Integer> products_from = new ArrayList<Integer>();
		List<Integer> products_to = new ArrayList<Integer>();
		for (int i : productsFrom)
		{
			products_from.add(i);
		}
		
		for (int i : productsTo)
		{
			products_to.add(i);
		}
		
		int min = getShoppingPatternsTrioMinimum(numOfProducts,products_from,products_to);
		System.out.println(min);
		
		int trianglesCount = getTriangleCount(numOfProducts,products_from,products_to);
		System.out.println(trianglesCount);

	}

}
