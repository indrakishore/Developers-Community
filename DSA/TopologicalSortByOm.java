import java.util.*;

public class TopologicalSort {


    static void
    topologicalSortUtil(int v, List<List<Integer> > adj,
                        boolean[] visited,
                        Stack<Integer> stack)
    {
    
        visited[v] = true;

        
        for (int i : adj.get(v)) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }

       
        stack.push(v);
    }

    static void topologicalSort(List<List<Integer> > adj,
                                int V)
    {
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }

     
        System.out.print(
            "Topological sorting of the graph: ");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

 
    public static void main(String[] args)
    {
  
        int V = 4;

   
        List<List<Integer> > edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(3, 2));

       
        List<List<Integer> > adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> i : edges) {
            adj.get(i.get(0)).add(i.get(1));
        }

        topologicalSort(adj, V);
    }
}
