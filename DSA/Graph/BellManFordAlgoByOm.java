// Bellman-Ford Algorithm - Finding the shortest path in a graph with negative edge cycles

// Problem Statement:
// The Bellman-Ford algorithm computes the shortest paths from a source vertex to all other vertices 
// in a weighted graph. It can handle graphs with negative weight edges and can detect negative weight cycles.
// If a negative weight cycle is reachable from the source, the algorithm reports its existence.

import java.io.*;
import java.lang.*;
import java.util.*;

class Graph {
  
    class Edge {
        int src, dest, weight;
        Edge() { src = dest = weight = 0; }
    }

    int V, E; // Number of vertices and edges
    Edge edge[];

    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    void BellmanFord(Graph graph, int src) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        // Initialize distances from the source to all other vertices as infinite
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0; // Distance from the source to itself is zero

        // Relax all edges |V| - 1 times
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                // Update distance if the edge relaxes
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Check for negative weight cycles
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            // If the distance can still be relaxed, a negative weight cycle exists
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        
        printArr(dist, V); // Print the distance array
    }

    void printArr(int dist[], int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int E = 8; // Number of edges

        Graph graph = new Graph(V, E);

        // Adding edges to the graph
        graph.edge[0].src = 0; graph.edge[0].dest = 1; graph.edge[0].weight = -1;
        graph.edge[1].src = 0; graph.edge[1].dest = 2; graph.edge[1].weight = 4;
        graph.edge[2].src = 1; graph.edge[2].dest = 2; graph.edge[2].weight = 3;
        graph.edge[3].src = 1; graph.edge[3].dest = 3; graph.edge[3].weight = 2;
        graph.edge[4].src = 1; graph.edge[4].dest = 4; graph.edge[4].weight = 2;
        graph.edge[5].src = 3; graph.edge[5].dest = 2; graph.edge[5].weight = 5;
        graph.edge[6].src = 3; graph.edge[6].dest = 1; graph.edge[6].weight = 1;
        graph.edge[7].src = 4; graph.edge[7].dest = 3; graph.edge[7].weight = -3;

        graph.BellmanFord(graph, 0); // Execute Bellman-Ford algorithm
    }
}
