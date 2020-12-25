import java.util.ArrayList;
import java.util.List;

class Graph {
        public List<Integer>[] vertices;
        public int size;
        
        public Graph(int size) {
            this.vertices = new ArrayList[size];
            this.size = size;
            
            for (int i = 0; i < size; i++) {
                vertices[i] = new ArrayList();
            }
        }
        
         void addEdge(int i, int j) {
            System.out.printf("adding edge %d->%d\n", i, j);
            vertices[i].add(j);
        }
        
        public Iterable<Integer> adjacent(int v) {
            return vertices[v];
        }
    }