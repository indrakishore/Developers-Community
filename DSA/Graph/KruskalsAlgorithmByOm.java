

// Problem Statement:
// Implement Kruskal's Algorithm to find the Minimum Spanning Tree (MST) of a given connected, undirected, and weighted graph. 
// The input graph is represented as a collection of edges, where each edge has a source vertex, a destination vertex, and a weight. 
// The goal is to find the subset of edges that connects all the vertices with the minimum possible total weight, avoiding any cycles.


import java.util.ArrayList; 
import java.util.Comparator; 
import java.util.List; 

public class KruskalsMST { 

    // Class to represent an edge between two vertices with a certain weight
	static class Edge { 
		int src, dest, weight; 

		public Edge(int src, int dest, int weight) { 
			this.src = src; 
			this.dest = dest; 
			this.weight = weight; 
		} 
	} 

    // Class to represent a subset for union-find
	static class Subset { 
		int parent, rank; 

		public Subset(int parent, int rank) { 
			this.parent = parent; 
			this.rank = rank; 
		} 
	} 

	public static void main(String[] args) { 
		// Number of vertices in the graph
		int V = 4; 
		// List of edges in the graph, with each edge defined by source, destination, and weight
		List<Edge> graphEdges = new ArrayList<Edge>( 
			List.of(new Edge(0, 1, 10), new Edge(0, 2, 6), 
					new Edge(0, 3, 5), new Edge(1, 3, 15), 
					new Edge(2, 3, 4))); 

		// Sort the edges based on their weights in ascending order
		graphEdges.sort(new Comparator<Edge>() { 
			@Override public int compare(Edge o1, Edge o2) { 
				return o1.weight - o2.weight; 
			} 
		}); 

		// Apply Kruskal's algorithm to find the MST
		kruskals(V, graphEdges); 
	} 

	// Method to implement Kruskal's algorithm
	private static void kruskals(int V, List<Edge> edges) { 
		int j = 0;  // Initialize an index to pick the next edge
		int noOfEdges = 0;  // Number of edges in MST so far

		// Create an array of subsets for union-find
		Subset subsets[] = new Subset[V]; 
		// Array to store the resulting MST edges
		Edge results[] = new Edge[V]; 

		// Initialize each vertex as its own parent (disjoint set) with rank 0
		for (int i = 0; i < V; i++) { 
			subsets[i] = new Subset(i, 0); 
		} 

		// Process the edges one by one in increasing order of their weight
		while (noOfEdges < V - 1) { 
			// Pick the smallest edge
			Edge nextEdge = edges.get(j); 
			// Find the roots of the source and destination vertices of the edge
			int x = findRoot(subsets, nextEdge.src); 
			int y = findRoot(subsets, nextEdge.dest); 

			// If including this edge does not form a cycle, include it in the MST
			if (x != y) { 
				results[noOfEdges] = nextEdge; 
				union(subsets, x, y); // Perform union of two sets
				noOfEdges++; 
			} 

			j++; // Move to the next edge
		} 

		// Display the edges included in the MST
		System.out.println("Following are the edges of the constructed MST:"); 
		int minCost = 0; 
		for (int i = 0; i < noOfEdges; i++) { 
			System.out.println(results[i].src + " -- "
							+ results[i].dest + " == "
							+ results[i].weight); 
			minCost += results[i].weight; 
		} 
		// Display the total cost of the MST
		System.out.println("Total cost of MST: " + minCost); 
	} 

	// Method to perform union of two subsets
	private static void union(Subset[] subsets, int x, int y) { 
		int rootX = findRoot(subsets, x); 
		int rootY = findRoot(subsets, y); 

		// Attach the smaller rank tree under the root of the higher rank tree
		if (subsets[rootY].rank < subsets[rootX].rank) { 
			subsets[rootY].parent = rootX; 
		} 
		else if (subsets[rootX].rank < subsets[rootY].rank) { 
			subsets[rootX].parent = rootY; 
		} 
		else { 
			subsets[rootY].parent = rootX; 
			subsets[rootX].rank++; 
		} 
	} 

	// Method to find the root of a subset (with path compression)
	private static int findRoot(Subset[] subsets, int i) { 
		// If the node is not the parent of itself, find its root recursively
		if (subsets[i].parent == i) 
			return subsets[i].parent; 

		// Path compression optimization
		subsets[i].parent = findRoot(subsets, subsets[i].parent); 
		return subsets[i].parent; 
	} 
}
