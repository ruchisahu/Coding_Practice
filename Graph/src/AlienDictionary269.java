//https://zhuhan0.blogspot.com/search/label/Graph?updated-max=2017-07-27T23:04:00-07:00&max-results=20&start=4&by-date=false

//issue with sol1 is does not work correctly with character in differnt order although work fine with order start with a and everything is in order.

		import java.util.*; 
 

		public class AlienDictionary269
		{ 
		
			private static void alienOrder(String[] words, int alpha) 
			{ 
				Digraph graph = new Digraph(alpha); 

				for (int i = 0; i < words.length - 1; i++) 
				{ 
					String word1 = words[i]; 
					String word2 = words[i+1]; 
					for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) 
					{ 
					
						if (word1.charAt(j) != word2.charAt(j)) 
						{ 
							graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j)- 'a'); 
							break; 
						} 
					} 
				}  
				System.out.println(graph);
				topologicalSort(graph,alpha); 
			} 
			 // Topological Sort of the complete graph 
						public static void topologicalSort(Digraph G,int V) 
						{ 
							Stack<Integer> stack = new Stack<>(); 
							boolean[] visited = new boolean[G.V()]; 
							for (int i = 0; i < G.V(); i++) 
							{ 
								visited[i] = false; 
							} 

							for (int i = 0; i < G.V(); i++) 
							{ 
								if (!visited[i]) 
								{ 
									topologicalSortUtil(i, visited, stack,G); 
								} 
							} 

							 
							while (!stack.isEmpty()) 
							{ 
								System.out.print((char)('a' + stack.pop()) + " "); 
							} 
						} 
						
						
						private static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack,Digraph G) 
						{ 
							visited[v] = true; 
							for (int w : G.adj(v)) 
							{ 
								if (!visited[w]) 
								{ 
									topologicalSortUtil(w, visited, stack,G); 
								} 
							} 

							stack.push(v); 
						} 
//sol2
						public static String alienOrder(String[] words) {
					        Map<Character, Set<Character>> graph = new HashMap<>();
					        int[] inDegree = new int[26];
					        buildGraph(words, graph, inDegree);
					        
					        String order = topologicalSort(graph, inDegree);
					        return order.length() == graph.size() ? order : "";
					    }
					    
					    private static void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
					        for (String word : words) {
					            for (char c : word.toCharArray()) {
					                graph.put(c, new HashSet<>());
					            }
					        }
					        
					        for (int i = 1; i < words.length; i++) {
					            String first = words[i - 1];
					            String second = words[i];
					            int length = Math.min(first.length(), second.length());
					            
					            for (int j = 0; j < length; j++) {
					                char parent = first.charAt(j);
					                char child = second.charAt(j);
					                if (parent != child) {
					                    if (!graph.get(parent).contains(child)) {
					                        graph.get(parent).add(child);
					                        inDegree[child - 'a']++;
					                    }
					                    break;
					                }
					            }
					        }
					    }
					    
					    private static String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
					        Queue<Character> queue = new LinkedList<>();
					        for (char c : graph.keySet()) {
					            if (inDegree[c - 'a'] == 0) {
					                queue.offer(c);
					            }
					        }
					        
					        StringBuilder sb = new StringBuilder();
					        while (!queue.isEmpty()) {
					            char c = queue.poll();
					            sb.append(c);
					            System.out.println("add :"+c);
					            for (char neighbor : graph.get(c)) {
					                inDegree[neighbor - 'a']--;
					                if (inDegree[neighbor - 'a'] == 0) {
					                    queue.offer(neighbor);
					                }
					            }
					        }
					        return sb.toString();
					    }
					

	public static void main(String[] args) {
		String[] words= {"wrt", "wrf", "er",  "ett", "rftt"};
		System.out.println(alienOrder(words));
		
		String[] words1 = {"caad", "aaa", "aab","abce"}; 
		System.out.println(alienOrder(words1));
		alienOrder(words1,5);

	}

}
